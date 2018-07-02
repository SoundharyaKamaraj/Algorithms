/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.HashMap;

/**
 * @author Soundharya
 *
 */
public class TreeNode<T> {

	T data;
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	
	public TreeNode(T value,TreeNode<T> nodeleft,TreeNode<T> noderight){
		this.data=value;
		this.leftNode=nodeleft;
		this.rightNode=noderight;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the leftNode
	 */
	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * @return the rightNode
	 */
	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	
}
