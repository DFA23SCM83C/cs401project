package CS401;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.Scanner;



//Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
//then press Enter. You can now see whitespace characters in your code.
public class Main {
 public static void main(String[] args) throws FileNotFoundException {
	  Scanner scannerInput = new Scanner(System.in);
      System.out.println("Which file type do you want to choose:");
      System.out.println("1: String.txt");
      System.out.println("2: Float.txt");
      System.out.println("3: Integer.txt");
      int fileoption = scannerInput.nextInt();
	  String filename =null;
	  String type;
	
	
		
	 if(fileoption ==1) {
		 Scanner scanner = new Scanner(new File("String.txt")); // create scanner objects for sorted linkedlist 
		DLLNode<String> myListSelection = new DLLNode<>();
		DLLNode<String> myListInsertion = new DLLNode<>();
		DLLNode<String> myListBubble = new DLLNode<>();
		DLLNode<String> myListQuick = new DLLNode<>();
		DLLNode<String> myListHeap = new DLLNode<>();
		DLLNode<String> myListMerge = new DLLNode<>();
	
		 while (scanner.hasNext()) {
	    	 
			  String number = scanner.next(); // Read an integer (employee ID) from the file
			  myListSelection.Add(number);
			  myListInsertion.Add(number);
			  myListBubble.Add(number);
			  myListQuick.Add(number);
			  myListHeap.Add(number);
			  myListMerge.Add(number);
			 
	     }
	  Sort SelectionSort= new Sort(myListSelection);
	  SelectionSort.SelectionSort();
	  Sort InsertionSort= new Sort(myListInsertion);
	  InsertionSort.InsertionSort();
	  Sort BubbleSort= new Sort(myListBubble);
	  BubbleSort.BubbleSort();
	  Sort QuickSort= new Sort(myListQuick);
	  QuickSort.QuickSort();
	  Sort HeapSort= new Sort(myListHeap);
	  HeapSort.HeapSort();
	  Sort MergeSort= new Sort(myListMerge);
	  MergeSort.MergeSort();
	   System.out.println("Sorted list:");
	   myListMerge.printList();
	   SelectionSort.getSelectionSortComparisons();
	   InsertionSort.getInsertionSortComparisons();
	   BubbleSort.getBubbleSortComparisons();
	   QuickSort.getQuickSortComparisons();
	   HeapSort.getHeapSortComparisons();
	   MergeSort.getMergeSortComparisons();
	  
	 System.out.println("find the value that you want on the list :");
	 String value = scannerInput.next();
	 DLLToBSTConverter<String> converter = new DLLToBSTConverter<>(myListMerge);
     BSTNode<String> bstRoot = converter.convertToBST();
     Search<String> search = new Search<String>(myListMerge); 
     System.out.println("search in BST :"+ bstRoot.contains(value));
     System.out.println("search in Binary Search :"+  search.binarySearch(value));
     System.out.println("search in HashSearch :"+  search.hashSearch(value));
     System.out.println("search in LinearSearch :"+  search.linearSearch(value));
	 }
	 if(fileoption ==2) {
			 Scanner scanner = new Scanner(new File("Float.txt")); // create scanner objects for sorted linkedlist 

			    DLLNode<Float> myListSelection = new DLLNode<>();
				DLLNode<Float> myListInsertion = new DLLNode<>();
				DLLNode<Float> myListBubble = new DLLNode<>();
				DLLNode<Float> myListQuick = new DLLNode<>();
				DLLNode<Float> myListHeap = new DLLNode<>();
				DLLNode<Float> myListMerge = new DLLNode<>();
				 while (scanner.hasNext()) {
			    	 
					  Float number = scanner.nextFloat(); // Read an integer (employee ID) from the file
					  myListSelection.Add(number);
					  myListInsertion.Add(number);
					  myListBubble.Add(number);
					  myListQuick.Add(number);
					  myListHeap.Add(number);
					  myListMerge.Add(number);
			     }
				  Sort SelectionSort= new Sort(myListSelection);
				  SelectionSort.SelectionSort();
				  Sort InsertionSort= new Sort(myListInsertion);
				  InsertionSort.InsertionSort();
				  Sort BubbleSort= new Sort(myListBubble);
				  BubbleSort.BubbleSort();
				  Sort QuickSort= new Sort(myListQuick);
				  QuickSort.QuickSort();
				  Sort HeapSort= new Sort(myListHeap);
				  HeapSort.HeapSort();
				  Sort MergeSort= new Sort(myListMerge);
				  MergeSort.MergeSort();
				   System.out.println("Sorted list:");
				   myListMerge.printList();
				   SelectionSort.getSelectionSortComparisons();
				   InsertionSort.getInsertionSortComparisons();
				   BubbleSort.getBubbleSortComparisons();
				   QuickSort.getQuickSortComparisons();
				   HeapSort.getHeapSortComparisons();
				   MergeSort.getMergeSortComparisons();
				   
				   System.out.println("find the value that you want on the list :");
					 float value = scannerInput.nextFloat();
					 DLLToBSTConverter<Float> converter = new DLLToBSTConverter<>(myListMerge);
				     BSTNode<Float> bstRoot = converter.convertToBST();
				     Search<Float> search = new Search<Float>(myListMerge); 
				     System.out.println("search in BST :"+ bstRoot.contains(value));
				     System.out.println("search in Binary Search :"+  search.binarySearch(value));
				     System.out.println("search in HashSearch :"+  search.hashSearch(value));
				     System.out.println("search in LinearSearch :"+  search.linearSearch(value));
	 }
	 if(fileoption ==3) {
		   Scanner scanner = new Scanner(new File("Integer.txt")); // create scanner objects for sorted linkedlist 
		   DLLNode<Integer> myListSelection = new DLLNode<>();
			DLLNode<Integer> myListInsertion = new DLLNode<>();
			DLLNode<Integer> myListBubble = new DLLNode<>();
			DLLNode<Integer> myListQuick = new DLLNode<>();
			DLLNode<Integer> myListHeap = new DLLNode<>();
			DLLNode<Integer> myListMerge = new DLLNode<>();
			while (scanner.hasNext()) {
		    	 
				  int number = scanner.nextInt(); // Read an integer (employee ID) from the file
				  myListSelection.Add(number);
				  myListInsertion.Add(number);
				  myListBubble.Add(number);
				  myListQuick.Add(number);
				  myListHeap.Add(number);
				  myListMerge.Add(number);
		     }
			  Sort SelectionSort= new Sort(myListSelection);
			  SelectionSort.SelectionSort();
			  Sort InsertionSort= new Sort(myListInsertion);
			  InsertionSort.InsertionSort();
			  Sort BubbleSort= new Sort(myListBubble);
			  BubbleSort.BubbleSort();
			  Sort QuickSort= new Sort(myListQuick);
			  QuickSort.QuickSort();
			  Sort HeapSort= new Sort(myListHeap);
			  HeapSort.HeapSort();
			  Sort MergeSort= new Sort(myListMerge);
			  MergeSort.MergeSort();
			   System.out.println("Sorted list:");
			   myListMerge.printList();
			   SelectionSort.getSelectionSortComparisons();
			   InsertionSort.getInsertionSortComparisons();
			   BubbleSort.getBubbleSortComparisons();
			   QuickSort.getQuickSortComparisons();
			   HeapSort.getHeapSortComparisons();
			   MergeSort.getMergeSortComparisons();
			   
			   System.out.println("find the value that you want on the list :");
				 int value = scannerInput.nextInt();
				 DLLToBSTConverter<Integer> converter = new DLLToBSTConverter<>(myListMerge);
			     BSTNode<Integer> bstRoot = converter.convertToBST();
			     Search<Integer> search = new Search<Integer>(myListMerge); 
			     System.out.println("search in BST :"+ bstRoot.contains(value));
			     System.out.println("search in Binary Search :"+  search.binarySearch(value));
			     System.out.println("search in HashSearch :"+  search.hashSearch(value));
			     System.out.println("search in LinearSearch :"+  search.linearSearch(value));
	 }  	   
    



 }

 }

