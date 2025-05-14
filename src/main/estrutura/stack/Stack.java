package main.estrutura.stack;

public class Stack<T> {
	private Node<T> top;
	public Node<T> current;
	public int lenght;
	
	public Stack() {
		this.top = null;
		this.current = null;
		this.lenght = 0;
	}
	
	public void add(T value) {
		Node<T> node = new Node<T>(value, this.lenght); 
		if(this.top == null) {
			this.top = node;
		} else {
			node.next = this.top;
			this.top = node;
		}
		this.lenght++;
	}
	
	public T getTop() {
		return this.top.value;
	}
	
	public T pop() {
		if(this.top != null) {
			this.current = this.top;
			this.top = this.top.next;
			this.current.next = null;
			
			T value = this.current.value;
			
			this.updateIndex();
			this.lenght--;
			return value;
		}
		return null;
		
	}
	
	public boolean haveNext() {
		if(this.top == null) {
			return false;
		} else if (this.current == null) {
			this.current = this.top;
			return true;
		} else {
			boolean haveNext = this.current.next != null;
			this.current = this.current.next;
			return haveNext;
		}
	}
	
	public void show() {
		for(int i = 0; i <= this.lenght - 1; i++) {
			System.out.print(this.get(i) + " -> ");
		}
		System.out.println();
	}
	
	public void showLIFO() {
		this.current = null;
		while(this.haveNext()) {
			System.out.print(this.current.value + " -> ");
		}
		System.out.println();
	}
	
	public T get(int index) {
		this.current = null;
		while(this.haveNext()) {
			if(this.current.index == index) {
				return this.current.value;
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return this.top == null;
	}
	
	private void updateIndex() {
		int newIndex = 0;
		this.current = null;
		while(this.haveNext()) {
			this.current.index = newIndex;
			newIndex++;
		}
	}

	public void clear() {
		this.top = null;
		this.current = null;
	}
}
