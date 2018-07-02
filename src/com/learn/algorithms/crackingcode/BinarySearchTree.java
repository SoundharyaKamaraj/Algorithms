/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Soundharya
 *
 */
public class BinarySearchTree {

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

	        TreeNode head1 = createTree(mapping1, 0);
	        // This tree is:
	        // head1 = 0
	        //        / \
	        //       1   2
	        //      /\   /\
	        //     3  4 5  6


	        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
	        int[] childrenD = {1, 4};
	        int[] childrenE = {0, 2};
	        int[] childrenF = {5, 6};
	        mapping2.put(3, childrenD);
	        mapping2.put(1, childrenE);
	        mapping2.put(4, childrenF);

	        TreeNode head2 = createTree(mapping2, 3);
	        // This tree is:
	        //  head2 = 	3
	        //        /   \
	        //       1     4
	        //      /\    / \
	        //     0  2  5   6


	        HashMap<Integer, int[]> mapping3 = new HashMap<Integer, int[]>();
	        int[] childrenG = {1, 5};
	        int[] childrenH = {0, 2};
	        int[] childrenI = {4, 6};
	        mapping3.put(3, childrenG);
	        mapping3.put(1, childrenH);
	        mapping3.put(5, childrenI);

	        TreeNode head3 = createTree(mapping3, 3);
	        // This tree is:
	        //  head3 = 3
	        //        /   \
	        //       1     5
	        //      /\    / \
	        //     0  2  4   6



	        HashMap<Integer, int[]> mapping4 = new HashMap<Integer, int[]>();
	        int[] childrenJ = {1, 5};
	        int[] childrenK = {0, 4};
	        mapping4.put(3, childrenJ);
	        mapping4.put(1, childrenK);

	        TreeNode head4 = createTree(mapping4, 3);
	        // This tree is:
	        //  head4 = 3
	        //        /   \
	        //       1     5
	        //      /\
	        //     0  4
	        HashMap<Integer, int[]> mapping5 = new HashMap<Integer, int[]>();
	        int[] childrenZ = {3, 5};
	        int[] childrenY = {2, 4};
	        mapping5.put(1, childrenZ);
	        mapping5.put(3, childrenY);
	       /* int[] childrenJ = {1, 5};
	        int[] childrenK = {0, 4};
	        mapping4.put(3, childrenJ);
	        mapping4.put(1, childrenK);*/

	        TreeNode head5 = createTree(mapping5, 1);

	    System.out.println(isBST(head1));
	   //should return false
	     System.out.println(isBST(head2));
	       //should return false
	      System.out.println(isBST(head3)); 
	      //should return true
	    System.out.println(isBST(head4));
	      //should return false
	    System.out.println(isBST(head5));
	    }



	    // Implement your function below.
	    public static boolean isBST(TreeNode node) {
	    	return isBstHelper(node, null, null);
	    }

	    public static boolean isBstHelper(TreeNode<Integer> node, Integer lowerLim, Integer upperLim) {
	    	System.out.print("lowerLim:"+lowerLim+" upperLim:"+upperLim+" ");
	        if (lowerLim != null && node.getData() < lowerLim) return false;
	        if (upperLim != null && upperLim < node.getData()) return false;
	        boolean isLeftBST = true;
	        boolean isRightBST = true;
	        if (node.leftNode != null) {
	            isLeftBST = isBstHelper(node.leftNode, lowerLim, node.getData());
	        }
	        if (isLeftBST && node.rightNode != null) {
	            isRightBST = isBstHelper(node.rightNode, node.getData(), upperLim);
	        }
	        return isLeftBST && isRightBST;
	    }
	    

	    public static String printTree(TreeNode head){
	    	TreeNode traverseLeftNode=head.leftNode;
	    	TreeNode traverseRightNode=head.rightNode;
	    	StringBuilder sb= new StringBuilder();
	    	sb.append(head.getData());
	    	while(traverseLeftNode.leftNode!=null && traverseRightNode.rightNode!=null){
	    		sb.append(traverseLeftNode.getData());
	    		sb.append(" -->");
	    		sb.append(traverseLeftNode.leftNode.data);
	    		sb.append("||");
	    		sb.append(traverseLeftNode.rightNode.data);
	    		traverseLeftNode=traverseLeftNode.leftNode;
	    		sb.append(traverseRightNode.getData());
	    		sb.append("--> ");
	    		sb.append(traverseRightNode.leftNode.data);
	    		sb.append("||");
	    		sb.append(traverseRightNode.rightNode.data);
	    		traverseRightNode=traverseRightNode.leftNode;
	    	}
	    	return sb.toString();
	    }
	    
	    static int[] oddNumbers(int l, int r) {
	        
	        List<Integer> oddArray= new ArrayList<>();
	        for(int i=l;i<=r;i++){
	            if(i%2!=0){
	               oddArray.add(i);
	            }
	        }
	        int[] returnObject= oddArray.stream().mapToInt(Integer::intValue).toArray();
	        return returnObject;
	    }
		public static TreeNode<Integer> createTree(HashMap<Integer, int[]> mapping, int headValue){
			
			TreeNode<Integer> headNode= new TreeNode(headValue,null,null);
			HashMap<Integer,TreeNode<Integer>> constructedTree= new HashMap<>();
			constructedTree.put(headValue, headNode);
			for(Integer keySet: mapping.keySet()){
				int[] values= mapping.get(keySet);
				constructedTree.put(values[0], new TreeNode(values[0],null,null));
				constructedTree.put(values[1], new TreeNode(values[1],null,null));
			}
			for(Integer key: mapping.keySet()){
				int[] values= mapping.get(key);
				constructedTree.get(key).setLeftNode(constructedTree.get(values[0]));
				constructedTree.get(key).setRightNode(constructedTree.get(values[1]));
			}
			
			return headNode;
		}
		
}
