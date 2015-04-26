package main;

import inputs.ComputeSimulationState;
import inputs.Position;

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
			
			File f = new File("C:\\Users\\Raguvinoth\\Desktop\\input.xls");
			
			Workbook wb;
			try {
				wb = Workbook.getWorkbook(f);
			
			
			Sheet s = wb.getSheet(0);
			
			//int row = s.getRows();
			//int col = s.getColumns();
			
			//for(int m = 0; m<row; m++){
				//for(int n = 0; n<col; n++){
// Setting the values of Cells in spread sheet					
					Cell c1 = s.getCell(0, i);
					String tul = c1.getContents();
					int timeUntilLanding = Integer.parseInt(tul);
					computeSimulationState.setTimeUntilLanding(timeUntilLanding);
					
					Cell c2 = s.getCell(1, i);
					String sp = c2.getContents();
					int speed = Integer.parseInt(sp);
					computeSimulationState.setSpeed(speed);
					
					Cell c3 = s.getCell(2, i);
					String al = c3.getContents();
					int altitude = Integer.parseInt(al);
					computeSimulationState.setAltitude(altitude);
					
					Cell c4 = s.getCell(3, i);
					String gp = c4.getContents();
					//int gearPosition = Integer.parseInt(gp);
					computeSimulationState.setGearPosition(gp);
					
								
				//}
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
//			} catch (InterruptedException e) {
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
