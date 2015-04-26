package main;

import inputs.ComputeSimulationState;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import controller.DisplayController;


public class Simulator {
	
	public static void main(String[] args) {
		
			
		ComputeSimulationState computeSimulationState=new ComputeSimulationState();
		
		
		for(int i=0;i<37;i++){
			
			
			File f = new File("input.xls");
			
			Workbook wb;
			
			try {
				wb = Workbook.getWorkbook(f);
			
			Sheet s = wb.getSheet(0);
			
			int row = s.getRows();
			int col = s.getColumns();
			

			for(int n = 0; n<row; n++){
				//for(int m = 0; m<col; m++){
					Cell c = s.getCell(0, n);
					
					//Checking the function to change cell type into integer
					//System.out.println(c.getContents());
					//computeSimulationState.setSpeed(c);
				//}
			}
			
			//public void getSensorInput(int speed, int altitude, int tul, Position pos){
				
			//}
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
//			} 
		
//		catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
	}

}
