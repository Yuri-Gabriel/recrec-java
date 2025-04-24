package main.list.duple;

public class ListDupl<T> {
	private NodeDupl<T> head;
	private NodeDupl<T> end;
	private NodeDupl<T> current;
	
	public void addRight(T value) {
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

    public void addLeft(T value) {
		NodeDupl<T> new_node = new NodeDupl<T>();
		new_node.setValue(value);
		if(this.head == null && this.end == null) {
			this.head = new_node;
			this.end = new_node;
		} else if(this.end.getNext() == null) {
			new_node.setNext(this.head);
            this.head.setPrev(new_node);
            this.head = new_node;
		}
	}

	

	public void addInTheBorder(T value1, T value2) {
		NodeDupl<T> new_node_left = new NodeDupl<T>();
		new_node_left.setValue(value1);
		NodeDupl<T> new_node_right = new NodeDupl<T>();
		new_node_right.setValue(value2);

		if(this.head == null && this.end == null) {
			this.head = new_node_left;
			this.end = new_node_right;

			this.head.setNext(this.end);
			this.end.setPrev(this.head);
		} else {
			new_node_left.setNext(this.head);
			this.head.setPrev(new_node_left);
			this.head = new_node_left;
			
			new_node_right.setPrev(this.end);
			this.end.setNext(new_node_right);
			this.end = new_node_right;
		}
	}

    public void showRightToLeft() {
		if(this.end == null) return;

		this.current = null;
        while(this.havePrev()) {
            System.out.print(" <- " + this.current.getValue().toString());
        }
		System.out.println();
    }

    public void showLeftToRight() {
		if(this.head == null) return;

		this.current = null;
        while(this.haveNext()) {
            System.out.print(this.current.getValue().toString() + " -> ");
        }
		System.out.println();
    }

    public ListDupl<String> getListWithCommonWords(ListDupl<String> list) {
		if(this.head == null) return new ListDupl<String>();

		if(this.head.getValue() instanceof String) {
			ListDupl<String> list03 = new ListDupl<String>();
			while(this.haveNext()) {
				while(list.haveNext()) {
					String currentValue = this.getCurrent().getValue().toString();
					String value = list.getCurrent().getValue();
					if(currentValue.equals(value) && !list03.haveTextInList(value)) {
						list03.addRight(new String(value));
					}
				}
			}
			return list03;
		}
        return new ListDupl<String>();
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

    public boolean havePrev() {
		if(this.end == null) {
			return false;
		} else if (this.current == null) {
			this.current = this.end;
			return true;
		} else {
			boolean havePrev = this.current.getPrev() != null;
			this.current = this.current.getPrev();
			return havePrev;
		}
	}
	
	public void removeLeft() {
		if(this.end == null) return;

		this.current = this.end.getPrev();
		this.end.setPrev(null);
		this.current.setNext(null);
		this.end = this.current;
	}

	public void removeRight() {
		if(this.head == null) return;

		this.current = this.head.getNext();
		this.head.setNext(null);
		this.current.setPrev(null);
		this.head = this.current;
	}

    public boolean haveTextInList(String value) {
        while (this.haveNext()) {
            if(this.current.getValue().toString().equals(value)) {
                return true;
            }
        }
        return false;
    }

	private boolean haveValue() {
		return this.head != null;

	}

	public NodeDupl<T> getCurrent() {
		return this.current;
	}
	
}