package multiThreadedHS.threads;

import java.util.ArrayList; 
import java.util.Collections;
import multiThreadedHS.util.Results;

public class MyArrayList{

	ArrayList<String> arrlist = new ArrayList<String>();

	public void insert(String line)
	{
		arrlist.add(line);
	}

	public ArrayList<String> print()
	{
		/***
			1) First we are going to sort the array list for every thread
			2) Pass the sorted arraylist to the Results --> getResult
			3) getResult will add the elements in the shared data structure of the Results
			4) updatedList in Results returns the shared data structure which is stored in resArray
			5) resArray is returned to the driver which will be then passed to MergeSort.java
		***/
		Collections.sort(this.arrlist); 

		for (String number : arrlist) {
			Results.getResult(number);
		}

		ArrayList<String> resArray = Results.updatedList();

		return resArray;
	}

	
}