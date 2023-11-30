package CS401;

public class DLLNode<T extends Comparable<T>> implements Comparable<DLLNode<T>>


{


 private  T item; // The data item stored in the node. It must implement the Comparable interface.
private DLLNode Node; // A reference to the next node in the list.
private DLLNode Back; //A reference to the previous node in the list.
 public DLLNode(){ // Initializes a new node with null references for both the next and previous nodes.
     this.Node = null;
     this.Back = null;
 }
public DLLNode(T item){ // Initializes a new node with the specified item and null references for both the next and previous nodes.
    this.item = item;
    this.Node = null;
    this.Back = null;
}


//Returns the item stored in the node.
public T getItem(){
    return this.item;
}
//Sets the node's item to the specified value.
public void setItem(T item){
    this.item = item;
}
//Returns a reference to the previous node in the list.
public DLLNode getBack(){
    return this.Back;
}
//Sets the node's previous node reference to the given node.
public void setBack(DLLNode Back){
    this.Back = Back;
}
//Returns a reference to the next node in the list.
public DLLNode getNext(){
    return  this.Node;
}
//Sets the node's next node reference to the given node.
public void setNext (DLLNode Node){
    this.Node = Node;
}
//Adds a new node with the specified item to the end of the list. If the list is empty, the new node becomes the head of the list.
 public void Add(T item) {
     DLLNode<T> newNode = new DLLNode<>(item);
     if (Node == null) {
         Node = newNode;
     } else {
         DLLNode<T> last = Node;
         while (last.getNext() != null) {
             last = last.getNext();
         }
         last.setNext(newNode);
         newNode.setBack(last);
     }
 }
//Removes the first node that contains the specified item from the list. 
 //Adjusts the previous and next references of neighboring nodes accordingly. 
 //If the removed node is the head, the head is updated.
 public void Remove(T item) {
    DLLNode<T> current = Node;

    while (current != null) {
        if (current.getItem().equals(item)) {
            DLLNode<T> backNode = current.getBack();
            DLLNode<T> nextNode = current.getNext();

            if (backNode != null) {
                backNode.setNext(nextNode);
            } else {
                // If the removed node was the head, update the head
                Node = nextNode;
            }

            if (nextNode != null) {
                nextNode.setBack(backNode);
            }

            // Optional: Set next and back pointers of the removed node to null
            current.setNext(null);
            current.setBack(null);

            // Optional: If you want to remove only the first occurrence, break out of the loop
            break;
        }

        current = current.getNext();
    }
}
//Prints the items of all nodes in the list starting from the head. If the list is empty, prints a message indicating so.
 public void printList() {
     if (Node == null) {
         System.out.println("The list is empty.");
     } else {
         DLLNode<T> current = Node;
         while (current != null) {
             System.out.println(current.getItem());
             current = current.getNext();
         }
     }
 }

//Implements the Comparable interface. Compares the current node's item with another node's item. 
//Returns 0 if both items are equal, -1 if the current item is less, and 1 if the current item is greater. 
 //Handles null values appropriately.
 @Override
 public int compareTo(DLLNode<T> o) {
     if (this.item == null && o.item == null) {
         return 0;
     } else if (this.item == null) {
         return -1;
     } else if (o.item == null) {
         return 1;
     } else {
         return this.item.compareTo(o.item);
     }
 }


 
 

 

}
