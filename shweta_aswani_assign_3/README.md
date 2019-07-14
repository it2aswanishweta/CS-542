# CSX42: Assignment 3
## Name: Shweta Prakash Aswani

-----------------------------------------------------------------------
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
## Description:
Links referred:
1) https://www.geeksforgeeks.org/

2) Used BST

3)Searching in BST --> In the worst case, we need to traverse all the elements to find the node, so the worst case time complexity is O(n)
  so given a height h, the time complexity of BST would be O(h)

4)Inserting a node in BST --> To insert the node, we traverse from root to leaf. In short, we examine the root recursively, insert the new node in the left,
if the key is less than the root or the right subtree if the key is greater than the root. Time Complexity -> O(h)

5)Deletion in BST --> BST has the worst state time complexity O(h)
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 10th July 2019


