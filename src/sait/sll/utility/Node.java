package sait.sll.utility;

import java.io.Serializable;

// Represents one node in a singly linked list
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object data;
	private Node next;

	public Node(Object data) {
		this.data = data;
		this.next = null;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}