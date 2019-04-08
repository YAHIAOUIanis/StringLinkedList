import java.util.ListIterator;
import java.util.NoSuchElementException;

public class StringLinkedList {
	
	private Node first;
	private Node last;
	private int size = 0;
	
    /**
     * Constructs an empty list.
     */
    public StringLinkedList() {    	
    }
    
    

    /**
	 * @return the first
	 */
	public String getFirst() {
		return first.value;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last.value;
	}

	/**
	 * @return the size
	 */
	public int size() {
		return size;
	}

	public boolean add(String e) {
		if(size == 0) {
			addFirst(e);
			first.next = last;			
		}else {			
			add(size(),e);
		}
        return true;
    }
	
	public void add(int index, String e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index+" est en dehors de la taille de la liste");
        if (index == size) {
            addLast(e);
        }
        else {
        	Node x = node(index);
        	Node newNode = new Node(e, x.prev, x);
        	x.prev.next = newNode;
        	x.prev = newNode;
        }
	}
	
	public void addFirst(String e) {
		Node newNode = new Node(e, null, first);
		first = newNode;
		size++;
	}

	public void addLast(String e) {
		Node newNode = new Node(e, last, null);
		last = newNode;
		if(size == 1) {
			last.prev = first;
			first.next = last;
		}
		size++;
	}
	
	public void addBefore(String e, int indexElement, int index, Node f) {
		if(index==indexElement) {
			Node newNode = new Node(e, f.prev, f);
			f.prev.next = newNode;
			f.next = newNode;
			size++;
		}else {
			addBefore(e, indexElement, index++, f.next);
		}
	}
	
	public void clear() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
	}

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    
    public int indexOf(Object o) {
    	if(!(o instanceof String)) {
    		new ClassCastException("string");
    	}
        int index = 0;
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.value))
                    return index;
                index++;
            }
        }
        return -1;
    }
    
    public String get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index+" est en dehors de la taille de la liste");        
        return node(index).value;
    }
    
    Node node(int index) {    	
        if (index < (size()/2)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    
    public String peek() {       
        return (first == null) ? null : first.value;
    }
    
    public String remove() {
        final Node f = first;
        if (f == null)
            throw new NoSuchElementException();
        final String element = f.value;
        final Node next = f.next;
        f.value = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;        
        return element;
    }
    
    public String remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index+" est en dehors de la taille de la liste");        
                
        return unlink(node(index));
    }
    
    public boolean remove(Object o) {
    	if(!(o instanceof String)) {
    		new ClassCastException("string");
    	}
    	
        if (o == null) {
            for (Node x = first; x != null; x = x.next) {
                if (x.value == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    
    public String set(int index, String element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(index+" est en dehors de la taille de la liste");        
        Node x = node(index);
        String oldVal = x.value;
        x.value = element;
        return oldVal;
    }
    
    public String unlink(Node x) {

        final String element = x.value;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.value = null;
        size--;       
        return element;

    }
    
    public String toString() {
    	String res = "";
        for (Node x = first; x != null; x = x.next) {        	
        	res += x.value+" 	";
        }        
        return res;
    }


    





	
	
	
	
	
	
	
	
	
		
	

	private class Node{
		private String value;
		private Node next;
		private Node prev;
		
		public Node(String value, Node prev, Node next){
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
		
}
