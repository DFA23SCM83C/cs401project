package CS401;


public class Search<T extends Comparable<T>> {

    DLLNode list; //The head of the doubly linked list.
    private HashNode<T>[] hashTable; //An array for storing linked list nodes in a hash table structure.
    private int capacity; // The current capacity of the hash table.
    private int size;//The current number of elements in the hash table.
    private static final int INITIAL_CAPACITY = 16;//The initial capacity of the hash table (default value is 16).
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;//The load factor threshold for resizing the hash table (default value is 0.75).

    public Search(DLLNode<T> list) {// Initializes a new instance of the Search class with the provided DLL. 
    	//It also initializes the hash table with the default capacity and populates it with the nodes from the provided DLL.
            this.list = list;
            this.list = list;
        this.capacity = INITIAL_CAPACITY;
        this.hashTable = new HashNode[capacity];
        this.size = 0;
        initializeHashTable();
        }
//Performs a linear search on the DLL for the specified item.
  //  Returns true if the item is found, false otherwise.
    public boolean linearSearch(T item) {
        DLLNode<T> current = this.list;
        while (current != null) {
            if (item == null) {
                if (current.getItem() == null) {
                    return true;
                }
            } else if (item.equals(current.getItem())) {
                return true;
            }
            current = current.getNext();
        }
        return false; // Return false if the item is not found
    }


//Performs a binary search on the sorted DLL for the specified item.
//    Returns true if the item is found, false otherwise.
    public boolean binarySearch(T item) {
        if (item == null) {
            return false; // Assuming null values are not valid for search
        }

        DLLNode<T> start = list;
        DLLNode<T> last = getLastNode(list);

        while (start != null && last != null && start != last.getNext()) {
            DLLNode<T> mid = getMiddleNode(start, last);

            // Assuming mid.getItem() is never null since null items are not valid
            int comparison = item.compareTo(mid.getItem());
            
            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                start = mid.getNext();
            } else {
                last = mid;
            }
        }

        // Additional check for the last element in case the loop missed it
        if (start != null && start.getItem().equals(item)) {
            return true;
        }

        return false; // Return false if the item is not found
    }

//A private helper method to get the last node of the DLL.
    private DLLNode<T> getLastNode(DLLNode<T> node) {
        while (node != null && node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }
//A private helper method to find the middle node between two given nodes in the DLL.
    private DLLNode<T> getMiddleNode(DLLNode<T> start, DLLNode<T> last) {
        DLLNode<T> slow = start;
        DLLNode<T> fast = start;
        while (fast != last && fast.getNext() != last) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }


//A private method that initializes the hash table with nodes from the DLL.
    private void initializeHashTable() {
        DLLNode<T> current = this.list;
        while (current != null) {
            addNodeToHashTable(current);
            current = current.getNext();
        }
    }
    //Adds a node to the hash table and resizes the table if the load factor exceeds the threshold.
    private void addNodeToHashTable(DLLNode<T> node) {
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resizeHashTable();
        }
        int index = getHashIndex(node.getItem());
        HashNode<T> head = hashTable[index];

        HashNode<T> newNode = new HashNode<>(node.getItem(), node);
        newNode.next = head;
        hashTable[index] = newNode;
        size++;
    }
    //Resizes the hash table when the load factor exceeds the threshold.
    private void resizeHashTable() {
        capacity *= 2;
        HashNode<T>[] newTable = new HashNode[capacity];
        for (HashNode<T> head : hashTable) {
            while (head != null) {
                HashNode<T> next = head.next;
                int newIndex = getHashIndex(head.key);
                head.next = newTable[newIndex];
                newTable[newIndex] = head;
                head = next;
            }
        }
        hashTable = newTable;
    }
//Calculates the hash index for a given key.
    private int getHashIndex(T key) {
        if (key == null) {
            return 0;
        }
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }
//Searches for the item in the hash table.
//    Returns true if the item is found in the hash table, false otherwise.
    public boolean hashSearch(T item) {
        int index = getHashIndex(item);
        HashNode<T> head = hashTable[index];
        while (head != null) {
            if ((item == null && head.key == null) || (item != null && item.equals(head.key))) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
   }
