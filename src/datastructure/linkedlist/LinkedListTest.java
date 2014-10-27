package datastructure.linkedlist;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.event.ListDataEvent;

public class LinkedListTest {

	 
	
	public void addList(){
		
		LinkedListNode list1 = new LinkedListNode(3);
		list1.push(1);
		list1.push(5);
		
		LinkedListNode list2 = new LinkedListNode(8);
		list2.push(0);
		list2.push(8);
		
		int value = 0;

		
		
		int pop1 = getValue(list1);
		//int pop2 = list1.pop();
		System.out.print(pop1 + "\n");
		//System.out.print(pop2);
		
	}
	
	private int getValue(LinkedListNode list){
		
//		if(list.next == null)
//			return list.pop();
//		
//		int preValue = getValue(list);
//		int currentValue = list.pop();
//		
//		return preValue + currentValue;
		return 0;
	}
	
	//if the linkedlist could make a circle 
	//     0--> 1 --> 2 --> 3 --> 4 --> 5 --> 6
	//                ^                       |            
	//                |_______________________|           
	//This function is to find the start node of the circle which is node 2
	public void findBeginningTest(){
		LinkedListNode node0 = new LinkedListNode(0);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(5);
		LinkedListNode node6 = new LinkedListNode(6);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node2;
		
		LinkedListNode startNode = findBeginning(node0);
		System.out.print("Start node value = " + startNode.value);
	}
	
	private LinkedListNode findBeginning(LinkedListNode head){
		
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		
		while(n2.next != null){
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1 == n2)
				break;
		}
		
		n1 = head;
		
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
			
		}
		return n2;
	}
	
	public static void swapPairsTest(){
		LinkedListNode node0 = new LinkedListNode(0);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(5);
		LinkedListNode node6 = new LinkedListNode(6);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		swapPairs(node0);
	}
	
	private static void swapPairs(LinkedListNode head){
		if(head == null)
			return;
		
		printLinkedList(head);
		LinkedListNode startNode = new LinkedListNode(-1);
		startNode.next = head;
		LinkedListNode currentNode = startNode;
//		head = nextNode;
		
		while(currentNode.next != null && currentNode.next.next != null){

			currentNode.next =	swapNode(currentNode.next, currentNode.next.next);
			currentNode = currentNode.next.next; 

		}
		printLinkedList(startNode);
	}
	
	private static LinkedListNode swapNode(LinkedListNode n1, LinkedListNode n2){
		if(n1 == null || n2 == null)
			return null;
		else {
			n1.next = n2.next;
			n2.next = n1;
			return n2;
		}
	}
	
	//Use to print the linklist node
	private static void printLinkedList(LinkedListNode head){
		
		while(head != null){
			System.out.print(head.value + ", ");
			head = head.next;
		}
		System.out.print("\n");
	}

	public static void deleteDuplicatesTest() {
		LinkedListNode node0 = new LinkedListNode(1);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(1);
		LinkedListNode node5 = new LinkedListNode(5);
		LinkedListNode node6 = new LinkedListNode(6);
		
		node0.next = node1;
		node1.next = node2;
//		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		LinkedListNode result =	deleteDuplicates(node0);
		while(result != null){
			System.out.print(result.value + ", ");
			result = result.next;
		}
		
		int a = 0;
	}
	
	private static LinkedListNode deleteDuplicates(LinkedListNode head) {
        if(head == null)
            return null;
        HashMap<Integer, Boolean> myHashtable = new HashMap<>();
        
        LinkedListNode node = head;
        myHashtable.put(node.value, true);
        
        while(node != null && node.next != null){
            if(myHashtable.containsKey(node.next.value) != true){
				myHashtable.put(node.next.value, true);
				node = node.next;
            }
			else {
				
				node.next = node.next.next;
			}
			

        }
        
        return head;
    }

	public static void testMergeTwoLists(){
		LinkedListNode node0 = new LinkedListNode(1);
		LinkedListNode node1 = new LinkedListNode(3);
		LinkedListNode node2 = new LinkedListNode(5);
		LinkedListNode node3 = new LinkedListNode(7);
		LinkedListNode node4 = new LinkedListNode(2);
		LinkedListNode node5 = new LinkedListNode(4);
		LinkedListNode node6 = new LinkedListNode(6);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printLinkedList(node0);
		printLinkedList(node4);		
		
		LinkedListNode afterMerge =	mergeTwoLists(node0, node4);
		printLinkedList(afterMerge);		
	}
	
	public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
	    if(l1 == null)
	        return l2;
	    if(l2 == null)
	        return l1;
//	    if(l1 == null && l2 == null)
//	        return null;
	        
	    boolean small2Big = true;
	    if(l1.next != null){
	        if(l1.value > l1.next.value)
	            small2Big = false;
	    }
	     
	    if(l2.next != null){
	        if(l2.value > l2.next.value)
	            small2Big = false;
	    }   
	        
	    LinkedListNode newHead = new LinkedListNode(0);
	    LinkedListNode newHeadCopy = newHead;
	    
	        while(l1 != null && l2 != null){
	        	if(small2Big){        	
		            if(l1.value < l2.value){
		            	newHead.next = l1;
		            	l1 = l1.next;
		            }
		            else{
		            	newHead.next = l2;
		            	l2 = l2.next;
		            }
	        	}else{
		            if(l1.value > l2.value){
		            	newHead.next = l1;
		            	l1 = l1.next;
		            }
		            else{
		            	newHead.next = l2;
		            	l2 = l2.next;
		            }
	        	}
	            newHead = newHead.next;
	          
	        }
	        
	        if(l1 == null){
	        	newHead.next = l2;
	        }else if(l2 == null)
	        	newHead.next = l1;
	    
	    
	    return newHeadCopy.next;
	}

	//Not Finished Yet
	public static LinkedListNode sortListTest() {
        
		LinkedListNode node0 = new LinkedListNode(3);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(4);
		LinkedListNode node3 = new LinkedListNode(5);
		LinkedListNode node4 = new LinkedListNode(2);
		LinkedListNode node5 = new LinkedListNode(9);
		LinkedListNode node6 = new LinkedListNode(7);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		List<LinkedListNode> myArray = new ArrayList<>();
		while(node0 != null){
			myArray.add(node0);
			node0 = node0.next;
		}
		
		List<LinkedListNode> newArray = sortListHelper(myArray, 0, myArray.size()-1);
		
		return null;
    }
	
	private static List<LinkedListNode> sortListHelper(List array, int p, int r){
		
		if(p>=r)
			return array;	
		
		int q = (p+r) / 2;
		
		sortListHelper(array, p, q);
		sortListHelper(array, q+1, r);
		return merge(array, p, q, r);
		
	}

	private static List<LinkedListNode> merge(List array, int p, int q, int r){
		
		List<LinkedListNode> copyArrayFront = new ArrayList<>();
		List<LinkedListNode> copyArrayBack = new ArrayList<>();		
		
		for(int i = 0 ; i < q - p + 1; i++){ // copy from p to q, include p and q
			copyArrayFront.add((LinkedListNode) array.get(i + p));
		}
		for(int i = 0; i < r - q; i++){ // copy form q+1 to r (include q+1 and r)
			copyArrayBack.add((LinkedListNode) array.get(i + q + 1));
		}
		
		copyArrayFront.add(new LinkedListNode(Integer.MAX_VALUE));
		copyArrayBack.add(new LinkedListNode(Integer.MAX_VALUE));
		
		
		for(int k = p, i = 0, j = 0 ; k <= r ;k++){
			if(copyArrayFront.get(i).value <= copyArrayBack.get(j).value){
				array.set(k, copyArrayFront.get(i));
				i++;
			}
			else{
				array.set(k, copyArrayFront.get(j));
				j++;
			}
		}
		
		return array;
	}
	
	public static void reorderList() {
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode node1 = new LinkedListNode(2);
		LinkedListNode node2 = new LinkedListNode(3);
		LinkedListNode node3 = new LinkedListNode(4);
		LinkedListNode node4 = new LinkedListNode(5);
		LinkedListNode node5 = new LinkedListNode(6);
		LinkedListNode node6 = new LinkedListNode(7);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		LinkedListNode pre = new LinkedListNode(0);
		LinkedListNode nodeNext = head;
		LinkedListNode nodeNextNext = head;
		
		//Fine the middle of the link list
		while(nodeNextNext.next != null && nodeNextNext.next.next != null){
			nodeNextNext = nodeNextNext.next.next;
			nodeNext = nodeNext.next;
		}
		LinkedListNode linkList2Head = nodeNext.next;
		nodeNext.next = null;
		
		printLinkedList(head);
		LinkedListNode list2Reverse = reverseList(linkList2Head);
		printLinkedList(head);
		printLinkedList(list2Reverse);
		pre.next = head;
		while(list2Reverse != null){
			

			LinkedListNode temp = head.next;
			head.next = list2Reverse;
			head = temp;
			
			LinkedListNode temp2 = list2Reverse.next;
			list2Reverse.next = temp;
			list2Reverse = temp2;
		}
		printLinkedList(pre.next);
    }
	
	private static LinkedListNode reverseList(LinkedListNode head){
		
		if(head == null || head.next == null)
			return head;
		
		LinkedListNode prev  = new LinkedListNode(0);
		prev.next = head;
	    head = prev ;
		
		LinkedListNode currentNode = prev.next;
		while(currentNode.next != null){
			LinkedListNode temp = currentNode.next;
			
			currentNode.next = temp.next;
	        temp.next = prev.next;
	        prev.next = temp;

		}
		
		return prev.next;
	}
	
	//Not Finished Yet
	public static void insertionSortListTest(){
		
		//LinkedListNode head = new LinkedListNode(1);
		LinkedListNode head = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(3);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(7);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(6);
		LinkedListNode node6 = new LinkedListNode(5);
		
		head.next= node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printLinkedList(head);
		
		if(head == null || head.next == null)
			return;




	}
}
