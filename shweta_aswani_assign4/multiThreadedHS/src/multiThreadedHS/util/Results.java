package multiThreadedHS.util;

import multiThreadedHS.util.FileDisplayInterface;
import multiThreadedHS.util.StdoutDisplayInterface;
import multiThreadedHS.util.MyLogger;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public static ArrayList<String> resArrList = new ArrayList<String>();
	public static ArrayList<String> finArr = new ArrayList<String>();

	public String fileNumber;
	
	public static synchronized void getResult(String s){

		/***
			1) Called from the MyArrayList.java
			2) The sorted arraylist of each thread is passed to resArrList(shared data structure)
			3) All the elements for all the threads are added to resArrList
			
			4) synchronized keyword used for getResult
		***/
		
			resArrList.add(s);
		

		MyLogger.writeMessage("New value is stored in Results", MyLogger.DebugLevel.IN_RESULTS);
	}

	public static ArrayList<String> updatedList(){

		/***
			1) Called from MyArrayList.java after all the elements of the thread are added to the array list(resArrList)
			2) Returns the updated array list
		***/

		return resArrList;
	}

	public static void finalArray(String str){
		/***
			1) This is called from driver after merge sort
			2) finArr is the final array list which stores all the elements of all the threads which are SORTED
			3) str is the element of the final sorted data structure
			4) The element is stored in the finArr array list
		***/
		
		finArr.add(str);
	}

	public void writeToFile(String s){

		MyLogger.writeMessage("Writing in the output file", MyLogger.DebugLevel.FROM_RESULTS);

		/***
			Writing the elements in the file
		***/

		PrintWriter writer = null;		
		try 
		{			
			writer = new PrintWriter(s, "UTF-8");
			for(String st: finArr)
			{	
				writer.println(st);					
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

	public void writeToStdout(String s){
		System.out.println(s);	
	}

	public static void printResult(String s)
	{
		Results res1=new Results();
		res1.writeToFile(s);
	}

}