package multiThreadedHS.threads;

import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.Results;
import multiThreadedHS.util.MyLogger;

public class ThreadWorker
{
	Thread read[];
        FileProcessor input;
	MyArrayList myarr;       		
	Results result;

	public ThreadWorker(FileProcessor input)
	{	
		MyLogger.writeMessage("ThreadWorker Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.input = input;
		this.myarr = myarr;
	        this.result = result;
	}

	public void threadsCreation(int numberOfThreads, MyArrayList myarr) throws InterruptedException {
        	
		/****
			1)Creating a new thread
			2)Inserting the elements in the data structure of the thread(Array List) by calling the InsertThread
			3)In InsertThread, input file and array list is passed as the argument
			4)Start the thread 
		****/
		read = new Thread[numberOfThreads];

        	for (int i = 0; i < numberOfThreads; i++) {
            		read[i] = new Thread(new InsertThread(input, myarr));
            		read[i].start();
        	}
        
		for (int i = 0; i < numberOfThreads; i++) {
            		read[i].join();

		
        }
    }

}