package CS401;

class HashNode<T extends Comparable<T>> {
    T key;
    DLLNode<T> value;
    HashNode<T> next; // For collision handling using chaining

    HashNode(T key, DLLNode<T> value) {
        this.key = key;
        this.value = value;
    }
}
