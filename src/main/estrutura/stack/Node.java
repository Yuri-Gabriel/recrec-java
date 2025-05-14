package main.estrutura.stack;

public class Node<T> {
	public T value;
	public Node<T> next;
	public int index;
	
	public Node(T value, int index) {
		this.value = value;
		this.next = null;
		this.index = index;
	}
}
