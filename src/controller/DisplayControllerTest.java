package controller;

import static org.junit.Assert.*;

import java.awt.Color;

import inputs.ComputeSimulationState;
import inputs.GearPosition;
import inputs.Position;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisplayControllerTest {
	private static int timeUntilLanding;
	private static int speed;
	private static int altitude;
	private static Position gearPosition;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		DisplayController pilot = new DisplayController();
		pilot.run();
		String[][] inputs = new String[][]{
				{"401","true","1000","59"},
				{"401","false","1000","59"},
				{"401","true","999","121"},
				{"401","false","1000","120"},
				{"401","false","1000","121"},
				{"301","true","999","59"},
				{"400","true","999","120"},
				{"300","true","999","59"},
				};
	for (int i=0;i<8;i++){
		System.out.println("Display Scenario:"+(i+1));
			  speed = Integer.parseInt(inputs[i][0]); 
		      altitude = Integer.parseInt(inputs[i][2]);
		      timeUntilLanding = Integer.parseInt(inputs[i][3]);
		      if(inputs[i][1].equals("true"))
					inputs[i][1] = "Down";
				else
					inputs[i][1] = "Up";
		      gearPosition = Position.valueOf(inputs[i][1]);
		      ComputeSimulationState.setAltitude(altitude);
			  ComputeSimulationState.setGearPosition(gearPosition);
			  ComputeSimulationState.setSpeed(speed);
			  ComputeSimulationState.setTimeUntilLanding(timeUntilLanding);
			  ComputeSimulationState.computeSimulationState(altitude, speed, timeUntilLanding, gearPosition, null, null);		      
		        DisplayController.lbUAltitude.setText(String.valueOf(ComputeSimulationState.getAltitude()));
				DisplayController.lbUSpeed.setText(String.valueOf(ComputeSimulationState.getSpeed()));
				if(String.valueOf(ComputeSimulationState.getGearPosition()).equals("Up"))
					{
					DisplayController.lbUDown.setText("");	
					DisplayController.lbUUp.setText(String.valueOf(ComputeSimulationState.getGearPosition()));
					}
				else
				{
					DisplayController.lbUUp.setText("");
					DisplayController.lbUDown.setText(String.valueOf(ComputeSimulationState.getGearPosition()));
				}
				DisplayController.lbULandingTimeCountDown.setText(String.valueOf(ComputeSimulationState.getTimeUntilLanding()));
				ComputeSimulationState.computeSimulationState(altitude, speed, timeUntilLanding, gearPosition, null, null);
				pilot.setWarningLabels();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	   	}
	}

}
