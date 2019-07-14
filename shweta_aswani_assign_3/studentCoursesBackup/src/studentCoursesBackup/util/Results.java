package studentCoursesBackup.util;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import studentCoursesBackup.util.MyLogger;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	public ArrayList<String> arrList;
	public String string1;
	BufferedWriter bw;
	
	/**
		Constructor without a parameter, here i am just creating a new array list
	**/
	public Results() {
		arrList = new ArrayList<>();
	}

	/**
		For constructor with file as an input, create the array list ad also read the file
	**/

	public Results(String file) {
		arrList= new ArrayList<>();

		try{
			bw = new BufferedWriter(new FileWriter(file));

		} catch(IOException e){
			
			/**
				used for printing the exception details the code throws	
			**/
			e.printStackTrace(); 	
		}

	}	
		
	/**
		1) For FileDisplayInterface
	**/
	public void writeToFile(String s) {
	
		try {
			bw.write(s);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
		2) For StdoutDisplayInterface
	**/
	public void writeToStdout(String s){
		MyLogger.writeMessage("Results: ", MyLogger.DebugLevel.IN_RESULTS);
		System.out.println(s);
	}

	public void stringToStore(String string1){
        	this.string1 = string1;
    	}

}
