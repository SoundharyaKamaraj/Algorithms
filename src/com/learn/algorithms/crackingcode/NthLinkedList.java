package com.learn.algorithms.crackingcode;

public class NthLinkedList {
	
	public static void main(String[] args) {
	        // NOTE: The following input values will be used for testing your solution.
	        Node<Integer> current = new Node<>(1);
	        Node<Integer> current1=null;
	        current.setNext(null);
	        for (int i = 2; i < 8; i++) {
	        	current1 = new Node<>(i);
	        	current1.setNext(current);
	        	current=current1;
	            }
	        Node<Integer> head = current1;
	        System.out.println(linkedListToString(head));
	        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)

	        Node<Integer> head2Current = new Node<>(4);
	        Node<Integer> head2current1=null;
	        for (int j = 3; j > 0; j--) {
	        	head2current1= new Node<Integer>(j);
	        	head2current1.setNext(head2Current);
	        	head2Current=head2current1;
	        }
	        Node head2 = head2Current;
	        System.out.println(linkedListToString(head2));
	        // head2 = 1 -> 2 -> 3 -> 4 -> (null)

	       System.out.println(nthFromLast(head, 1).getValue());
	        //should return 1.
	       System.out.println(nthFromLast(head, 5).getValue());
	       //should return 5.
	       System.out.println(nthFromLast(head2, 2).getValue());
	       //should return 3.
	       System.out.println(nthFromLast(head2, 4).getValue());
	       //should return 1.
	       System.out.println(nthFromLast(head2, 5)); 
	       //should return null.
	       System.out.println(nthFromLast(null, 1));
	       //should return null.
	    }


	    // Implement your function below.
	    public static Node nthFromLast(Node head, int n) {
			Node<Integer> currentNode = head;
			Node<Integer> nextNode = head;
			for (int i = 0; i < n; i++) {
				if (nextNode != null) {
					nextNode = nextNode.next;
				} else {
					return null;
				}
			}

			while (nextNode != null) {
				currentNode = currentNode.next;
				nextNode = nextNode.next;
			}
			return currentNode;
	    }


	    //  NOTE: Feel free to use the following function for testing.
	    //  It converts the given linked list into an easy-to-read string format.
	    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
	    public static String linkedListToString(Node head) {
	        Node current = head;
	        StringBuilder sb = new StringBuilder();
	        while (current != null) {
	            sb.append(String.valueOf(current.value));
	            sb.append(" -> ");
	            current = current.next;
	        }
	        sb.append("(null)");
	        return sb.toString();
	    }
	    
	    // Complete the miniMaxSum function below.
	    static void miniMaxSum(int[] arr) {
        long sumarray[]= new long[arr.length];
	      long sum=0;
          for(int i=0;i<arr.length;i++){
        	  sum=sum+arr[i];
	        }
          for(int i=0;i<arr.length;i++){
        	  sumarray[i]= sum-arr[i];
          }
          
          long greatest=sumarray[0];
          long smallest=sumarray[0];
          
          for(int i=1;i<sumarray.length;i++){
        	  if(sumarray[i]<smallest){
        		  smallest=sumarray[i];
        	  }
        	  if(sumarray[i]>greatest){
        		  greatest=sumarray[i];
        	  }
          }
	    }
	    
	    public int[] twoSum(int[] nums, int target) {
	        int pointerOne=0;
	        int pointerTwo=1;
	        int indices[] = new int[2];
	        while(pointerOne<nums.length){
	            if(nums[pointerOne]+nums[pointerTwo]==target){
	                indices[0]=pointerOne;
	                indices[1]=pointerTwo;
	                return indices;
	            }
	            else if(pointerTwo==nums.length-1){
	                pointerOne++;
	                pointerTwo=0;
	            }
	            else{
	            	pointerTwo++;}
	            }
	        return null;
	        }
}
