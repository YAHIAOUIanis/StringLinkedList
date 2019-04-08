import java.util.Iterator;

import java.util.NoSuchElementException;

public class StringLinkedList implements Iterable<Node> {

	private Node first;
	private Node last;
	private int size = 0;

	/**
	 * Constructs an empty list.
	 */
	public StringLinkedList() {
	}

	@Override
	public Iterator<Node> iterator() {
		return new StringLinkedListIterator(this.first);
	}

	public Iterator<Node> iteratorDescending() {
		return new StringLinkedListIteratorDescending(this.last);
	}

	/**
	 * @return the first
	 */
	public String getFirst() {
		return (first == null) ? null : first.value;
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return (last == null) ? null : last.value;
	}

	/**
	 * @return the size
	 */
	public int size() {
		return size;
	}

	/**
	 * Appends the specified element to the end of this list.
	 */
	public boolean add(String e) {
		addLast(e);
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * @param index
	 * @param e
	 */
	public void add(int index, String e) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(index + " est en dehors de la taille de la liste");
		if (index == size)
			addLast(e);
		else
			addBefore(e, node(index));
	}

	/**
	 * Inserts the specified element at the beginning of this list.
	 * @param e
	 */
	public void addFirst(String e) {
		final Node f = first;
		final Node newNode = new Node(e, null, f);
		first = newNode;
		if (f == null)
			last = newNode;
		else
			f.prev = newNode;
		size++;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * @param e
	 */
	public void addLast(String e) {
		final Node l = last;
		final Node newNode = new Node(e, l, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
	}

	/**
	 * Appends the specified element to the end of this list.
	 * @param e
	 * @param succ
	 */
	public void addBefore(String e, Node succ) {
		// assert succ != null;
		final Node pred = succ.prev;
		final Node newNode = new Node(e, pred, succ);
		succ.prev = newNode;
		if (pred == null)
			first = newNode;
		else
			pred.next = newNode;
		size++;
	}

	/**
	 * Returns a shallow copy of this LinkedList.
	 */
	public void clear() {
		for (Node x = first; x != null;) {
			Node next = x.next;
			x.value = null;
			x.next = null;
			x.prev = null;
			x = next;
		}
		first = last = null;
		size = 0;
	}

	/**
	 * Returns true if this list contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	 * @param o
	 * @return
	 */
	public int indexOf(Object o) {

		int index = 0;
		if (o == null) {
			for (Node x = first; x != null; x = x.next) {
				if (x.value == null)
					return index;
				index++;
			}
		} else {
			if (!(o instanceof String)) {
				throw new ClassCastException("le type de l'objet n'est pas un string attention!");
			}
			for (Node x = first; x != null; x = x.next) {
				if (o.equals(x.value))
					return index;
				index++;
			}
		}
		return -1;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index
	 * @return
	 */
	public String get(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(index + " est en dehors de la taille de la liste");
		return node(index).value;
	}

	/**
	 * Returns node at index
	 * @param index
	 * @return
	 */
	private Node node(int index) {
		if (index < (size() / 2)) {
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

	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 * @return
	 */
	public String peek() {
		return (first == null) ? null : first.value;
	}

	/**
	 * Retrieves and removes the head (first element) of this list.
	 * @return
	 */
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
	
	/**
	 * Removes the element at the specified position in this list.
	 * @param index
	 * @return
	 */
	public String remove(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(index + " est en dehors de la taille de la liste");

		return removeAux(node(index));
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it is present.
	 * @param o
	 * @return
	 */
	public boolean remove(Object o) {
		if (o == null) {
			for (Node x = first; x != null; x = x.next) {
				if (x.value == null) {
					removeAux(x);
					return true;
				}
			}
		} else {
			if (!(o instanceof String)) {
				throw new ClassCastException("le type n'est pas un string");
			}
			for (Node x = first; x != null; x = x.next) {
				if (o.equals(x.value)) {
					removeAux(x);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index
	 * @param element
	 * @return
	 */
	public String set(int index, String element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(index + " est en dehors de la taille de la liste");
		Node x = node(index);
		String oldVal = x.value;
		x.value = element;
		return oldVal;
	}

	/**
	 * remove auxiliare
	 * @param x
	 * @return
	 */
	public String removeAux(Node x) {

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

	/**
	 * to string
	 */
	public String toString() {
		String res = "";
		for (Node x = first; x != null; x = x.next) {
			res += x.value + " 	";
		}
		return res;
	}

	public class StringLinkedListIterator implements Iterator<Node> {

		Node current;

		StringLinkedListIterator(Node head) {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			Node temp = current;
			current = current.next;
			return temp;
		}
	}

	public class StringLinkedListIteratorDescending implements Iterator<Node> {

		Node current;

		StringLinkedListIteratorDescending(Node tail) {
			current = tail;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			Node temp = current;
			current = current.prev;
			return temp;
		}
	}

}
