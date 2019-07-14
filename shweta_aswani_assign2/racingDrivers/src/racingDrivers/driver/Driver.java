package racingDrivers.driver;

import racingDrivers.driverStates.RaceContextClass;
import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;

public class Driver {

	public static void main(String[] args) {

		if (args.length != 3) {
           		 System.err.println("Number of arguments provided are not valid.");
            		 System.exit(0);
        	}
		
		
		String input_file = args[0]; 
		String output_file = args[1];

		RaceContextClass rc = new RaceContextClass();
		rc.Processing(input_file, output_file);

		try
		{
			if(!(Integer.parseInt(args[2]) >= 0)&&(Integer.parseInt(args[2]) <= 4))
			{
				throw new RuntimeException("Error");
			}
			MyLogger.setDebugValue(Integer.parseInt(args[2]));			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Wrong Logger Value entered");
			System.exit(1);
		}
			

		
	}
}