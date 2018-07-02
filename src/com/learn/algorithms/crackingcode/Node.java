/**
 * 
 */
package com.learn.algorithms.crackingcode;

/**
 * @author Soundharya
 *
 */
public class Node<T> {

	T value;
	Node<T> next;
	
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node(T data){
		this.value=data;
		this.setNext(null);
	}
	
}
