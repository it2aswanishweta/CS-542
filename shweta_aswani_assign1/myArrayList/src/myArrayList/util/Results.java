package myArrayList.util;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public ArrayList<String> arrList;
	BufferedWriter bw;
	
	//Constructor without a parameter, here i am just creating a new array list
	public Results() {
		arrList = new ArrayList<>();
	}

	//For constructor with file as an input, create the array list ad also read the file
	public Results(String file) {
		arrList= new ArrayList<>();

		try{
			bw = new BufferedWriter(new FileWriter(file));

		} catch(IOException e){
			e.printStackTrace(); //used for printing the exception details the code throws	
		}

	}	

	//This class should have a data structure as private data member that should store Strings
	public void stringToStore(String str1) {
		arrList.add(str1);
	}

	//Results should implement FileDisplayInterface and StdoutDisplayInterface

	//1) For FileDisplayInterface
	public void writeToFile(String s) {
	
		try {
			bw.write(s);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	//2) For StdoutDisplayInterface
	public void writeToStdout(String s) {
		System.out.println(s);
	}

	//3)storeNewResult
	public void storeNewResult(String s, String s1) {
		System.out.println(s +" "+s1);
	}


}
