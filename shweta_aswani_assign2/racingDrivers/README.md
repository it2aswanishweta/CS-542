# Assignment 2
## Name: Shweta Prakash Aswani
-----------------------------------------------------------------------
## Description
In this program, we are calculating the state of mind of the driver whether its Reckless, Confident or Calculative. This calculation will be based on the driver position and total number of drivers.
The total number of drivers will be the first line in the input file. Each subsequent line will specify the distance covered by each driver in each minute. The output file will show the state of each driver in every minute.

-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

Please go to the following directory before executing the below commands:
shweta_aswani_assign1/racingDrivers/src/
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
Argument 2 will be the debug value ranging from 0 to 4

####Command: ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0


-----------------------------------------------------------------------
## Input
4
1 2 3 4
4 3 2 1
1 1.5 0.5 2
## Output
RECKLESS RECKLESS CALCULATIVE CONFIDENT
RECKLESS RECKLESS RECKLESS RECKLESS
RECKLESS CALCULATIVE RECKLESS CONFIDENT
