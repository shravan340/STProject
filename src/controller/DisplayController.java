package controller;
import inputs.Position;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import main.Simulator;

import java.awt.EventQueue;
import java.awt.Color;

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
	
	void run(){
		DisplayController frame = new DisplayController();
		frame.setVisible(true); 
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
}