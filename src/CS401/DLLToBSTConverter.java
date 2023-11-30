package CS401;

public class DLLToBSTConverter<T extends Comparable<T>> {

    private DLLNode<T> head; // The head node of the doubly linked list.

    public DLLToBSTConverter(DLLNode<T> head) { //Initializes a new instance of the DLLToBSTConverter class using the provided head of the DLL.
        this.head = head;
    }
//A private helper method that calculates the size of the DLL starting from the given node. It iterates through the DLL and returns the count of nodes.
    private int getSize(DLLNode<T> node) {
        int size = 0;
        DLLNode<T> current = node;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
//Public method that initiates the conversion of the entire DLL to a BST. It calls the recursive method convertToBSTRecursive with the size of the DLL.
    public BSTNode<T> convertToBST() {
        int size = getSize(head);
        return convertToBSTRecursive(size);
    }
//A private recursive method that constructs the BST. 
//  It builds the left subtree, creates the root, and builds the right subtree, thus maintaining the order of elements as in the DLL.
    private BSTNode<T> convertToBSTRecursive(int size) {
        if (size <= 0) {
            return null;
        }

        BSTNode<T> left = convertToBSTRecursive(size / 2);
        BSTNode<T> root = new BSTNode<>(head.getItem());
        head = head.getNext();
        BSTNode<T> right = convertToBSTRecursive(size - size / 2 - 1);

        root.setLeft(left);
        root.setRight(right);

        return root;
    }
}
