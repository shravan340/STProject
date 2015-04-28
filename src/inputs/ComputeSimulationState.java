package inputs;

import main.Simulator;
import controller.DisplayController;
public class ComputeSimulationState {
	
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

public static DisplayController computeSimulationState(){
		
		process();
			
//		Take the inputs and set the DisplayController output variables as follows.
		DisplayController pilot = new DisplayController();
			
//		Set output
		DisplayController.setAirBrakeWarningStatus(airBrakeWarningOn);
		DisplayController.setAltitude(altitude);
		DisplayController.setGearAirSpeedAlarmStatus(gearAirSpeedAlarmOn);
		DisplayController.setGearNotDownAlarmStatus(gearNotDownAlarmOn);
		DisplayController.setGearOverrideWarningStatus(gearOverrideWarningOn);
//		DisplayController.setSilenceAlarmSetting(silenceAlarmSetting);
		DisplayController.setSpeed(speed);
		DisplayController.setTimeUntilLanding(timeUntilLanding);
		DisplayController.setGearPosition(gearPosition);
			 
		return pilot;
		}
		
	public static void process(){
		if (throttleCmd == "+")
			  speedIncrement =+ 10;
			else
			  {
			  if (throttleCmd== "-")
			     speedIncrement =- 10;
			  else
			     speedIncrement = 0;
			   }
			if (elevonCmd== "+")
			  altitudeIncrement=20;
			else
			  {
			  if (elevonCmd =="-")
			     altitudeIncrement=-20;
			  else
			     altitudeIncrement=0;
			   }
			if (!gearOverrideWarningOn)
			    //gearPosition = selectedGearPosition;
			speed -= speedIncrement;
			altitude = (altitude-altitudeIncrement);
			airBrakeWarningOn = (speed >= 250) && (timeUntilLanding < 60);
			gearOverrideWarningOn = (gearPosition == Position.Down) && (speed>400);
			gearNotDownAlarmOn = (gearPosition == Position.Up) && ((timeUntilLanding <=120) || (altitude <1000));
			gearAirSpeedAlarmOn = (gearPosition== Position.Down ) && (speed>300);
	}

	public static int getTimeUntilLanding() {
		return timeUntilLanding;
	}

	public static void setTimeUntilLanding(int timeUntilLanding) {
		ComputeSimulationState.timeUntilLanding = timeUntilLanding;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		ComputeSimulationState.speed = speed;
	}

	public static int getSpeedIncrement() {
		return speedIncrement;
	}

	public static void setSpeedIncrement(int speedIncrement) {
		ComputeSimulationState.speedIncrement = speedIncrement;
	}

	public static int getAltitude() {
		return altitude;
	}

	public static void setAltitude(int altitude) {
		ComputeSimulationState.altitude = altitude;
	}

	public static int getAltitudeIncrement() {
		return altitudeIncrement;
	}

	public static void setAltitudeIncrement(int altitudeIncrement) {
		ComputeSimulationState.altitudeIncrement = altitudeIncrement;
	}

	public static Position getGearPosition() {
		return gearPosition;
	}

	public static void setGearPosition(Position gearPosition) {
		ComputeSimulationState.gearPosition = gearPosition;
	}

	public static Position getSelectedGearPosition() {
		return selectedGearPosition;
	}

	public static void setSelectedGearPosition(Position selectedGearPosition) {
		ComputeSimulationState.selectedGearPosition = selectedGearPosition;
	}

	public static String getThrottleCmd() {
		return throttleCmd;
	}

	public static void setThrottleCmd(String throttleCmd) {
		ComputeSimulationState.throttleCmd = throttleCmd;
	}

	public static String getElevonCmd() {
		return elevonCmd;
	}

	public static void setElevonCmd(String elevonCmd) {
		ComputeSimulationState.elevonCmd = elevonCmd;
	}

	public static boolean isAirBrakeWarningOn() {
		return airBrakeWarningOn;
	}

	public static void setAirBrakeWarningOn(boolean airBrakeWarningOn) {
		ComputeSimulationState.airBrakeWarningOn = airBrakeWarningOn;
	}

	public static boolean isGearOverrideWarningOn() {
		return gearOverrideWarningOn;
	}

	public static void setGearOverrideWarningOn(boolean gearOverrideWarningOn) {
		ComputeSimulationState.gearOverrideWarningOn = gearOverrideWarningOn;
	}

	public static boolean isGearNotDownAlarmOn() {
		return gearNotDownAlarmOn;
	}

	public static void setGearNotDownAlarmOn(boolean gearNotDownAlarmOn) {
		ComputeSimulationState.gearNotDownAlarmOn = gearNotDownAlarmOn;
	}

	public static boolean isGearAirSpeedAlarmOn() {
		return gearAirSpeedAlarmOn;
	}

	public static void setGearAirSpeedAlarmOn(boolean gearAirSpeedAlarmOn) {
		ComputeSimulationState.gearAirSpeedAlarmOn = gearAirSpeedAlarmOn;
	}
	
}
