import java.util.Scanner;

public class ComputeSimulationState {
	
/*	public ComputeSimulationState(int altitude,int speed,int timeUntillLanding)
	{
		
	}
*/	
	public static void main(String args[])
	{

		int timeUntillLanding, altitude, speed; 
		Position gearPosition,selectedGearPosition;
		int speedIncrement, altitudeIncrement;
		String throttleCmd,elevonCmd;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of Altitude between [0,5000]");
		altitude = sc.nextInt();
		
		System.out.println("Enter the value of Speed between [0,500]");
		speed = sc.nextInt();
		
		System.out.println("Enter the value of Time Untill Landing between [0,250]");
		timeUntillLanding = sc.nextInt();
		
		if (altitude < 0 || altitude > 5000)
			   System.out.println(" Altitude value is not in range [0,5000]");
		
		if (speed < 0 || speed > 500)
			   System.out.println("Speed value is not in range [0,500]");
		
		if (timeUntillLanding < 0 || timeUntillLanding > 250)
		   System.out.println(" TimeUntillLanding value is not in range [0,250]");

		
		
		DataSensors al = new Altitude();
		al.setValue(altitude);
		
		DataSensors sd = new Speed();
		sd.setValue(speed);
		
		Timers ts = new TimeToLand();
		ts.setValue(timeUntillLanding);
		
		StatusValues sv = new GearPosition();
		sv.setValue(Position.Up);
		
/*		if (throttleCmd=“+”)
			  speedIncrement=10;
			else
			  {
			  if (throttleCmd=“-”)
			     speedIncrement=-10;
			  else
			     speedIncrement=0:
			   }
			if (elevonCmd=“+”)
			  altitudeIncrement=20;
			else
			  {
			  if (elevonCmd =“-”)
			     altitudeIncrement=-20;
			  else
			     altitudeIncrement=0:
			   }
			if (!gear_override_warning_on)
			    gear_position = selected_gear_position;
			speed -= speedIncrement;
			altitude -= altitudeIncrement;
			airbrake_warning_on = (speed >= 250) && (timeUntilLanding < 60);
			gear_override_warning_on = (gearPosition=down) && (speed>400);
			gear_not_down_alarm_on = (gearPosition=up) && ((timeUntilLanding <=120) || altitude <1000));
			gear_air_speed_alarm_on = (gearPosition=down) && (speed>300);
*/
		
		
	}
}
