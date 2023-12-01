# cs401project

##Problem Specification 
You must construct a list (from a data file or from user input) and then implement two types of sorting algorithms: simple (such as selection sort, insertion sort, or bubble sort) and sophisticated (such as quick sort, merge sort, or heap sort). The purpose is to quantify the number of comparisons made by each algorithm in order to identify which one is more efficient, while also matching these results with theoretical assumptions based on their Big-O notation complexity.

Similarly, when it comes to searching algorithms, you should compare linear search with binary search tree (BST) and hashing. The efficiency of various searching algorithms will be assessed based on their complexity in comparison to linear, binary, and hash function searching.
Software specification 
BSTNode.java: This file defines a class BSTNode for a node in a Binary Search Tree (BST). It includes the following functions:

Constructor to initialize a node with an item.
Getters and setters for the item and the left and right child nodes.
contains method to check if a certain item is present in the subtree rooted at this node.
DLLNode.java: This file likely defines a class for a node in a Doubly Linked List (DLL). Common functions in such a class include:

Constructor for initializing the node with an item.
Getters and setters for the item, and the previous and next nodes in the list.
DLLToBSTConverter.java: This file is expected to contain methods for converting a Doubly Linked List into a Binary Search Tree. Key functions might include:

A method to convert the entire list to a BST.
Helper methods to handle the conversion process, possibly involving recursion.
HashNode.java: This file probably contains a class definition for a node in a hash table. Typical functions might include:

Constructor for initializing the node with a key-value pair.
Getters and setters for the key, value, and possibly a reference to the next node (in case of collision handling).
Main.java: This is likely the main driver class of your application. It could contain:

The main method to run the application.
Code to demonstrate or test the functionalities of the other classes (like creating and manipulating BSTs, DLLs, and hash tables).
Search.java: This file likely contains various search algorithms. Functions could include:

Methods for linear search, binary search, and hash-based search.
Possibly helper methods for setting up data structures for these searches.
Sort.java: This file is expected to contain sorting algorithms. It might include functions for:

Different sorting methods like bubble sort, quicksort, merge sort, etc.
Possibly utility functions for partitioning arrays, merging arrays, etc.


## User manual 
1. open cmd 
2. go the directory where the jar file is located 
3. execute java -jar cs401.jar
4. there will be a message "Which file type do you want to choose:" 
5. there will be 3 option:  1: String.txt , 2:  Float.txt 3: Integer.txt
6. user will select the number to chose 
7. it will print the sorted list under the line Sorted list:
8. it will print the "Total operation SelectionSort:" + number of comparison
it will print the "Total operation InsertionSort:" + number of comparison
 it will print the "Total operation BubbleSort:" + number of comparison
 it will print the "Total operation SelectionSort:" + number of comparison
 it will print the "Total operation QuickSort:" + number of comparison
 it will print the "Total operation HeapSort:" + number of comparison
it will print the "Total operation MergeSort:" + number of comparison

9. there will be a message “find the value that you want on the list :”
10. user can type the value 
11. it will search the value: 
it will print  “search in BST :” true (if it exist) or false (if it does not exist)
it will print  “search in Binary Search:” true (if it exist) or false (if it does not exist)
it will print  “search in HashSearch:” true (if it exist) or false (if it does not exist)
it will print  “search in LinearSearch:” true (if it exist) or false (if it does not exist)




## Complexity analysis 
### Sorting
Selection Sort
Time Complexity 
Worst and Average Case O (n^2)
Best Case O (n^2)

Insertion Sort
Time Complexity 
Worst and Average Case O (n^2)
Best Case O(n)

Bubble Sort
Time Complexity 
Worst and Average Case O (n^2)
Best Case O(n)

Quick Sort
Time Complexity 
Worst case O (n^2)
Best and Average Case O (n log n)

Heap Sort 
Time Complexity 
All case O(n log n)

Merge Sort
Time Complexity 
All case O(n log n)

### Searching
Linear Search
Time Complexity 
Worst and Average Case O (n)
Best case O (1)

Binary Search
Time Complexity 
All case O (n log n)

Hash-Based Search
Time Complexity 
Average Case O (1)
Worst case O(n)

BST 
Time Complexity 
Average Case O (n log n)
Worst case O(n)



