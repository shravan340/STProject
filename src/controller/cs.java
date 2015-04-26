package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class cs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cs frame = new cs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cs() {
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
		    
		    JLabel lbUSpeed = new JLabel("New label");
		    lbUSpeed.setBounds(120, 59, 58, 14);
		    this.contentPane.add(lbUSpeed);
		    
		    JLabel lbUAltitude = new JLabel("New label");
		    lbUAltitude.setBounds(120, 116, 58, 14);
		    this.contentPane.add(lbUAltitude);
		    
		    JLabel lbUUp = new JLabel("New label");
		    lbUUp.setBounds(120, 156, 58, 14);
		    this.contentPane.add(lbUUp);
		    
		    JLabel lbUDown = new JLabel("New label");
		    lbUDown.setBounds(120, 187, 58, 14);
		    this.contentPane.add(lbUDown);
		    
		    JLabel lbUAirResistance = new JLabel("New label");
		    lbUAirResistance.setBounds(378, 59, 63, 14);
		    this.contentPane.add(lbUAirResistance);
		    
		    JLabel lbUAltitudeLoss = new JLabel("New label");
		    lbUAltitudeLoss.setBounds(378, 116, 63, 14);
		    this.contentPane.add(lbUAltitudeLoss);
		    
		    JLabel lbULandingTimeCountDown = new JLabel("New label");
		    lbULandingTimeCountDown.setBounds(378, 170, 63, 14);
		    this.contentPane.add(lbULandingTimeCountDown);
		    
		    JLabel lbLandingGearOverride = new JLabel("Landing Gear Override");
		    lbLandingGearOverride.setBounds(10, 286, 132, 13);
		    this.contentPane.add(lbLandingGearOverride);
		    
		    JLabel lbBrakingOverride = new JLabel("Braking Override");
		    lbBrakingOverride.setBounds(142, 285, 97, 14);
		    this.contentPane.add(lbBrakingOverride);
		    
		    JLabel lbGearNotDown = new JLabel("Gear Not Down");
		    lbGearNotDown.setBounds(270, 285, 96, 14);
		    this.contentPane.add(lbGearNotDown);
		    
		    JLabel lbGearAirSpeed = new JLabel("Gear Air Speed");
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

}
