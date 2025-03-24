package main.hanoi;

public class Tower<T> {
	private char title;
	private int length;
	private Node<T> top;
	public Tower(char title) {
		this.setTitle(title);
		this.top = null;
		this.length = 0;
	}
	public void add(T item) {
		if(this.top == null) {
			this.top = new Node<T>(item);
		} else {
			Node<T> current = new Node<T>(item);
			current.prev = this.top;
			this.top = current;
		}
		this.length++;
	}
	public T remove() {
		Node<T> removed = this.top;
		this.top = this.top.prev;
		this.length--;
		return removed.value;
	}
	public boolean isEmpty() {
		return this.top == null;
	}
	public T getTopValue() {
		return this.top.value;
	}
	public int length() {
		return this.length;
	}
	public char getTitle() {
		return title;
	}
	public void setTitle(char title) {
		this.title = title;
	}
}
