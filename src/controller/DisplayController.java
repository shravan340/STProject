package controller;
import inputs.ComputeSimulationState;
import inputs.Position;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DisplayController extends JFrame {
	private static int timeUntilLanding;
	private static int speed;
	private static int altitude;
	private static Position gearPosition;
	private static boolean gearOverrideWarningStatus;
	private static boolean airBrakeWarningStatus;
	private static boolean gearNotDownAlarmStatus;
	private static boolean gearAirSpeedAlarmStatus;
	private static boolean silenceAlarmSetting;
	 static JLabel lbUAltitude;
	static JLabel lbUSpeed;
	static JLabel lbUUp;
	static JLabel lbUDown;
	static JLabel lbUAirResistance;
	static JLabel lbUAltitudeLoss;
	static JLabel lbULandingTimeCountDown;
	public JPanel contentPane;
	static JLabel lbLandingGearOverride;
	static JLabel lbGearAirSpeed;
	static JLabel lbGearNotDown;
	static JLabel lbBrakingOverride;
			
	public void run(){
		DisplayController frame = new DisplayController();
		frame.setVisible(true); 
		}
	public static void main(String[] args) {
		DisplayController frame = new DisplayController();
		frame.setVisible(true);
		int timeUntillLanding = Integer.parseInt(lbULandingTimeCountDown.getText());
		int speedUntillLanding = Integer.parseInt(lbUSpeed.getText());
	    int altitudeUntillLanding = Integer.parseInt(lbUAltitude.getText());
		if((timeUntillLanding >= 0 && timeUntillLanding <= 250)&&(speedUntillLanding >= 0 && 
				speedUntillLanding <= 500)&&(altitudeUntillLanding >=0 && altitudeUntillLanding <=5000)){	
		while(true)
			{
			timeUntillLanding = Integer.parseInt(lbULandingTimeCountDown.getText())-1;
			speedUntillLanding = Integer.parseInt(lbUSpeed.getText())-5;
		    altitudeUntillLanding = Integer.parseInt(lbUAltitude.getText())-20;

		    if((timeUntillLanding > 0 && (speedUntillLanding <0 ||altitudeUntillLanding <0 )) || (timeUntillLanding <= 0 && (speedUntillLanding >=5 ||altitudeUntillLanding >=20 || ComputeSimulationState.isGearNotDownAlarmOn() == true )) )
		      {
		    	    lbULandingTimeCountDown.setText("Failed");
					lbULandingTimeCountDown.setForeground(Color.RED);
					break;
		      }
		    if(timeUntillLanding <= 0 && speedUntillLanding <= 0 && altitudeUntillLanding <= 0 )
			{
				lbULandingTimeCountDown.setText("Landed");
				lbUSpeed.setText("0");
				lbUAltitude.setText("0");
				lbULandingTimeCountDown.setForeground(Color.GREEN);
				break;	
			}
			else
		      {
			  lbULandingTimeCountDown.setText(String.valueOf(timeUntillLanding));
		      lbUSpeed.setText(String.valueOf(speedUntillLanding));
		      lbUAltitude.setText(String.valueOf(altitudeUntillLanding));
		      Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());		      
		      ComputeSimulationState.computeSimulationState(altitudeUntillLanding, speedUntillLanding, timeUntillLanding, currentGearPosition, null, null);

		      frame.setWarningLabels();
		      }
			
		  	if (ComputeSimulationState.isGearOverrideWarningOn())
		  	{
		  		ComputeSimulationState.setGearPosition(Position.Up);
		  		lbUUp.setText(String.valueOf(ComputeSimulationState.getGearPosition()));
		  		lbUDown.setText(String.valueOf(""));
		  	}
			if (ComputeSimulationState.isAirBrakeWarningOn())
			{
				speedUntillLanding = speedUntillLanding - 10;
				lbUSpeed.setText(String.valueOf(speedUntillLanding));
				ComputeSimulationState.setSpeed(speedUntillLanding);
			}     
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
		}
		else
			System.out.println("Please check the values of initialization of Speed [0:500], Altitude [0:5000] and TimeUntillLanding [0:250] in aircraft landing sequence");
	}
	
	public DisplayController() {
		setTitle("Pilot Display Scenario:");
		setDefaultCloseOperation(3);
		setBounds(100, 100, 494, 368);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLabel lbAltitude = new JLabel("Altitude");
		lbAltitude.setHorizontalAlignment(0);
		lbAltitude.setBounds(25, 116, 63, 14);
		this.contentPane.add(lbAltitude);

		JLabel lbLandingGear = new JLabel("Landing Gear");
		lbLandingGear.setHorizontalAlignment(0);
		lbLandingGear.setBounds(25, 170, 89, 14);
		this.contentPane.add(lbLandingGear);
		
		JLabel lbSpeed = new JLabel("Speed");
		lbSpeed.setHorizontalAlignment(0);
		lbSpeed.setBounds(25, 59, 63, 14);
		this.contentPane.add(lbSpeed);
		
		JLabel lbAirResistance = new JLabel("Air Resistance");
		lbAirResistance.setBounds(270, 59, 91, 14);
		this.contentPane.add(lbAirResistance);

		JLabel lbAltitudeLoss = new JLabel("Altitude Loss");
		lbAltitudeLoss.setBounds(270, 116, 74, 14);
		this.contentPane.add(lbAltitudeLoss);

		JLabel lbLandingTime = new JLabel("Landing Time");
		lbLandingTime.setBounds(270, 163, 91, 14);
		this.contentPane.add(lbLandingTime);
		
		lbUSpeed = new JLabel("700");
		lbUSpeed.setBounds(120, 59, 58, 14);
		this.contentPane.add(lbUSpeed);

	    lbUAltitude = new JLabel("2000");                                    
		lbUAltitude.setBounds(120, 116, 58, 14);
		this.contentPane.add(lbUAltitude);

		lbULandingTimeCountDown = new JLabel("140");
		lbULandingTimeCountDown.setBounds(378, 170, 63, 14);
		this.contentPane.add(lbULandingTimeCountDown);
		
		lbUUp = new JLabel("");
		lbUUp.setBounds(120, 156, 58, 14);
		this.contentPane.add(lbUUp);
		
		lbUDown = new JLabel("Down");
		lbUDown.setBounds(120, 187, 58, 14);
		this.contentPane.add(lbUDown);
		
		JButton btIncreaseSpeed = new JButton("+");
		btIncreaseSpeed.setBounds(188, 36, 51, 23);
		this.contentPane.add(btIncreaseSpeed);
		btIncreaseSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, "+", null);
				lbUSpeed.setText(String.valueOf(ComputeSimulationState.getSpeed()));
				setWarningLabels();
			}
		});

		JButton btDecreaseSpeed = new JButton("-");
		btDecreaseSpeed.setBounds(188, 68, 51, 23);
		this.contentPane.add(btDecreaseSpeed);
		btDecreaseSpeed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, "-", null);
				lbUSpeed.setText(String.valueOf(ComputeSimulationState.getSpeed()));
				setWarningLabels();
			}
		});

		JButton btIncreaseAltitude = new JButton("+");
		btIncreaseAltitude.setBounds(188, 100, 51, 23);
		this.contentPane.add(btIncreaseAltitude);
		btIncreaseAltitude.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, null,"+");
				lbUAltitude.setText(String.valueOf(ComputeSimulationState.getAltitude()));
				setWarningLabels();
			}
		});
		JButton btDecreaseAltitude = new JButton("-");
		btDecreaseAltitude.setBounds(188, 128, 51, 23);
		this.contentPane.add(btDecreaseAltitude);
		btDecreaseAltitude.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, null,"-");
				lbUAltitude.setText(String.valueOf(ComputeSimulationState.getAltitude()));
				setWarningLabels();
			}
		});

		JButton btUp = new JButton("Up");
		btUp.setBounds(177, 152, 74, 23);
		this.contentPane.add(btUp);
		btUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, null,null);
				ComputeSimulationState.setSelectedGearPosition(Position.Up);
				lbUDown.setText("");
				lbUUp.setText(String.valueOf(ComputeSimulationState.getSelectedGearPosition()));
				setWarningLabels();
			}
		});
		
		JButton btDown = new JButton("Down");
		btDown.setBounds(177, 183, 74, 23);
		this.contentPane.add(btDown);
		btDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position currentGearPosition=(lbUUp.getText()!="")?Position.valueOf(lbUUp.getText()):Position.valueOf(lbUDown.getText());
				ComputeSimulationState.computeSimulationState(Integer.parseInt(lbUAltitude.getText()), Integer.parseInt(lbUSpeed.getText()), Integer.parseInt(lbULandingTimeCountDown.getText()),
						currentGearPosition, null,null);
				ComputeSimulationState.setSelectedGearPosition(Position.Down);
				lbUDown.setText(String.valueOf(ComputeSimulationState.getSelectedGearPosition()));
				lbUUp.setText("");
				setWarningLabels();
			}
		});
		
		lbUAirResistance = new JLabel("5 mph/sec");
		lbUAirResistance.setBounds(378, 59, 63, 14);
		this.contentPane.add(lbUAirResistance);

		lbUAltitudeLoss = new JLabel("20 ft/sec ");
		lbUAltitudeLoss.setBounds(378, 116, 63, 14);
		this.contentPane.add(lbUAltitudeLoss);

		lbLandingGearOverride = new JLabel("Landing Gear Override");
		lbLandingGearOverride.setBounds(10, 286, 132, 13);
		this.contentPane.add(lbLandingGearOverride);
		
	    lbBrakingOverride = new JLabel("Braking Override");
		lbBrakingOverride.setBounds(142, 285, 97, 14);
		this.contentPane.add(lbBrakingOverride);

		lbGearNotDown = new JLabel("Gear Not Down");
		lbGearNotDown.setBounds(270, 285, 96, 14);
		this.contentPane.add(lbGearNotDown);

		lbGearAirSpeed = new JLabel("Gear Air Speed");
		lbGearAirSpeed.setBounds(366, 285, 89, 14);
		this.contentPane.add(lbGearAirSpeed);

		JCheckBox cbSilenceAuralAlarm = new JCheckBox("Silence Aural Alarm");
		cbSilenceAuralAlarm.setBounds(309, 245, 146, 23);
		this.contentPane.add(cbSilenceAuralAlarm);
		cbSilenceAuralAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				AbstractButton abstractButton = (AbstractButton) e.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected)
				{
		        	setWarningLabels();
		        	if(lbGearNotDown.getForeground() == Color.RED)
		        	{
		        		lbGearNotDown.setForeground(Color.YELLOW);
		        	}
		        	if(lbGearNotDown.getForeground() == Color.RED)
		        	{
		        		lbGearNotDown.setForeground(Color.YELLOW);
		        	}
				}
			}
		});

		JLabel lbCountDown = new JLabel("Count Down");
		lbCountDown.setBounds(270, 178, 91, 14);
		this.contentPane.add(lbCountDown);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Warnings"));
		panel.setBounds(4, 227, 242, 91);
		this.contentPane.add(panel);		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder("Alarms"));
		panel_1.setBounds(243, 227, 225, 91);
		this.contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder("Pilot Display"));
		panel_2.setBounds(4, 11, 464, 209);
		this.contentPane.add(panel_2);
	}
	
	public static int getTimeUntilLanding() {
		return timeUntilLanding;
	}
	public static void setTimeUntilLanding(int timeUntilLanding) {
		DisplayController.timeUntilLanding = timeUntilLanding;
	}
	public static int getSpeed() {
		return speed;
	}
	public static void setSpeed(int speed) {
		DisplayController.speed = speed;
	}
	public static int getAltitude() {
		return altitude;
	}
	public static void setAltitude(int altitude) {
		DisplayController.altitude = altitude;
	}
	public static Position getGearPosition() {
		return gearPosition;
	}
	public static void setGearPosition(Position gearPosition) {
		DisplayController.gearPosition = gearPosition;
	}
	public static boolean isGearOverrideWarningStatus() {
		return gearOverrideWarningStatus;
	}
	public static void setGearOverrideWarningStatus(
			boolean gearOverrideWarningStatus) {
		DisplayController.gearOverrideWarningStatus = gearOverrideWarningStatus;
	}
	public static boolean isAirBrakeWarningStatus() {
		return airBrakeWarningStatus;
	}
	public static void setAirBrakeWarningStatus(boolean airBrakeWarningStatus) {
		DisplayController.airBrakeWarningStatus = airBrakeWarningStatus;
	}
	public static boolean isGearNotDownAlarmStatus() {
		return gearNotDownAlarmStatus;
	}
	public static void setGearNotDownAlarmStatus(boolean gearNotDownAlarmStatus) {
		DisplayController.gearNotDownAlarmStatus = gearNotDownAlarmStatus;
	}
	public static boolean isGearAirSpeedAlarmStatus() {
		return gearAirSpeedAlarmStatus;
	}
	public static void setGearAirSpeedAlarmStatus(boolean gearAirSpeedAlarmStatus) {
		DisplayController.gearAirSpeedAlarmStatus = gearAirSpeedAlarmStatus;
	}
	public static boolean isSilenceAlarmSetting() {
		return silenceAlarmSetting;
	}
	public static void setSilenceAlarmSetting(boolean silenceAlarmSetting) {
		DisplayController.silenceAlarmSetting = silenceAlarmSetting;
	}
	
	public void setWarningLabels(){
		if(ComputeSimulationState.isGearOverrideWarningOn())
			DisplayController.lbLandingGearOverride.setForeground(Color.RED);
		else
			DisplayController.lbLandingGearOverride.setForeground(Color.black);
		if(ComputeSimulationState.isAirBrakeWarningOn())
			DisplayController.lbBrakingOverride.setForeground(Color.RED);
		else
			DisplayController.lbBrakingOverride.setForeground(Color.black);
		if(ComputeSimulationState.isGearNotDownAlarmOn())
			DisplayController.lbGearNotDown.setForeground(Color.RED);
		else
			DisplayController.lbGearNotDown.setForeground(Color.black);
		if(ComputeSimulationState.isGearAirSpeedAlarmOn())
			DisplayController.lbGearAirSpeed.setForeground(Color.RED);
		else
			DisplayController.lbGearAirSpeed.setForeground(Color.black);
	}
}