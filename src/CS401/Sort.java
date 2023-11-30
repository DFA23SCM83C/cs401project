package CS401;

public class Sort<T extends Comparable<T>> {
    DLLNode<T> list;// The head of the doubly linked list to be sorted.
    int size;// The size of the list, calculated dynamically for certain sorting algorithms.
    int selectionSortComparisons;// Counter for the number of comparisons made during Selection Sort.
    int insertionSortComparisons;// Counter for the number of comparisons made during Insertion Sort.
    int bubbleSortComparisons;// Counter for the number of comparisons made during Bubble Sort.
    int quickSortComparisons;// Counter for the number of comparisons made during Quick Sort.
    int heapSortComparisons;// Counter for the number of comparisons made during Heap Sort.
    int mergeSortComparisons;// Counter for the number of comparisons made during Merge Sort.
    public Sort (DLLNode list){// Initializes a Sort object with the given doubly linked list.
    this.list = list;
    }
    //Sorts the list using the Selection Sort algorithm.
    public void SelectionSort(){
        DLLNode current = this.list;

        while (current != null) {
            // Find the minimum value node in the remaining unsorted part of the list
            DLLNode minNode = findMinNode(current);

            // Swap the values of the current node and the minimum value node
            T temp = (T) current.getItem();
            current.setItem(minNode.getItem());
            minNode.setItem(temp);

            // Move to the next node in the unsorted part
            current = current.getNext();
        }
    }
    //Finds the node with the minimum value starting from startNode.
    private DLLNode<T> findMinNode(DLLNode<T> startNode) {
        if (startNode == null) {
            return null;
        }

        DLLNode<T> minNode = startNode;
        DLLNode<T> current = startNode.getNext();

        while (current != null) {
            if (current.compareTo(minNode) < 0) {
                minNode = current;
                selectionSortComparisons++;
            }
            current = current.getNext();
        }

        return minNode;
    }
   //Sorts the list using the Insertion Sort algorithm.
    public void InsertionSort() {
        DLLNode<T> sorted = null;
        DLLNode<T> current = this.list;

        while (current != null) {
            DLLNode<T> next = current.getNext();
            sorted = insert(sorted, current);
            current = next;
        }

        this.list = sorted;
    }
//Inserts newNode into its correct position in the sorted part of the list.
    private DLLNode<T> insert(DLLNode<T> sorted, DLLNode<T> newNode) {
        if (sorted == null || sorted.compareTo(newNode) >= 0) {
            newNode.setNext(sorted);
            if (sorted != null) {
                sorted.setBack(newNode);
            }
            return newNode;
        }

        DLLNode<T> current = sorted;
        while (current.getNext() != null && current.getNext().compareTo(newNode) < 0) {
            current = current.getNext();
            insertionSortComparisons++;
        }

        newNode.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setBack(newNode);
        }
        current.setNext(newNode);
        newNode.setBack(current);

        return sorted;
    }

//Sorts the list using the Bubble Sort algorithm.
    public void BubbleSort() {
        DLLNode<T> current = this.list;
        DLLNode<T> last = lastNode(this.list);

        while (current != null) {
            DLLNode<T> next = current.getNext();

            while (next != null) {
                T currentItem = current.getItem();
                T nextItem = next.getItem();

                if (currentItem != null && nextItem != null && currentItem.compareTo(nextItem) > 0) {
                    // Swap elements
                    T temp = current.getItem();
                    current.setItem(next.getItem());
                    next.setItem(temp);
                    bubbleSortComparisons++;
                }

                next = next.getNext();
            }

            current = current.getNext();
        }
    }


//Sorts the list using the Quick Sort algorithm.
    public void QuickSort() {
        DLLNode<T> head = this.list;
        DLLNode<T> tail = lastNode(list);
        quickSort(head, tail);
    }

//Recursive helper method for Quick Sort.
    private void quickSort(DLLNode<T> low, DLLNode<T> high) {
        if (low != null && high != null && low != high && low != high.getNext()) {
            DLLNode<T> pivot = partition(low, high);
            quickSort(low, pivot.getBack());
            quickSort(pivot.getNext(), high);
        }
    }
//Partitions the list for Quick Sort.
    private DLLNode<T> partition(DLLNode<T> low, DLLNode<T> high) {
        T pivot = high.getItem();
        DLLNode<T> i = new DLLNode<>(); // Temporary dummy node
        i.setNext(low);

        for (DLLNode<T> j = low; j != high; j = j.getNext()) {
            T jItem = j.getItem();
            // Assuming null values are treated as less than non-null values
            if (jItem == null || (pivot != null && jItem.compareTo(pivot) <= 0)) {
                i = i.getNext(); // Move i to the next node
                swap(i, j);
                quickSortComparisons++;
            }
        }
        swap(i.getNext(), high); // Place pivot in the correct position
        return i.getNext(); // Return the position of the pivot
    }
//Swaps the items of two given nodes.
    private void swap(DLLNode<T> a, DLLNode<T> b) {
        T temp = a.getItem();
        a.setItem(b.getItem());
        b.setItem(temp);
    }
    //Returns the last node in the list.
    private DLLNode<T> lastNode(DLLNode<T> node) {
        while (node != null && node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }
//Sorts the list using the Heap Sort algorithm.
    public void HeapSort() {
        buildMaxHeap();
        for (int i = size; i > 1; i--) {
            swap(getNode(1), getNode(i)); // Swap root with the last element
            size--;
            heapify(getNode(1), 1);
        }
    }
    private int calculateSize() {
        int count = 0;
        DLLNode<T> current = list;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    private void buildMaxHeap() {
        size = calculateSize();// Determine the size of the list
        for (int i = size / 2; i >= 1; i--) {
            heapify(getNode(i), i);
        }
    }
//Maintains the max heap property for Heap Sort.
    private void heapify(DLLNode<T> node, int i) {
        int leftIndex = 2 * i;
        int rightIndex = 2 * i + 1;
        int largest = i;

        DLLNode<T> left = getNode(leftIndex);
        DLLNode<T> right = getNode(rightIndex);

        if (leftIndex <= size && isGreater(left.getItem(), node.getItem())) {
            largest = leftIndex;
            heapSortComparisons++;
        }
        if (rightIndex <= size && isGreater(right.getItem(), getNode(largest).getItem())) {
            largest = rightIndex;
            heapSortComparisons++;
        }
        if (largest != i) {
            swap(node, getNode(largest));
            heapify(getNode(largest), largest);
        }
    }

    private boolean isGreater(T a, T b) {
        if (a == null && b == null) return false;
        if (a == null) return false; // Assuming null is considered less than non-null
        if (b == null) return true;  // Assuming non-null is considered greater than null
        return a.compareTo(b) > 0;
    }
    //Returns the node at a specific index in the list.
    private DLLNode<T> getNode(int index) {
        if (index <= 0) {
            return null;
        }
        DLLNode<T> current = list;
        int count = 1;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }
//Sorts the list using the Merge Sort algorithm.
    public void MergeSort() {
        this.list = mergeSort(this.list);
    }
//Recursive helper method for Merge Sort.
    private DLLNode<T> mergeSort(DLLNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        DLLNode<T> middle = getMiddle(head);
        DLLNode<T> nextOfMiddle = middle.getNext();

        middle.setNext(null);

        DLLNode<T> left = mergeSort(head);
        DLLNode<T> right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }
//Finds the middle node of the list.
    private DLLNode<T> getMiddle(DLLNode<T> head) {
        if (head == null) return head;
        DLLNode<T> slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
//Merges two sorted lists for Merge Sort.
    private DLLNode<T> sortedMerge(DLLNode<T> a, DLLNode<T> b) {
        if (a == null) return b;
        if (b == null) return a;

        DLLNode<T> result;

        T aItem = a.getItem();
        T bItem = b.getItem();

        // Handling null items
        if (aItem == null && bItem == null) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else if (aItem == null) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else if (bItem == null) {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        } else if (aItem.compareTo(bItem) <= 0) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
            mergeSortComparisons++;
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }

        return result;
    }
    //Methods to output the number of comparisons for each sort
    
    public void getSelectionSortComparisons() {
    	 System.out.println("Total operation SelectionSort:" + selectionSortComparisons);
    }

    public void getInsertionSortComparisons() {
    	 System.out.println("Total operation InsertionSort:" + insertionSortComparisons);
    }

    public void getBubbleSortComparisons() {
    	 System.out.println("Total operation BubbleSort:" + bubbleSortComparisons);  

    }

    public void getQuickSortComparisons() {
    	 System.out.println("Total operation QuickSort:" + quickSortComparisons);
    }

    public void getHeapSortComparisons() {
    	 System.out.println("Total operation HeapSort:" + heapSortComparisons);
    }

    public void getMergeSortComparisons() {
    	 System.out.println("Total operation MergeSort:" + mergeSortComparisons);
    }
    



}
