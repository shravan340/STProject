package controller;
import inputs.Position;


public class DisplayController {
	
	private static int timeUntilLanding;
	private static int speed;
	private static int altitude;
	private static Position gearPosition;
	private static boolean gearOverrideWarningStatus;
	private static boolean airBrakeWarningStatus;
	private static boolean gearNotDownAlarmStatus;
	private static boolean gearAirSpeedAlarmStatus;
	private static boolean silenceAlarmSetting;
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