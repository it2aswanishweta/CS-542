package racingDrivers.driverStates;

import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;

public class DriverContextClass implements DriverContextI
{
	public DriverContextClass(){
	
		MyLogger.writeMessage("Driver Context Class: ", MyLogger.DebugLevel.CONSTRUCTOR);		
	}

	public void mindSet(double sum[], int NoDriver, String output)
	{
		int counter = 0;
		double max = -1; 
		int posCounter = 0;
		int position[] = new int[NoDriver];
		int track[] = new int[NoDriver];	
		double copy[] = sum.clone();

		/**
		Position Calculation
		**/

		while(counter < NoDriver)
		{
				
			for(int i = 0; i<NoDriver; i++)
			{
			   if(copy[i] > max) 
				{
					max = copy[i];
					posCounter = i; 
				}
			}
			
			position[posCounter] = counter + 1 ;
			
			/**
				creating a new array "track" which will keep a track if some elements in the array are equal
				if so put -1 at that position in track array
			**/

			 for(int i = 0; i < NoDriver; i++) 
       				 for(int j = i + 1; j < NoDriver; j++) 
					{
						if(copy[i] == copy[j])
							if((copy[i] != -1) && (copy[j] != -1))
							 {
						  		track[i] = -1;
								track[j] = -1;
							 }
					}
			/**
				updating the position array
			**/
			for(int i =0; i<NoDriver; i++)
			{
				if(track[i] == -1)
				{
					position[i] = -1;
				}
			}
		
			copy[posCounter] = -1;
			max = 0;
			counter++;			
			
		}

		/**
		Finding the states
		**/
		Confident co = new Confident();
		Reckless re = new Reckless();
		Calculative ca = new Calculative();

		for(int i =0; i<NoDriver; i++)
		{
			if(position[i] == -1){
				re.Reckless1();
				MyLogger.writeMessage("Reckless", MyLogger.DebugLevel.IN_RUN);
			}

			else if(position[i] < (0.3 * NoDriver)){
				co.Confident1();			
				MyLogger.writeMessage("Confident", MyLogger.DebugLevel.IN_RUN);
			}
			else if((Math.round(0.3 * NoDriver)) <= (position[i]))
				if((position[i]) < (Math.round(0.7 * NoDriver)))
				{
					ca.Calculative1();
					MyLogger.writeMessage("Calculative", MyLogger.DebugLevel.IN_RUN);
				}
			else if((position[i] >= Math.round(0.7 * NoDriver)) && (position[i] != -1))
				{
					re.Reckless1();
					MyLogger.writeMessage("Reckless", MyLogger.DebugLevel.IN_RUN);

				}
		}

		Results.printResult(output);

	}

}