package racingDrivers.driverStates;

import java.io.IOException;
import racingDrivers.util.FileProcessor;

public class RaceContextClass{

	public static int no = 0;
	public void Processing(String s, String o)
	{
		
		FileProcessor fp = new FileProcessor(s);
		String line = "";
		
				
		boolean first = true, sum = true;
		String distanceInEachMin[];
		double sumArray[] = new double[1000000];
		

		DriverContextClass contextD = new DriverContextClass();

		/**
			--> first is for the first line, here "no" will store the number of drivers
			--> in else, distance of the car covered in each min is stored in the array --> distanceInEachMin 
			--> then this array is passed to the driver context class along with the number of drivers
		**/
		while ((line = fp.readLine()) != null) {

			try
			{

				if(first)
                  		 {
					no = Integer.parseInt(line);
							
					first = false;
			
		   		 }
		                 else if(no > 3){
					distanceInEachMin = new String [no];
					for(int i = 0; i < no; i++)
					{
						distanceInEachMin = line.split(" ");
					}
				
					for(int i = 0; i < no; i++)
					{
						sumArray[i] = sumArray[i] + Double.parseDouble(distanceInEachMin[i]);
					}
					contextD.mindSet(sumArray, no, o); 	
	       			}
				else{
					System.out.println("Number of drivers are less than 3, your input file is not valid");
					System.exit(0);
				}
				
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}		
		}

	}

}