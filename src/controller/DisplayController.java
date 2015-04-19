package controller;
import inputs.Position;
public class DisplayController {
	
	private int timeUntilLanding;
	private int speed;
	private int altitude;
	private Position gearPosition;
	private boolean gearOverrideWarningStatus;
	private boolean airBrakeWarningStatus;
	private boolean gearNotDownAlarmStatus;
	private boolean gearAirSpeedAlarmStatus;
	private boolean silenceAlarmSetting;
	
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
	public boolean isGearOverrideWarningStatus() {
		return gearOverrideWarningStatus;
	}
	public void setGearOverrideWarningStatus(boolean gearOverrideWarningStatus) {
		this.gearOverrideWarningStatus = gearOverrideWarningStatus;
	}
	public boolean isAirBrakeWarningStatus() {
		return airBrakeWarningStatus;
	}
	public void setAirBrakeWarningStatus(boolean airBrakeWarningStatus) {
		this.airBrakeWarningStatus = airBrakeWarningStatus;
	}
	public boolean isGearNotDownAlarmStatus() {
		return gearNotDownAlarmStatus;
	}
	public void setGearNotDownAlarmStatus(boolean gearNotDownAlarmStatus) {
		this.gearNotDownAlarmStatus = gearNotDownAlarmStatus;
	}
	public boolean isGearAirSpeedAlarmStatus() {
		return gearAirSpeedAlarmStatus;
	}
	public void setGearAirSpeedAlarmStatus(boolean gearAirSpeedAlarmStatus) {
		this.gearAirSpeedAlarmStatus = gearAirSpeedAlarmStatus;
	}
	public boolean isSilenceAlarmSetting() {
		return silenceAlarmSetting;
	}
	public void setSilenceAlarmSetting(boolean silenceAlarmSetting) {
		this.silenceAlarmSetting = silenceAlarmSetting;
	}
}