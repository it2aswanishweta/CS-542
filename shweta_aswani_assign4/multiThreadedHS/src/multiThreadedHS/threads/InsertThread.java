package multiThreadedHS.threads;

import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.MyLogger;

public class InsertThread implements Runnable
{
	String getInput;

	FileProcessor input;
	MyArrayList myarr;

	public InsertThread(FileProcessor input, MyArrayList myarr)
	{
		MyLogger.writeMessage("InsertThread Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.input = input;
		this.myarr = myarr;
	}

	public void run()
	{
		MyLogger.writeMessage("InsertThread Run ", MyLogger.DebugLevel.IN_THREAD_RUN);

		/***
			1) Reading the input file and inserting the elements in the arraylist in MyArrayList.java
		***/
		
			
			while ((getInput = input.readLine()) != null) {
			
				String oneLine[] = getInput.split(" ");
                
				int xy = 0;
				while(xy < oneLine.length)
				{
					if(!oneLine[xy].equals("\n"))
					{
						if(!oneLine[xy].equals(" "))
						{
							if(!oneLine[xy].equals(""))
							{
								myarr.insert(oneLine[xy]);
							}
						}
					}

					xy++;
				}
			
			}
		
	}	

}