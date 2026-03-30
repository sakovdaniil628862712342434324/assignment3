package sait.sll.utility;

import java.io.Serializable;

// Singly linked list
public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;

	private Node head;
	private Node tail;
	private int size;

	public SLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void append(Object data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		this.size++;
	}

	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		this.size++;
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
		}

		if (index == 0) {
			prepend(data);
		} else if (index == this.size) {
			append(data);
		} else {
			Node previous = getNode(index - 1);
			Node newNode = new Node(data);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
			this.size++;
		}
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
		}
		Node current = getNode(index);
		current.setData(data);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
		}

		if (index == 0) {
			this.head = this.head.getNext();
			if (this.size == 1) {
				this.tail = null; // List is now empty
			}
		} else {
			Node previous = getNode(index - 1);
			Node target = previous.getNext();
			previous.setNext(target.getNext());

			// If deleted the last element, update the tail
			if (target == this.tail) {
				this.tail = previous;
			}
		}
		this.size--;
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
		}
		return getNode(index).getData();
	}

	@Override
	public int indexOf(Object data) {
		Node current = this.head;
		int index = 0;

		while (current != null) {
			if (data == null ? current.getData() == null : data.equals(current.getData())) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
	}

	@Override
	public boolean contains(Object data) {
		return indexOf(data) != -1;
	}

	// Helper method to traverse to a specific node
	private Node getNode(int index) {
		Node current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
}