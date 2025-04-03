package main.list.simple;

public class NodeList<T> {
    private T value;
    private NodeList<T> next;

    public NodeList() {
        this.next = null;
        this.value = null;
    }

    public T getValue() {
        return this.value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public NodeList<T> getNext() {
        return this.next;
    }

    public void setNext(NodeList<T> next) {
        this.next = next;
    }
}
