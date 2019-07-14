
package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest{


	public void testMe(MyArrayList myArrayList, Results results) {

		insertSortedCheck(myArrayList, results);
		checkBoundaryInsertion(myArrayList, results);
		removeValueCheck(myArrayList, results);
		removeFromBoundary(myArrayList, results);
		removalSumCheck(myArrayList, results);
		compactCheck(myArrayList, results);
		indexCheck(myArrayList, results);
		sizeCheck(myArrayList, results);
		listEmptyCheck(myArrayList, results);
		arrayCapacity(myArrayList, results);
		
	}

		/* To check whether the elements inserted are sorted or not */
		public void insertSortedCheck(MyArrayList myArrayList, Results results){
			
			myArrayList = new MyArrayList();	
			String out_put = "";				
			
			myArrayList.insertSorted(45);
			myArrayList.insertSorted(33);
			myArrayList.insertSorted(54);
			myArrayList.insertSorted(6);

			if(myArrayList.indexOf(45) < myArrayList.indexOf(54))
			{
			   if(myArrayList.indexOf(33) < myArrayList.indexOf(45))
				{
				  if(myArrayList.indexOf(6) < myArrayList.indexOf(33))
				    {
				    out_put = "PASS";
				    }}}
			else
				    out_put = "FAIL";

			results.storeNewResult("Test1 -> Sort: ", out_put);

		}

		/*To check if the element inserted if outside rthe boundary of 0 and 10000*/
		public void checkBoundaryInsertion(MyArrayList myArrayList, Results results){
			
			String out_put = "";
			myArrayList = new MyArrayList();
			
			myArrayList.insertSorted(1500000);

			if(myArrayList.setvaluecheck == 1){
				 out_put = "PASS";
				 results.storeNewResult("Test2 -> Value not between 0 and 10000: ", out_put);
			}
			else if(myArrayList.setvaluecheck == 0){
				out_put = "FAIL";
				results.storeNewResult("Test2 -> Value not between 0 and 10000: ", out_put);

			}
			 

		}

		/*To check if the value still exists after removal*/
		public void removeValueCheck(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "PASS";

			myArrayList.insertSorted(77);
			myArrayList.insertSorted(34);
			myArrayList.insertSorted(55);
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(4);
			myArrayList.insertSorted(4);
					
			myArrayList.removeValue(4);
			
            		if (myArrayList.indexOf(4) != -1)
				{
				out_put = "FAIL";
				}
				
			
			results.storeNewResult("Test3 -> Remove value: ", out_put);

		}

		/*Trying to remove a value outside 0 and 10000*/
		public void removeFromBoundary(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			myArrayList.insertSorted(77);
			myArrayList.insertSorted(34);
			myArrayList.insertSorted(55);
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(4);

			int before_removal = myArrayList.size();
			myArrayList.removeValue(689468);
			int after_removal = myArrayList.size();
		
			if( before_removal ==  after_removal)
				out_put = "PASS";
			else
				out_put = "FAIL";
			
			results.storeNewResult("Test4 -> Removing an element which is not between 0 and 10000: ", out_put);

		}

		/*Trying to remove a value and then checking if the sum changes*/
		public void removalSumCheck(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			myArrayList.insertSorted(4);
			myArrayList.insertSorted(3);
			myArrayList.insertSorted(2);

			myArrayList.removeValue(3);

			if(myArrayList.sum() == 6)
				out_put = "PASS";
			else
				out_put = "FAIL";
		
			results.storeNewResult("Test5 -> Sum Check: ", out_put);
			
		}

		/*To check if the empty buckets are there are not*/
		public void compactCheck(MyArrayList myArrayList, Results results){
			
			myArrayList = new MyArrayList();
			String out_put = "";

			myArrayList.insertSorted(77);
			myArrayList.insertSorted(34);
			myArrayList.insertSorted(55);
			myArrayList.insertSorted(11);
			myArrayList.insertSorted(4);

			myArrayList.removeValue(11);

			int before_compact = myArrayList.indexOf(55);
			myArrayList.compact();
			int after_compact = myArrayList.indexOf(55);

			if(after_compact > before_compact)
				out_put = "FAIL";
			else
				out_put = "PASS";

			results.storeNewResult("Test6 -> Compact Check: ", out_put);


		}

		/*To check if the index of the element which does not exist*/
		public void indexCheck(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			myArrayList.insertSorted(77);
			myArrayList.insertSorted(34);
			myArrayList.insertSorted(55);
			myArrayList.insertSorted(11);
			myArrayList.insertSorted(4);

			if(myArrayList.indexOf(57) == -1)
				out_put = "PASS";
			else
				out_put = "FAIL";
		
			results.storeNewResult("Test7 -> Index Check: ", out_put);


		}

		/*To check the total number of values stored */
		public void sizeCheck(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			myArrayList.insertSorted(77);
			myArrayList.insertSorted(34);
			myArrayList.insertSorted(55);


			myArrayList.removeValue(34);


			myArrayList.insertSorted(11);
			myArrayList.insertSorted(4);

			if(myArrayList.size() == 4)
				out_put = "PASS";
			else
				out_put = "FAIL";
		
			results.storeNewResult("Test8 -> Size Check: ", out_put);


		}

		/*To check if the list if empty or not*/
		public void listEmptyCheck(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			if(myArrayList.size() == 0)
				out_put = "PASS";
			else
				out_put = "FAIL";
		
			results.storeNewResult("Test9 -> List Empty Check: ", out_put);	
					

		}
		
		/*Initial Arraylist size is 50, when we are trying to insert the value at 50, the array size will increase by 50%, which should be 75 over here*/
		public void arrayCapacity(MyArrayList myArrayList, Results results){

			myArrayList = new MyArrayList();
			String out_put = "";

			int i =0;
			while(i < 50){
				myArrayList.insertSorted(i);
				i++;
			}

			myArrayList.insertSorted(50);
			myArrayList.insertSorted(51);

			myArrayList.removeValue(34);
			myArrayList.insertSorted(51);


			if(myArrayList.insize == 75)
				out_put = "PASS";
			else
				out_put = "FAIL";
		
			results.storeNewResult("Test10 -> Capacity Check: ", out_put);			

			

		}


}