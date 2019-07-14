package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) {

	if (args.length != 2) {
			System.err.println("Number of arguments provided are not valid.");
			System.exit(0);
		}
		
		//creating instance for arraylist, result and myarraylisttest

		FileProcessor fp = new FileProcessor(args[0]); 
		MyArrayList myarr = new MyArrayList(fp);

		Results res = new Results(args[1]);
		MyArrayListTest t = new MyArrayListTest();
		String str2 = "";
		String line; 
		int inputline;
		
		while ((line = fp.readLine()) != null) {
			try {
				inputline = Integer.parseInt(line);
			        myarr.insertSorted(inputline); //insert the element

			} catch(Exception e) {
				continue;
			}
		}

		//call the testMe method on a MyArrayListTest instance
		t.testMe(myarr, res);

		//Initializing a new String ch and accessing the array list from Results file
		for (int i = 0; i < res.arrList.size(); i++){
    			str2 +=res.arrList.get(i) + "\n";
		}


		//Final result
		str2 = "The sum of all the values in the array list is: " + myarr.sum() + "\n" + str2;

		//wrote to file
		res.writeToFile(str2);


		
	}
}
