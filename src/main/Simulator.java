package main;

import controller.DisplayController;
import inputs.ComputeSimulationState;

public class Simulator {
	
	public static void main(String[] args) {
		
		ComputeSimulationState computeSimulationState=new ComputeSimulationState();
		
		for(int i=0;i<37;i++){
			
//			Read the input file line by line and set values as follows.
//			
//			computeSimulationState.setAltitude(altitude);
//			computeSimulationState.setElevonCmd(elevonCmd);
//			computeSimulationState.setGearPosition(gearPosition);
//			computeSimulationState.setPilot(pilot);
//			computeSimulationState.setSpeed(speed);
//			computeSimulationState.setThrottleCmd(throttleCmd);
//			computeSimulationState.setTimeUntilLanding(timeUntilLanding);
//			
//			Call the method which sets values for the DisplayController Output class
			DisplayController pilot=ComputeSimulationState.computeSimulationState(computeSimulationState);
			
//			Simulate the displays using the output values.
			
//			Sleep for one second

//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
		}
	}

}
