package CS401;

public class BSTNode<T extends Comparable<T>> {

    private T item; //The data item stored in the node. The type T must implement the Comparable interface.
    private BSTNode<T> left; //Reference to the left child node.
    private BSTNode<T> right; //Reference to the right child node.

    public BSTNode(T item) { //Constructs a new BSTNode with the specified item. The left and right child nodes are initially set to null.
        this.item = item;
        this.left = null;
        this.right = null;
    }
//Returns the data item stored in the node.
    public T getItem() {
        return item;
    }
//Sets the node's data item to the specified value.
    public void setItem(T item) {
        this.item = item;
    }
//Returns a reference to the left child node.
    public BSTNode<T> getLeft() {
        return left;
    }
//Sets the node's left child reference to the given node.
    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }
//Returns a reference to the right child node.
    public BSTNode<T> getRight() {
        return right;
    }
//Sets the node's right child reference to the given node.
    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

   //Checks if the subtree rooted at this node contains the specified item. 
   // It returns true if the item is found, and false otherwise. 
   // The method uses the compareTo method of the Comparable interface to compare items. 
   // If the item being compared is null or if the node's item is null, the method returns false.
    public boolean contains(T item) {
    	 if (item == null || this.item == null) {
    	        return false;
    	    }

        if (item.compareTo(this.item) == 0) {
            return true;
        } else if (item.compareTo(this.item) < 0) {
            return (left != null) && left.contains(item);
        } else {
            return (right != null) && right.contains(item);
        }
    }
}

