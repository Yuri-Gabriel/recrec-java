package main.list.duple;

public class NodeDupl<T> {
    private T value;
    private NodeDupl<T> next;
    private NodeDupl<T> prev;

    public NodeDupl() {
        this.next = null;
        this.prev = null;
        this.value = null;
    }

    public T getValue() {
        return this.value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    public NodeDupl<T> getNext() {
        return this.next;
    }

    public void setNext(NodeDupl<T> next) {
        this.next = next;
    }

    public NodeDupl<T> getPrev() {
        return this.prev;
    }

    public void setPrev(NodeDupl<T> prev) {
        this.prev = prev;
    }
}
