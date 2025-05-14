package main.queue;

public class Node<T> {
	public T value;
	public Node<T> prev;
	
	public Node() {
		this.value = null;
		this.prev = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
}
