package myArrayList.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	BufferedReader br = null;

	//Initializing the Constructor 
	public FileProcessor(String file) {

		try{
			br = new BufferedReader(new FileReader(file));

		} catch(IOException e){
			e.printStackTrace(); //used for printing the exception details the code throws	
		}

	}


	public String readLine() {

	
		String l = "", oneline = null;

		try{
		   //To check if the line we are trying to read is not null
			if((l = br.readLine()) != null)
				oneline = l;	
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return oneline;

	}

}
