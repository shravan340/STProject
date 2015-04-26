package inputs;

import controller.DisplayController;

public class ComputeSimulationState {
	
	private int timeUntilLanding;
	private int speed;
	private int altitude;
	private Position gearPosition;
	private boolean selectedGearPosition;
	private String throttleCmd;
	private String elevonCmd;

	public static DisplayController computeSimulationState(ComputeSimulationState state){
		
//		Take the inputs and set the DisplayController output variables as follows.
		DisplayController pilot=new DisplayController();
		
//		Process the input.
		process();
//		Set output
//		
//		pilot.setAirBrakeWarningStatus(airBrakeWarningStatus);
//		pilot.setAltitude(altitude);
//		pilot.setGearAirSpeedAlarmStatus(gearAirSpeedAlarmStatus);
//		pilot.setGearNotDownAlarmStatus(gearNotDownAlarmStatus);
//		pilot.setGearOverrideWarningStatus(gearOverrideWarningStatus);
//		pilot.setGearPosition(gearPosition);
//		pilot.setSilenceAlarmSetting(silenceAlarmSetting);
//		pilot.setSpeed(speed);
//		pilot.setTimeUntilLanding(timeUntilLanding);
		return pilot;
	}

	private static void process() {
		// TODO Auto-generated method stub
		
	}

	public int getTimeUntilLanding() {
		return timeUntilLanding;
	}

	public void setTimeUntilLanding(int timeUntilLanding) {
		this.timeUntilLanding = timeUntilLanding;
	}

	public int getSpeed() {

		if (throttleCmd == "+")
			  speed += 10;
		else if (throttleCmd == "-")
		     speed -= 10;
		else
		     speed += 0;
			   
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAltitude() {
		
		if (elevonCmd == "+")
			  altitude += 20;
		else if (elevonCmd == "-")
		     altitude -= 20;
		else
		     altitude += 0;
			   
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

	public boolean isSelectedGearPosition() {
		return selectedGearPosition;
	}

	public void setSelectedGearPosition(boolean selectedGearPosition) {
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
