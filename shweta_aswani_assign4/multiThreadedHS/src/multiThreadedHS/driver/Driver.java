package multiThreadedHS.driver;

import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.threads.MyArrayList;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MergeSort;
import multiThreadedHS.util.MyLogger;

import java.util.ArrayList; 

public class Driver {
	
	public static void main(String[] args) throws InterruptedException{
		
		int numberOfThreads = Integer.parseInt(args[0]);
		MyArrayList myarr = new MyArrayList();
		MyArrayList myarr1 = new MyArrayList();
		MyArrayList myarr2 = new MyArrayList();

		/***********************
			Command line argument validation
		***********************/
		if( !(args.length > 6 || args.length < 4) )
		{

		if((numberOfThreads > 3 || numberOfThreads < 1)) {
                	System.err.println("Number of threads can be either 1, 2 or 3. The value provided by you is incorrect");
                	System.exit(0);
		}


		if(numberOfThreads == 1)
		{
			  FileProcessor input1 = new FileProcessor(args[1]);
			  String outputFile = args[2];
			  int debugLevel = Integer.parseInt(args[3]);


			  /***************************
				Debug value check
			  ****************************/
			  if (debugLevel >= 0 && debugLevel <= 4) {
                			MyLogger.setDebugValue(debugLevel);
            		  } else {
                			System.err.println("Invalid Debug Level.");
                			System.exit(0);
            		  }


			  /***************************
				Creating threads by calling the function threadsCreation.
				Here number of threads and array list are passed as arguments
			  ****************************/
			  ThreadWorker thread1 = new ThreadWorker(input1);
			  thread1.threadsCreation(numberOfThreads, myarr);


			  /**************************
				Sequence:
				1) Print in MyArrayList.java sorts the elements
				2) Those sorted elements are sent to Results which is stored in its shared data structure(ArrayList)
				3) The shared data structure is returned from Results.java to print() in MyArrayList.java
				4) MyArrayList.java returns the shared data structure to the Driver which is stored in sharedArrList1 
				5) sharedcopy(Integer Array List) is a copy of sharedArrList1(String Array List) --> created because 
				   Integer array list is passed for Merge Sort  
			  ***************************/
			  ArrayList<String> sharedArrList1 = myarr.print();

			  ArrayList<Integer> sharedcopy = new ArrayList<Integer>();			
			  for(String stringValue : sharedArrList1) {
            		                sharedcopy.add(Integer.parseInt(stringValue));
            		  } 


			  /************************* 
				Merge Sort
				
				1) Passing the sharedcopy(Integer Array List to Merge Sort
				2) sortedStructure is a shared data structure(ArrayList) which stores the sorted elements   
			   *************************/
			  MergeSort ms = new MergeSort(sharedcopy);
			  ms.sortGivenArray();

			  ArrayList<String> sortedStructure = new ArrayList<String>();
			  for(int i:ms.getSortedArray()){
            				sortedStructure.add(Integer.toString(i)); 
        		  }


			 /************************
				1)Final Araylist after merge sort is passed to Results 
				2)Sorted elements stored in the output file
		          ************************/
			  for(String str : sortedStructure){		
			  	Results.finalArray(str);  
			  }
		
		          Results.printResult(outputFile);
			  
			  
		}
		else if(numberOfThreads == 2)
		{
			  FileProcessor input1 = new FileProcessor(args[1]);
			  FileProcessor input2 = new FileProcessor(args[2]);
			  String outputFile = args[3];
			  int debugLevel = Integer.parseInt(args[4]);

			  /***************************
				Debug value check
			  ****************************/
			  if (debugLevel >= 0 && debugLevel <= 4) {
                			MyLogger.setDebugValue(debugLevel);
            		  } else {
                			System.err.println("Invalid Debug Level.");
                			System.exit(0);
            		  }


			  /***************************
				Creating threads by calling the function threadsCreation.
				Here number of threads and array list are passed as arguments
			  ****************************/
			  ThreadWorker thread1 = new ThreadWorker(input1);
			  ThreadWorker thread2 = new ThreadWorker(input2);

			  thread1.threadsCreation(numberOfThreads, myarr);
			  thread2.threadsCreation(numberOfThreads, myarr1);

			  ArrayList<String> sharedArrList1 = myarr.print();
			  ArrayList<String> sharedArrList2 = myarr1.print();


			  /**************************
				Sequence:
				1) Print in MyArrayList.java sorts the elements
				2) Those sorted elements are sent to Results which is stored in its shared data structure(ArrayList)
				3) The shared data structure is returned from Results.java to print() in MyArrayList.java
				4) MyArrayList.java returns the shared data structure to the Driver which is stored in sharedArrList1 
				5) sharedcopy(Integer Array List) is a copy of sharedArrList2(String Array List) --> created because 
				   Integer array list is passed for Merge Sort  
			  ***************************/
			  ArrayList<Integer> sharedcopy = new ArrayList<Integer>();			
			  for(String stringValue : sharedArrList2) {
            		                sharedcopy.add(Integer.parseInt(stringValue));
            		  } 

			  /************************* 
				Merge Sort
				
				1) Passing the sharedcopy(Integer Array List to Merge Sort
				2) sortedStructure is a shared data structure(ArrayList) which stores the sorted elements   
			  *************************/
			  MergeSort ms = new MergeSort(sharedcopy);
			  ms.sortGivenArray();
			  ArrayList<String> sortedStructure = new ArrayList<String>();
			  for(int i:ms.getSortedArray()){
            				sortedStructure.add(Integer.toString(i)); 
        		  }


			 /************************
				1)Final Araylist after merge sort is passed to Results 
				2)Sorted elements stored in the output file
		          ************************/
			  for(String str : sortedStructure){		
			  	Results.finalArray(str);  
			  }
		
		          Results.printResult(outputFile);
			 			  
			  
		}
		else if(numberOfThreads == 3)
		{
			  FileProcessor input1 = new FileProcessor(args[1]);
			  FileProcessor input2 = new FileProcessor(args[2]);
			  FileProcessor input3 = new FileProcessor(args[3]);
			  String outputFile = args[4];
			  int debugLevel = Integer.parseInt(args[5]);

			  /***************************
				Debug value check
			  ****************************/
			  if (debugLevel >= 0 && debugLevel <= 4) {
                		MyLogger.setDebugValue(debugLevel);

            		  } else {
                		System.err.println("Invalid Debug Level.");
                		System.exit(0);
            		  }

		
			  /***************************
				Creating threads by calling the function threadsCreation.
				Here number of threads and array list are passed as arguments
			  ****************************/
			  ThreadWorker thread1 = new ThreadWorker(input1);
			  ThreadWorker thread2 = new ThreadWorker(input2);
			  ThreadWorker thread3 = new ThreadWorker(input3);

			  thread1.threadsCreation(numberOfThreads, myarr);
			  thread2.threadsCreation(numberOfThreads, myarr1);
			  thread3.threadsCreation(numberOfThreads, myarr2);
		
			  ArrayList<String> sharedArrList1 = myarr.print();
			  ArrayList<String> sharedArrList2 = myarr1.print();
		          ArrayList<String> sharedArrList3 = myarr2.print();


			  /**************************
				Sequence:
				1) Print in MyArrayList.java sorts the elements
				2) Those sorted elements are sent to Results which is stored in its shared data structure(ArrayList)
				3) The shared data structure is returned from Results.java to print() in MyArrayList.java
				4) MyArrayList.java returns the shared data structure to the Driver which is stored in sharedArrList1 
				5) sharedcopy(Integer Array List) is a copy of sharedArrList3(String Array List) --> created because 
				   Integer array list is passed for Merge Sort  
			  ***************************/
		          ArrayList<Integer> sharedcopy = new ArrayList<Integer>();			
			  for(String stringValue : sharedArrList3) {
            		                sharedcopy.add(Integer.parseInt(stringValue));
            		  } 

			  
			  /************************* 
				Merge Sort
				
				1) Passing the sharedcopy(Integer Array List to Merge Sort
				2) sortedStructure is a shared data structure(ArrayList) which stores the sorted elements   
			  *************************/
			  MergeSort ms = new MergeSort(sharedcopy);
			  ms.sortGivenArray();
			  ArrayList<String> sortedStructure = new ArrayList<String>();
			  for(int i:ms.getSortedArray()){
            				sortedStructure.add(Integer.toString(i)); 
        		  }


			 /************************
				1)Final Araylist after merge sort is passed to Results 
				2)Sorted elements stored in the output file
		          ************************/
			  for(String str : sortedStructure){		
			  	Results.finalArray(str);  
			  }
		
		          Results.printResult(outputFile);
					

		}

		} /***End of if for args.length check***/

		else {
			System.err.println("Number of arguments provided are not valid.");
            		System.exit(0);
		}	  

	}  // end public static void main
    }  // end public class Driver
