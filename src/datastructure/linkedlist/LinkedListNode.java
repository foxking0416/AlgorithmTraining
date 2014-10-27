package datastructure.linkedlist;

import datastructure.binarytree.Node;

public class LinkedListNode extends Node {

	public LinkedListNode next = null;
//	private LinkedListNode headNode;

	
	public LinkedListNode(int v) {
		super(v);
		
//		if(headNode == null){
//			headNode = this;
//		}

	}
	
	public void push(int v){
		LinkedListNode newNode = new LinkedListNode(v);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = newNode;
		
		
	}
	
	public LinkedListNode deleteNode(LinkedListNode head, int d){
		LinkedListNode n = head;
		if(n.value == d)
			return head.next;
		
		while(n.next != null){
			if(n.next.value == d){
				n.next = n.next.next;
				return head;
			}
			
			n = n.next;
		}
		return head;
	}
	
//	public int pop(){
//		
//		LinkedListNode n = this;
//		LinkedListNode nNext = n.next;
//		while(nNext.next != null){
//			n = nNext;
//			nNext = nNext.next;
//		}
//		
//		int returnValue = nNext.value;
//		n.next = null;
//		
//		return returnValue;
//	}
//	
//	public int peek(){
//		
//		LinkedListNode n = this;
//		LinkedListNode nNext = n.next;
//		while(nNext.next != null){
//			n = nNext;
//			nNext = nNext.next;
//		}
//		
//		return nNext.value;
//	}

}
