package racingDrivers.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;	
import racingDrivers.driverStates.RaceContextClass;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private static List<String> arrList = new ArrayList<String>();

	static int x=0;
	static int driver = RaceContextClass.no;
	int counter = 0;
	
	/** 
		Storing the output from the list to file
	**/
	
	public void writeToFile(String s) 
	{
		
		PrintWriter writer = null;		
		try 
		{			
			writer = new PrintWriter(s, "UTF-8");

			for(String st: arrList)
			{	
						
					writer.print(st + " ");
					counter ++;
					
					if(counter == driver)
						{
							writer.println("\n");
							counter = 0;
						}

			}
						
		} 		
		catch (Exception e) 
		{			
			e.printStackTrace();
		}				
		finally
		{
			writer.close();
		}					
	}


	@Override
	public void writeToStdout(String s)
	{
		System.out.println(s);		
	}

	/**
		 Writing the new result to the Array List
	**/
	public static void storeNewResult(String test)
	{
		arrList.add(test);			
	}

	public static void printResult(String s)
	{
		Results res1=new Results();
		res1.writeToFile(s);
	}
}