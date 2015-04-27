package inputs;

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

	public static DisplayController computeSimulationState(ComputeSimulationState state){
		
//		Take the inputs and set the DisplayController output variables as follows.
		DisplayController pilot=new DisplayController();
		
//		Process the input.
		process();
//		Set output
		
		pilot.setAirBrakeWarningStatus(airBrakeWarningOn);
		pilot.setAltitude(altitude);
		pilot.setGearAirSpeedAlarmStatus(gearAirSpeedAlarmOn);
		pilot.setGearNotDownAlarmStatus(gearNotDownAlarmOn);
		pilot.setGearOverrideWarningStatus(gearOverrideWarningOn);
		pilot.setGearPosition(gearPosition);
//		pilot.setSilenceAlarmSetting(silenceAlarmSetting);
		pilot.setSpeed(speed);
		pilot.setTimeUntilLanding(timeUntilLanding);
		return pilot;
	}

	private static void process() {
		// TODO Auto-generated method stub
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
			    gearPosition = selectedGearPosition;
			speed -= speedIncrement;
			altitude -= altitudeIncrement;
			airBrakeWarningOn = (speed >= 250) && (timeUntilLanding < 60);
			gearOverrideWarningOn = (gearPosition == Position.Down) && (speed>400);
			gearNotDownAlarmOn = (gearPosition == Position.Up) && ((timeUntilLanding <=120) || (altitude <1000));
			gearAirSpeedAlarmOn = (gearPosition== Position.Down ) && (speed>300);
	}

	public int getTimeUntilLanding() {
		return timeUntilLanding;
	}

	public void setTimeUntilLanding(int timeUntilLanding) {
		this.timeUntilLanding = timeUntilLanding;
	}

	public int getSpeed() {			   
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAltitude() {		   
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public Position getGearPosition() {
		return gearPosition;
	}

	public void setGearPosition(Position gearPosition) {
		this.gearPosition = gearPosition;
	}

	public Position isSelectedGearPosition() {
		return selectedGearPosition;
	}

	public void setSelectedGearPosition(Position selectedGearPosition) {
		this.selectedGearPosition = selectedGearPosition;
	}

	public String getThrottleCmd() {
		return throttleCmd;
	}

	public void setThrottleCmd(String throttleCmd) {
		this.throttleCmd = throttleCmd;
	}

	public String getElevonCmd() {
		return elevonCmd;
	}

	public void setElevonCmd(String elevonCmd) {
		this.elevonCmd = elevonCmd;
	}
}
