package main.tree;

public class Arvore<T> {
    public Node<T> root;
    private Node<T> current_node;

    public Arvore() {
        this.root = null;
        this.current_node = null;
    }

    public boolean exist(T value) {

        if(current_node != null) {
            if(this.current_node.value != null) {
                if (this.current_node.value.equals(value)) {
                    this.current_node = this.root;
                    return true;
                }
                if(this.current_node.left == null && this.current_node.right == null) {
                    this.current_node = this.root;
                    return false;
                };
    
                int valueSumBytes = getSumBytes(getObjectAddress(value).getBytes());
                int currentNumSumBytes = getSumBytes(getObjectAddress(this.current_node).getBytes());
    
                if(currentNumSumBytes < valueSumBytes) {
                    this.current_node = this.current_node.left;
                } else {
                    this.current_node = this.current_node.right; 
                }
    
                return exist(value);
            }
        }
        this.current_node = this.root;
        return false;
    }

    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.root == null) {
            this.root = newNode;
            return;
        }

        if(this.current_node == null) this.current_node = this.root;

        int valueSumBytes = getSumBytes(getObjectAddress(value).getBytes());
        int currentNumSumBytes = getSumBytes(getObjectAddress(this.current_node).getBytes());


        if(currentNumSumBytes < valueSumBytes) {
            if(this.current_node.left == null) {
                newNode.prev = this.current_node;
                this.current_node.left = newNode;
                return;
            }
            this.current_node = this.current_node.left;
        } else {
            if(this.current_node.right == null) {
                newNode.prev = this.current_node;
                this.current_node.right = newNode;
                return;
            } 
            this.current_node = this.current_node.right; 
        }
        add(value);
        this.current_node = this.root;
    }

    public void remove(T value) {
        if(this.root == null) return;
        if(this.root.value.equals(value)) {
            if(this.root.left == null && this.root.right != null) {
                this.root = this.root.right;
                this.current_node = this.root;
                return;
            }
            if(this.root.right == null && this.root.left != null) {
                this.root = this.root.left;
                this.current_node = this.root;
                return;
            }
        }
        
        Node<T> pseudoRoot = getNode(value).right;
        if(pseudoRoot != null) {
            if(pseudoRoot.left != null) {
                removeFromPseudoRoot(pseudoRoot, pseudoRoot.left);
            } else {
                pseudoRoot.prev.value = pseudoRoot.value;
                pseudoRoot.prev.right = pseudoRoot.left;
            } 
        } else {
            getNode(value).prev.right = null;
        }
           
        this.current_node = this.root;
    }

    private void removeFromPseudoRoot(Node<T> pseudoRoot, Node<T> current) {
        if(current.left != null) {
            current = current.left;
            removeFromPseudoRoot(pseudoRoot, current);
        } else {
            pseudoRoot.prev.value = current.value;
            current.prev.right = current.left;
        }
    }

    private Node<T> getNode(T value) {
        if(this.current_node.value.equals(value)) return this.current_node;

        if(this.current_node.left == null && this.current_node.right == null) return null;

        int valueSumBytes = getSumBytes(getObjectAddress(value).getBytes());
        int currentNumSumBytes = getSumBytes(getObjectAddress(this.current_node).getBytes());

        if(currentNumSumBytes < valueSumBytes) {
            this.current_node = this.current_node.left;
            return getNode(value);
        } else {
            this.current_node = this.current_node.right; 
            return getNode(value);
        }
    }

    public void update(T oldValue, T newValue) {
        
    }

    private static <T extends Object> String getObjectAddress(T obj) {
		String objectAddress = obj.toString().substring(obj.toString().lastIndexOf("@") + 1);
		return objectAddress;
	}

	private static int getSumBytes(byte[] bytes) {
		int sum = 0;
		for(byte b : bytes) {
			sum += b;
		}
		return sum;
	}
    
}
