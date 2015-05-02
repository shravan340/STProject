package inputs;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ComputeSimulationStateTest {
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
		String csvFile = "/Users/Munna/git/STProject1/src/1.csv";
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
					inputs[1] = "Down";
				else
					inputs[1] = "Up";
				gearPosition = Position.valueOf(inputs[1]);
				altitude = Integer.parseInt(inputs[2]);
				timeUntilLanding = Integer.parseInt(inputs[3]);
				ComputeSimulationState.setAltitude(altitude);
				ComputeSimulationState.setSpeed(speed);
				ComputeSimulationState.setTimeUntilLanding(timeUntilLanding);
				ComputeSimulationState.setGearPosition(gearPosition);
				ComputeSimulationState.process();
				airBrakeWarningOn = ComputeSimulationState.isAirBrakeWarningOn(); 
				gearOverrideWarningOn = ComputeSimulationState.isGearOverrideWarningOn();
				gearNotDownAlarmOn = ComputeSimulationState.isGearNotDownAlarmOn();
				gearAirSpeedAlarmOn = ComputeSimulationState.isGearAirSpeedAlarmOn();
				System.out.println(""+gearNotDownAlarmOn+gearAirSpeedAlarmOn+airBrakeWarningOn+gearOverrideWarningOn);
				assertEquals(Boolean.valueOf(inputs[4]),gearNotDownAlarmOn);
				assertEquals(Boolean.valueOf(inputs[5]),gearAirSpeedAlarmOn);
				assertEquals(Boolean.valueOf(inputs[6]),airBrakeWarningOn);
				assertEquals(Boolean.valueOf(inputs[7]),gearOverrideWarningOn);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
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
