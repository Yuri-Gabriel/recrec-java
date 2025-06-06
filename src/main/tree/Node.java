package main.tree;

public class Node<T> {
    public T value;
    public Node<T> prev;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.prev = null;
    }
}
