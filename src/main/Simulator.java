package main;

import controller.DisplayController;
import inputs.ComputeSimulationState;
import inputs.Position;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



@SuppressWarnings("serial")
public class Simulator extends JFrame{
	private static int timeUntilLanding;
	private static int speed;
	private static int speedIncrement;
	private static int altitude;
	private static int altitudeIncrement;
	private static Position gearPosition;
	private static Position selectedGearPosition;
	private static String throttleCmd;
	private static String elevonCmd;
	private static boolean airBrakeWarningOn; 
	private static boolean gearOverrideWarningOn; 
	private static boolean gearNotDownAlarmOn;
	private static boolean gearAirSpeedAlarmOn;
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
	
	static {
		Simulator frame = new Simulator();
		frame.setVisible(true); 
	}
	
	public Simulator() {
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

		JButton btIncrease = new JButton("+");
		btIncrease.setBounds(188, 36, 51, 23);
		this.contentPane.add(btIncrease);

		JButton btDecrease = new JButton("-");
		btDecrease.setBounds(188, 68, 51, 23);
		this.contentPane.add(btDecrease);

		JLabel lbAirResistance = new JLabel("Air Resistance");
		lbAirResistance.setBounds(270, 59, 91, 14);
		this.contentPane.add(lbAirResistance);

		JLabel lbAltitudeLoss = new JLabel("Altitude Loss");
		lbAltitudeLoss.setBounds(270, 116, 74, 14);
		this.contentPane.add(lbAltitudeLoss);

		JLabel lbLandingTime = new JLabel("Landing Time");
		lbLandingTime.setBounds(270, 163, 91, 14);
		this.contentPane.add(lbLandingTime);

		JButton btnUp = new JButton("Up");
		btnUp.setBounds(177, 152, 74, 23);
		this.contentPane.add(btnUp);

		JButton btDown = new JButton("Down");
		btDown.setBounds(177, 183, 74, 23);
		this.contentPane.add(btDown);

		JLabel lbSpeed = new JLabel("Speed");
		lbSpeed.setHorizontalAlignment(0);
		lbSpeed.setBounds(25, 59, 63, 14);
		this.contentPane.add(lbSpeed);

		lbUSpeed = new JLabel("New label");
		lbUSpeed.setBounds(120, 59, 58, 14);
		this.contentPane.add(lbUSpeed);

	    lbUAltitude = new JLabel();                                    
		lbUAltitude.setBounds(120, 116, 58, 14);
		this.contentPane.add(lbUAltitude);

		lbUUp = new JLabel("");
		lbUUp.setBounds(120, 156, 58, 14);
		this.contentPane.add(lbUUp);
		
		lbUDown = new JLabel("");
		lbUDown.setBounds(120, 187, 58, 14);
		this.contentPane.add(lbUDown);

		lbUAirResistance = new JLabel("5 mph/sec");
		lbUAirResistance.setBounds(378, 59, 63, 14);
		this.contentPane.add(lbUAirResistance);

		lbUAltitudeLoss = new JLabel("20 ft/sec ");
		lbUAltitudeLoss.setBounds(378, 116, 63, 14);
		this.contentPane.add(lbUAltitudeLoss);

		lbULandingTimeCountDown = new JLabel("New label");
		lbULandingTimeCountDown.setBounds(378, 170, 63, 14);
		this.contentPane.add(lbULandingTimeCountDown);

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

	public static void main(String[] args) {
		for(int i=0;i<37;i++){

			String csvFile = "/Users/Munna/Desktop/1.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			try {

				br = new BufferedReader(new FileReader(csvFile));
				line = br.readLine();
				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] inputs = line.split(cvsSplitBy);

					speed = Integer.parseInt(inputs[0]);
					if(inputs[1].equals("Y"))
					{
						inputs[1] = "Down";
					}
					else
						inputs[1] = "Up";
					gearPosition = Position.valueOf(inputs[1]);
					altitude = Integer.parseInt(inputs[2]);
					timeUntilLanding = Integer.parseInt(inputs[3]);
					//			Read the input file line by line and set values as follows.
					//			
					ComputeSimulationState.setAltitude(altitude);
					//ComputeSimulationState.setElevonCmd(elevonCmd);
					ComputeSimulationState.setGearPosition(gearPosition);
					//computeSimulationState.setPilot(pilot);
					ComputeSimulationState.setSpeed(speed);
					//ComputeSimulationState.setThrottleCmd(throttleCmd);
					ComputeSimulationState.setTimeUntilLanding(timeUntilLanding);

					DisplayController pilot= ComputeSimulationState.computeSimulationState();
					
					Simulator.lbUAltitude.setText(String.valueOf(DisplayController.getAltitude()));
					Simulator.lbUSpeed.setText(String.valueOf(DisplayController.getSpeed()));
					if(String.valueOf(DisplayController.getGearPosition()).equals("Up"))
						{
						Simulator.lbUDown.setText("");	
						Simulator.lbUUp.setText(String.valueOf(DisplayController.getGearPosition()));
						}
					else
					{
						Simulator.lbUUp.setText("");
						Simulator.lbUDown.setText(String.valueOf(DisplayController.getGearPosition()));
					}
//					}Simulator.lbUAirResistance.setText(String.valueOf(DisplayController.getAltitude()));
//					Simulator.lbUAltitudeLoss.setText(String.valueOf(DisplayController.getAltitude()));
					Simulator.lbULandingTimeCountDown.setText(String.valueOf(DisplayController.getTimeUntilLanding()));
					if(DisplayController.isGearOverrideWarningStatus())
						Simulator.lbLandingGearOverride.setForeground(Color.RED);
					else
						Simulator.lbLandingGearOverride.setForeground(Color.black);
					if(DisplayController.isAirBrakeWarningStatus())
						Simulator.lbBrakingOverride.setForeground(Color.RED);
					else
						Simulator.lbBrakingOverride.setForeground(Color.black);
					if(DisplayController.isGearNotDownAlarmStatus())
						Simulator.lbGearNotDown.setForeground(Color.RED);
					else
						Simulator.lbGearNotDown.setForeground(Color.black);
					if(DisplayController.isGearAirSpeedAlarmStatus())
						Simulator.lbGearAirSpeed.setForeground(Color.RED);
					else
						Simulator.lbGearAirSpeed.setForeground(Color.black);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}		
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
