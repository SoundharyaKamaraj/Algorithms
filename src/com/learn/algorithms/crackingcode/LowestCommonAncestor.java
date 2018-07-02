/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Soundharya
 *
 */
public class LowestCommonAncestor {
	    public static void main(String[] args) {
	        // NOTE: The following input values will be used for testing your solution.
	        // The mapping we're going to use for constructing a tree.
	        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
	        // child is 2.
	        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
	        int[] childrenA = {1, 2};
	        int[] childrenB = {3, 4};
	        int[] childrenC = {5, 6};
	        mapping1.put(0, childrenA);
	        mapping1.put(1, childrenB);
	        mapping1.put(2, childrenC);

	        TreeNode<Integer> head1 = createTree(mapping1, 0);

	        // This tree is:
	        // head1 = 0
	        //        / \
	        //       1   2
	        //      /\   /\
	        //     3  4 5  6


	        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
	        int[] childrenD = {1, 4};
	        int[] childrenE = {3, 8};
	        int[] childrenF = {9, 2};
	        int[] childrenG = {6, 7};
	        mapping2.put(5, childrenD);
	        mapping2.put(1, childrenE);
	        mapping2.put(4, childrenF);
	        mapping2.put(3, childrenG);

	        TreeNode<Integer> head2 = createTree(mapping2, 5);
	        // This tree is:
	        //  head2 = 5
	        //        /   \
	        //       1     4
	        //      /\    / \
	        //     3  8  9  2
	        //    /\
	        //   6  7


	        System.out.println(lca(head1, 1, 5).data); 
	        //should return 0
	      System.out.println(lca(head1, 3, 1).data); 
	       //should return 1
	      System.out.println(lca(head1, 1, 4).data); 
	        //should return 1
	      System.out.println(lca(head1, 0, 5).data); 
	        //should return 0
	        System.out.println(lca(head2, 4, 7).data); 
	        //should return 5
	        System.out.println(lca(head2, 3, 3).data); 
	        //should return 3
	        System.out.println(lca(head2, 8, 7).data); 
	        //should return 1
	        System.out.println(lca(head2, 3, 0)); 
	        //should return null (0 does not exist in the tree)
	    }


	    // Implement your function below.
	    public static TreeNode<Integer> lca(TreeNode<Integer> root, int j, int k) {
	    	
	    	Stack<TreeNode<Integer>> pathJ=pathToX(root, j);
	    	Stack<TreeNode<Integer>> pathK=pathToX(root, k);	
	    	TreeNode<Integer> lca=null;
	    	if(pathJ==null || pathK==null){
	    		return null;
	    	}
	    	
	    	else{
	    		while(!pathJ.isEmpty() && !pathK.isEmpty()){
	    		TreeNode<Integer> popJ = pathJ.pop();
	    		TreeNode<Integer> popK = pathK.pop();
	    		if(popJ==popK){
	    			lca=popJ;
	    		}
	    		else{
	    			break;
	    		}
	    	}
	    		return lca;
	    	}
	    }

	    public static Stack<TreeNode<Integer>> pathToX(TreeNode<Integer> root, int x) {
	    	
	    	if(root==null){
	    		return null;
	    	}
	    	
	    	if(root.getData()==x){
	    		Stack<TreeNode<Integer>> path= new Stack<>();
	    		path.push(root);
	    		return path;
	    	}
	    	
	    	Stack<TreeNode<Integer>> leftPath =pathToX(root.leftNode,x);
	    	if(leftPath!=null){
	    		leftPath.push(root);
	    		return leftPath;
	    	}
	    	
	    	Stack<TreeNode<Integer>> rightPath = pathToX(root.rightNode,x);
	    	if(rightPath!=null){
	    		rightPath.push(root);
	    		return rightPath;
	    	}
	    	return null;
	    }


	    // A function for creating a tree.
	    // Input:
	    // - mapping: a node-to-node mapping that shows how the tree should be constructed
	    // - headValue: the value that will be used for the head ndoe
	    // Output:
	    // - The head node of the resulting tree
	    public static TreeNode<Integer> createTree(HashMap<Integer, int[]> mapping, int headValue) {
	        TreeNode<Integer> head = new TreeNode<>(headValue, null, null);
	        HashMap<Integer, TreeNode<Integer>> nodes = new HashMap<Integer, TreeNode<Integer>>();
	        nodes.put(headValue, head);
	        for(Integer key : mapping.keySet()) {
	            int[] value = mapping.get(key);
	            TreeNode<Integer> leftChild = new TreeNode<>(value[0], null, null);
	            TreeNode<Integer> rightChild = new TreeNode<>(value[1], null, null);
	            nodes.put(value[0], leftChild);
	            nodes.put(value[1], rightChild);
	        }
	        for(Integer key : mapping.keySet()) {
	            int[] value = mapping.get(key);
	            nodes.get(key).setLeftNode(nodes.get(value[0]));
	            nodes.get(key).setRightNode(nodes.get(value[1]));
	        }
	        return head;
	    }

}
