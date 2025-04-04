package main.list.duple;

public class ListDupl<T> {
	private NodeDupl<T> head;
	private NodeDupl<T> end;
	private NodeDupl<T> current;
	
	public void add(T value) {
		NodeDupl<T> new_node = new NodeDupl<T>();
		new_node.setValue(value);
		if(this.head == null && this.end == null) {
			this.head = new_node;
			this.end = new_node;
		} else if(this.end.getNext() == null) {
			new_node.setPrev(this.end);
			this.end.setNext(new_node);
			this.end = new_node;
		}
	}
	
	public boolean haveNext() {
		if(this.head == null) {
			return false;
		} else if (this.current == null) {
			this.current = this.head;
			return true;
		} else {
			boolean haveNext = this.current.getNext() != null;
			this.current = this.current.getNext();
			return haveNext;
		}
	}
	
	public void removeLeft() {
		
	}

	public void removeRight() {
		
	}

	private boolean haveValue() {
		return this.head != null;
	}

	public NodeDupl<T> getCurrent() {
		return this.current;
	}
	
}