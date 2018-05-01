/**
 * 
 */
package com.learn.algorithms.reverselist;

/**
 * @author Soundharya
 *
 */
public class ReverseSublist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> list = createList(new int[] { 89, 68, 87, 76 });
		System.out.println("Before Iteration");
		printList(list);
		System.out.println("\n After Iteration by Iterative Method");
		Node<Integer> reversedList = reverseListByIterative(list);
		printList(reversedList);
		Node<Integer> list1 = createList(new int[] { 89, 68, 87, 76 });
		System.out.println("\n After Iteration by Recursive Method");
		Node<Integer> reversedList1 = reverseListByRecursive(list1);
		printList(reversedList1);
		
	}

	private static Node<Integer> reverseListByRecursive(Node<Integer> nodeList) {
		Node<Integer> currentNode =nodeList;
		if(currentNode == null){
			return null;
		}
		else if(currentNode.next==null){
			return currentNode;
		}
		else{
			Node<Integer> nextNode = currentNode.next;
			currentNode.next = null;
			Node<Integer> restNode = reverseListByRecursive(nextNode);
			nextNode.next = currentNode;
			return restNode;
		}
	}

	private static Node<Integer> reverseListByIterative(Node<Integer> list) {
		Node<Integer> currentNode = list;
		Node<Integer> previousNode = null;
		Node<Integer> nextNode = null;

		if (currentNode == null) {
			return null;
		}
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			System.err.println(previousNode ==null? "null": previousNode.data);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode != null ? previousNode : currentNode;
	}

	private static void printList(Node<Integer> list) {
		Node<Integer> node = list;
		while (node != null) {
			System.out.print( node.data +"-> " ) ;
			node = node.getNext();
		}
	}

	private static Node<Integer> createList(int[] data) {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		for (int element : data) {
			Node<Integer> node = new Node<>(element);
			if (tail != null) {
				tail.setNext(node);
			}
			tail = node;
			if (head == null) {
				head = node;
			}
		}
		return head;
	}

}
