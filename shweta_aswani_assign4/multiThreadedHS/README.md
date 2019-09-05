##Description

In this assignment, we create threads to read from the input files provided in the command line and store in the appropriate data structure such that the data should be sorted. We are creating another data structure for Results.java where the threads insert the values in the first available slot. We use the synchronized method in Results.java to insert the values. After inserting the values, we perform Merge sort on the data stored in Results.java from which the data is then stored in output.txt

---------------------------------------------------------------
##Commands and the instructions to run ANT on your project.

Please go to the following directory before executing the below commands:
multiThreadedHS/src/
-----------------------------------------------------------------
## Instruction to clean:

####Command: ant clean

Description: It cleans up all the .class files 

-----------------------------------------------------------------
## Instruction to compile:

####Command: ant all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------
## Instruction to run:

Debug value can be from 0 to 4
####Command: For number of threads = 1
	     --> ant -buildfile build.xml run -Dargs='1 input1.txt output.txt 0'
	
	     For number of threads = 2
	     --> ant -buildfile build.xml run -Dargs='2 input1.txt input2.txt output.txt 0'	     

	     For number of threads = 3
	     --> ant -buildfile build.xml run -Dargs='3 input1.txt input2.txt input3.txt output.txt 0'

-----------------------------------------------------------------
##Justification of Data Structures

Data structure which I have used for the assignment is as follows:
	1) Each thread will have their own data structure -> arrayList
	2) Shared data structure in Results to store all the elements of the thread --> arrayList 
	3) Merge Sort --> arrayList
  
For 1) and 2) I am only adding the elements in the array list, so the time complexity is O(1)

For 3)
Dividing the array will take O(log n) time and will create log n level of sub arrays.
Conquer part at each level will merge 2 sorted arrays which takes O(n) at each level.
So worst case time taken by merge sort is O(n log n).
