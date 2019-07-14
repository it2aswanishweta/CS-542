package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.util.MyLogger;

public class Node implements SubjectI, ObserverI, Cloneable
{
	public int b_no;
	public ArrayList<String> list;
    	public String course;	
	public ArrayList<Node> observerList;
	public Node lhs, rhs;
	
	public Node() {
        	this.b_no = 0;
		this.course = "";
        	this.lhs = null;
        	this.rhs = null; 	
        	this.list = new ArrayList<String>();
        	this.observerList = new ArrayList<Node>();
		MyLogger.writeMessage("Node Class: ", MyLogger.DebugLevel.CONSTRUCTOR);
    	}

	public Node(int b_no, String course)
	{
		this.b_no = b_no;
		this.course = course;
		this.list = new ArrayList<String>();
		this.list.add(course);
		this.observerList = new ArrayList<Node>();
		this.lhs = null;
		this.rhs = null;		
	}

	public int get_BNo() 
	{
    		return this.b_no;
    	}

	public void store_BNo(int b_no)
	{
		this.b_no = b_no;
	}

	public ArrayList<String> get_Course() 
	{
        	return this.list;
        }

	public void store_Course(String course)
	{
		this.list = list;
	}

	public Object clone() 
	{
		Node copy = new Node(b_no, course);
        	return copy;
    	}

	public void registerOrDregisterObserver(Node obs, String value)
	{
		if(value == "R")
		{
			observerList.add(obs);
		}
		else if(value == "D")
		{
			 if(observerList.contains(obs)) 
			  {
           			 observerList.remove(obs);
        		  }
		}
	}

	public void update(Node node, String course) 
	{
		boolean check = node.list.contains(course);
        	if(check == true) 
		{
            		node.list.remove(course);
        	}
    	}

	public void notifyAll(String course) 
	{
        	for(Node node: observerList) 
		{
            		update(node, course);
        	}
    	}
}