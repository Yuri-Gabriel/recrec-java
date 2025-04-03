package main.lis.simple;

public class ListDupl<T> {
	private NodeList<T> head;
	private NodeList<T> end;
	private NodeList<T> current;
	
	public void add(T value) {
		NodeList<T> new_node = new NodeList<T>();
		new_node.setValue(value);
		if(this.head == null && this.end == null) {
			this.head = new_node;
			this.end = new_node;
		} else if(this.end.getNext() == null) {
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
	
	public void remove() {
		if(this.head != null) {
			if(this.head.getNext() == null) {
				this.head = null;
				this.end = null;
			} else if(this.head.getNext() == this.end){
				
				this.end = this.head;
				this.head.setNext(null);
			} else {
				while(this.haveNext()) {
					if(this.current.getNext().getNext() == null) {
						this.current.setNext(null);
                        this.end = this.current;
					}
				}
			}
		}
	}

	public NodeList<T> getCurrent() {
		return this.current;
	}
	
}