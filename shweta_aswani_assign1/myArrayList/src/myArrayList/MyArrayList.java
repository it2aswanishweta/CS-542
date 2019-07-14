package myArrayList;

import java.io.*;
import java.lang.*; //for system.exit
import java.util.Arrays; //arrays copy
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import myArrayList.util.FileProcessor;

public class MyArrayList 
{
	
	private int a[]; //private array integer
	private int b[];
	private int input_size;
	private int duplicate_arr[];
	private int duplicate_arr1[];
	private int position;	
	private int occurrences;
	
	public int setvaluecheck = 0;
	public int insize = 0;
	List<Integer> aList;

	public MyArrayList(){

		a = new int[50]; //initial int array 
		input_size = 50; //initial int array size or initial input size
		position = 0; //initial insertion of the number
		occurrences = 0;
		aList = new ArrayList<>();
		
	}

	public MyArrayList(FileProcessor fp) {

		a = new int[50]; //initial int array 
		input_size = 50; //initial int array size or initial input size
		position = 0; //initial insertion of the number
		occurrences = 0;
		aList = new ArrayList<>();
		
	}

	public void insertSorted(int newValue){

		if (newValue >= 0 && newValue <= 10000) //this is for checking the value is in range
		{
			
			//Checking the input size of the array before inserting, become equal to 50 than make it more by 50%
			if(position >= input_size)
			{
				duplicate_arr = Arrays.copyOf(a, input_size); //creating the copy of the original array
				input_size = input_size + (input_size/2); //increasing the size of the array by 50%
				a = Arrays.copyOf(duplicate_arr, input_size); //copying back to the original array
				
			
			}
			
			insize = input_size;

			 //if the insertion of element is less than the array size continue inserting or increase the array size and then insert
			a[position] = newValue;			
			position++; //incrementing the position of element
			

			//Using binary insertion sort algorithm to sort the array, time complexity is O(log n)
			int i = 1;
			while(i < a.length)
	       			 { 
	           			 int key = a[i];
 
					//Use binary search to find the location to insert
	            			 int j = Math.abs(Arrays.binarySearch(a, 0, i, key) + 1);
					//description for Arrays.binarySearch(data_type[] arr, int fromIndex, int toIndex, data_type key) key is the value to be searched for
	  
	            			//Make array move to one location right 
	            			System.arraycopy(a, j, a, j+1, i-j); 
					// arraycopy(Object source, int sourcePosition, Object destination, int destinationPosition, int numberOfElements)
	  
	            			//Putting the element at its correct location 
	            			a[j] = key;
		
					i++; 
	        		 } 


			
      			//=========================== Data structure array list for print insertion ================================//

			b = Arrays.copyOf(a, input_size);
			for(int i1=0;i1<b.length;i1++)
   			 {
        			aList.add(b[i1]);
    			 }
    			
		}
		else
		{
			System.out.println("Your value in the input file is not between 0 and 1000");
			setvaluecheck = 1;
						
		}

	
	}

	public void printInsertionOrder(){

		System.out.println(aList);
	}

	public void removeValue(int value){

		//Check if the the list is empty
		if(a.length <= 0)
		{
			System.out.println("You are trying to remove an element from an empty list");
		}
		
		//position will be zero when nothing is inserted in the array
		else if(position == 0) 
		{
			System.out.println("You are trying to remove an element from an empty list, your value is not present");
		}

		//Removes an element
		else
		{

          	       for (int f =0; f < a.length; f++)
       			 {
        			if (a[f] == value)
        			{
        				a[f] = -1 ; //Assigning the value to -1 if found without reducing the size of the array
					position --;
					occurrences++;
        			}
       			 }

			insize = input_size;

			// Arraylist removal for print insertion order

     			   	aList.removeAll(Arrays.asList(value));
       			   	//System.out.println("List after removal :"+aList);

			// ends arraylist

		    compact();
		}
       	}

	public void compact(){

	/*Here i am shifting the elements from right to left, the number of times the element which needs to be removed is occurred
	  if array is [1,2,3,3,3,3,4]---> remove 3 will give [1,2,-1,-1,-1,-1,4]
	  compact will give [1,2,4,-1,-1,-1,-1]

	  occurrence if 3 is 4 times over here so it a[2] = a[6]
	*/
	  boolean keep =false;
          for (int f =0; f < a.length; f++)
      		{
        
	    		if((a[f] == -1) || (keep == true))
	    		{
			   keep = true;
	    			if((f+occurrences) < a.length)
	    			{
	    			a[f] = a[f+occurrences];
	    			
	    			}
	    		
	    		}
       		 }
        //Initializing the empty slots to -1
        int lg = a.length - occurrences;
        for(int g = a.length-1; g>=lg; g--)
        {
        	a[g] = -1;
        }
       		
      /* trial -> changing the size
       int old_length = a.length;
       int new_length = old_length - occurrences; 
       duplicate_arr1 = Arrays.copyOf(a, new_length);

       a = Arrays.copyOf(duplicate_arr1, new_length);
	
       for (int f =0; f < duplicate_arr1.length ; f++)
            System.out.println(duplicate_arr1[f]);*/

	}

	public int indexOf(int value){

	  boolean flag = false;
	  int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (value == a[i]) {
				index = i;
				flag = true;
				break;
			}
		}
	  
	  if(flag == true)
	  	return index;
	  else
		return -1;
		
	}

	public int size(){

		  return position;
	}

	public int sum(){
		 
	  int sum = 0;

	  for (int i = 0; i < a.length; i++)
		 {
			if(a[i] != -1)
				sum += a[i];
		 }
		
	
          return sum;

	}

	public String toString(){
		
	String str= "[";
		for (int i = 0; i < a.length; i++) {
			str = str + a[i];
			if(i != a.length-1)
			str = str + ", ";
		}

		str = str + "]";
	
		return str;	
	}

}
