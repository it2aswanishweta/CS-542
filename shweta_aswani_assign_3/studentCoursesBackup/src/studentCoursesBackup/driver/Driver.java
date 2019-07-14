package studentCoursesBackup.driver;
   
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;

import java.util.ArrayList;

    public class Driver {
	
	public static void main(String[] args) {
	    
	    String str, couRse, str1;
	    int Bnumber;
	    Node node, backupNode1, backupNode2, existingNode = null;
	   
	    
            TreeBuilder newNodeT = new TreeBuilder();
	    TreeBuilder Tbackup1 = new TreeBuilder();
	    TreeBuilder Tbackup2 = new TreeBuilder();
	    String msg=null;

	    if ((args.length != 6)) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);

	    } // end of if

	    
	    FileProcessor fileInput = new FileProcessor(args[0]);
	    FileProcessor fileDelete = new FileProcessor(args[1]);
	    Results output1 = new Results(args[2]);
	    Results output2 = new Results(args[3]);
	    Results output3 = new Results(args[4]);
		
	    /**
		Reading the file:
		1) Storing the B number and checking if its valid or not 
		2) course validity
		3) create nodes, clone them, register, insert node
		4) check if courses are present, if not add the course 
		
	    **/
	    while ((str = fileInput.readLine()) != null) {
		
	     try{

		Bnumber = Integer.parseInt(str.split(":")[0].trim());
		if((Bnumber <0000) || (Bnumber > 9999))
		{
			
			msg = " B number is not valid.";
			MyLogger.writeMessage(msg, MyLogger.DebugLevel.IN_RUN);

			System.out.println("B Number is not valid");
			System.exit(0);
		}
		
		couRse = str.split(":")[1].trim();
		existingNode = newNodeT.nodeSearch(Bnumber);

		if( (couRse.length()==1) && (couRse.matches("[A-K]")) )
		{
			if(existingNode == null)
			{	
				node = new Node(Bnumber, couRse);

                       		backupNode1 = (Node) node.clone();
                        	backupNode2 = (Node) node.clone();

                        	node.registerOrDregisterObserver(backupNode1, "R");
                        	node.registerOrDregisterObserver(backupNode2, "R");

                        	newNodeT.rootInsertion(node);
                        	Tbackup1.rootInsertion(backupNode1);
				Tbackup2.rootInsertion(backupNode2);
			}
			else
			{
				boolean checking = existingNode.list.contains(couRse); 
				if(checking == false) {
                            		existingNode.list.add(couRse);

					Node getO = existingNode.observerList.get(0);
                            		getO.list.add(couRse);
	
					Node getI = existingNode.observerList.get(1);
                            		getI.list.add(couRse);
                        	}

			}
		}
						
	    }catch(Exception e) {
                e.printStackTrace();
            }

	    } //end of while for insert


	    /***
		Deletion of courses
		1) bnumber --> extract and validation
		2) course --> extract
		3) search for node using bnumber
		4) if exists then delete the course
		5) notify the observers

	    ***/
	    while ((str1 = fileDelete.readLine()) != null) 
	    {
		try{

			Bnumber = Integer.parseInt(str1.split(":")[0].trim());
			if((Bnumber <0000) || (Bnumber > 9999))
			{
				
				msg = " B number is not valid.";
				MyLogger.writeMessage(msg, MyLogger.DebugLevel.IN_RUN);
				

				System.out.println("B Number is not valid");
				System.exit(0);
			}
	
			couRse = str1.split(":")[1].trim();
			existingNode = newNodeT.nodeSearch(Bnumber);
			
				if(existingNode != null)
				{
					newNodeT.nodeDeletion(existingNode, couRse);
					existingNode.notifyAll(couRse);
				}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
            }

	    /**
		1) Created three separate instance for result
		2) Sort in ascendin order based on B number
		3) Write to file

	    **/

	    newNodeT.printFunction();
	    newNodeT.printNodes(output1);
	    output1.writeToFile(output1.string1);

	    Tbackup1.printFunction();
	    Tbackup1.printNodes(output2);
	    output2.writeToFile(output2.string1);

	    Tbackup2.printFunction();
	    Tbackup2.printNodes(output3);
	    output3.writeToFile(output3.string1);
		
	   	    
	}  // end public static void main
    }  // end public class Driver
