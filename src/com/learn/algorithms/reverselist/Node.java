/**
 * 
 */
package com.learn.algorithms.reverselist;

/**
 * @author Soundharya
 *
 */
public class Node<T> {

	public T data;

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> next;

	public Node(T data) {
		this.data = data;
		this.setNext(null);
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
}
