package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;
import java.util.ArrayList;

public class TreeBuilder
{

	public Node root;
	public String writeFile;
	public TreeBuilder()
	{
		root = null;
		writeFile = "";
		MyLogger.writeMessage("Tree Builder: ", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public Node rootInsertion(Node node) {
        	root = nodeInsertion(node, root);
        	return root;
    	
	}
	public Node nodeInsertion(Node n, Node root)
	{
		if(root == null){
			root = n;
			return n;
		}
		else if(n.b_no < root.b_no)
		{	
			root.lhs = nodeInsertion(n ,root.lhs);
		}
		else if(n.b_no > root.b_no)
		{
			root.rhs = nodeInsertion(n, root.rhs);
		}
		else if(n.b_no == root.b_no)
		{	
			if (!root.list.contains(n.course)) {
                		root.list.add(n.course);
            		}
	
		}		
      
       	return root;
	}

	public Node nodeSearch(int B_No)
	{	
		Node rOot = root;
		while(rOot != null)
		{
			if(rOot.b_no  > B_No)
				rOot = rOot.lhs;
			else if(rOot.b_no  < B_No)
				rOot = rOot.rhs;
			else
				return rOot;
		}

		return null;
	}

	public void nodeDeletion(Node root, String course) 
	{
		
        	if (root.list.contains(course)) 
		{
            		root.list.remove(course);
        	}
    	}

	public String updatedList(ArrayList<String> courses) {
		int counter = 0;
        	String ListOfCourses = "";
		
		for(int i=0; i<courses.size(); i++)
		{
			if(counter != 0){
				ListOfCourses = ListOfCourses + ", " + courses.get(i);
			}
                	else {
                		ListOfCourses = ListOfCourses + courses.get(i);
				counter ++;
            		}
        	}
	    
            return ListOfCourses;
    	}

	public void printFunction() {
              printFunction(root);
        }
	public void printFunction(Node output1)
	{
		if (output1 != null) 
		{
			printFunction(output1.lhs);
        		writeFile = writeFile + output1.b_no + ": " + updatedList(output1.list) + "\n";
        		printFunction(output1.rhs);		
		}
	
	}

 	public void printNodes(Results result) 
	{
        	result.stringToStore(writeFile);
    	}
} 