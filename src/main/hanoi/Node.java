package main.hanoi;

class Node<T> {
	public T value;
	public Node<T> prev;
	
	public Node(T value) {
		this.value = value;
		this.prev = null;
	}
}
