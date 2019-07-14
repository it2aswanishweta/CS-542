## Assignment 1
## Name: Shweta Prakash Aswani
-----------------------------------------------------------------------
## Description
In this program, we are creating a integer array in which we will have various methods performing the functions such as  --> Inserting a value in ascending order from an input file, printing the contents of array in order of insertion, removing a value, get the index of first occurrence, get the size, get the sum of the values from the input file which should then create an output file to store the sum and a toString method to print all the values in an array.
There is also a test file which will check if the program works for different test cases.

-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

Please go to the following directory before executing the below commands:
shweta_aswani_assign1/myArrayList/src/
-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant clean

Description: It cleans up all the .class files 
-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant all

Description: Compiles your code and generates .class files inside the BUILD folder.
-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt

Note: Input file can be of any name, it will generate the output file with th sum
----------------------------------------------------------------------
## Input file (every number will be on a new line)
12
6
123
10
14
## Output file
The sum of all the values in the array list is: _____


