# Assignment3
## Name: Shweta Prakash Aswani
-----------------------------------------------------------------------
## Description

In this program, we are creating a tree which store the B-Number (4 digits int) and an arraylist of courses names (strings). The tree should be able to insert and search nodes. It should be able to delete the courses not the nodes. While creating or insertinga new node, it should be cloned twice. This program implements the observer pattern where the parent tree is the subject and will notify about the changes to its two children who are the observers.

-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

Please go to the following directory before executing the below commands:
shweta_aswani_assign3/studentCoursesBackup/src/

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=debugValue

-----------------------------------------------------------------------
## Input file
1234:C
2345:D
1234:A
1234:D
1234:E
2345:F
3425:C

## Delete file
1234:A
1234:D
1234:E

## Output file
1234:C
2345:D, F
3425:C
