package main.queue;

public class Queue<T> {
	public Node<T> first;
	public int lenght;
	public Node<T> end;
	public Node<T> current;
	
	public Queue() {
		this.end = null;
		this.lenght = 0;
		this.first = null;
		this.current = null;
	}
	
	public void add(T value) {
		Node<T> new_node = new Node<>();
		new_node.setValue(value);
		if(this.first == null) {
			this.first = new_node;
			this.end = new_node;
		} else {
			this.end.setPrev(new_node);
			this.end = new_node;
		}
		this.lenght++;
	}
	
	public int size() {
		return this.lenght;
	}
	
	public T remove() {
		if(this.first != null) {
			Node<T> current = this.first;
			this.first = this.first.getPrev();
			this.lenght--;
			return current.getValue();
			
		}
		return null;
	}
	
	public T getFirst() {
		if(this.first != null) {
			return this.first.getValue();
		}
		return null;
	}
	
	public boolean havePrev() {
		if(this.first == null) {
			return false;
		} else if (this.current == null) {
			this.current = this.first;
			return true;
		} else {
			boolean havePrev = this.current.getPrev() != null;
			this.current = this.current.getPrev();
			return havePrev;
		}
	}
}
