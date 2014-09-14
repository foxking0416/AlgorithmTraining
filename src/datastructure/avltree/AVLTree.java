package datastructure.avltree;
import java.util.ArrayList;
import java.util.Stack;

import datastructure.binarytree.*;

public class AVLTree extends BinaryTree {
	

	
	@Override
 	protected void insertNode(Node currentNode, Node newNode){
		if(newNode.value < currentNode.value){
			if(currentNode.getLeftLeafNode() == null){
				currentNode.setLeftLeafNode(newNode);
			}
			else {
				insertNode(currentNode.getLeftLeafNode(), newNode);
			}
		}
		else{
			if(currentNode.getRightLeafNode() == null){
				currentNode.setRightLeafNode(newNode);
			}
			else {
				insertNode(currentNode.getRightLeafNode(), newNode);
			}
		}
		
		checkBalance(currentNode);
	}
	
	
	@Override
	public void remove(Node removeNode){
		Node nodeToRemoveNode =  this.rootNode;
		Node parentNode = null;
		Stack<Node> pathStack = new Stack<Node>();
		pathStack.add(this.rootNode);
		
		while(nodeToRemoveNode != null && nodeToRemoveNode != removeNode){
			parentNode = nodeToRemoveNode;
			if(removeNode.value < nodeToRemoveNode.value){
				nodeToRemoveNode = parentNode.getLeftLeafNode();
			}
			else{
				nodeToRemoveNode = parentNode.getRightLeafNode();
			}
			pathStack.push(nodeToRemoveNode);
		}
		
		
		if(nodeToRemoveNode == null)
			return;
		
		//parentNode = findParentNode(removeNode, this.rootNode);
		
		
		if(count == 1)
			this.rootNode = null;//remove the only one element of this tree
		else{
			if(nodeToRemoveNode.getLeftLeafNode() == null && nodeToRemoveNode.getRightLeafNode() == null){//remove the leaf node
				if(nodeToRemoveNode.value < parentNode.value){
					parentNode.setLeftLeafNode(null);
				}
				else {
					parentNode.setRightLeafNode(null);
				}
			}
			else if (nodeToRemoveNode.getLeftLeafNode() != null && nodeToRemoveNode.getRightLeafNode() == null){//remove the node with only left leaf node
				if(nodeToRemoveNode.value < parentNode.value){
					parentNode.setLeftLeafNode(nodeToRemoveNode.getLeftLeafNode());
				}
				else{
					parentNode.setRightLeafNode(nodeToRemoveNode.getLeftLeafNode());
				}
			}
			else if (nodeToRemoveNode.getLeftLeafNode() == null && nodeToRemoveNode.getRightLeafNode() != null){//remove the node with only right leaf node
				if(nodeToRemoveNode.value < parentNode.value){
					parentNode.setLeftLeafNode(nodeToRemoveNode.getRightLeafNode());
				}
				else{
					parentNode.setRightLeafNode(nodeToRemoveNode.getRightLeafNode());
				}	
			}
			else{//remove the node with two leaf nodes
				Node largestNodeFromLeft = nodeToRemoveNode.getLeftLeafNode();
				while(largestNodeFromLeft.getRightLeafNode() != null){
					largestNodeFromLeft = largestNodeFromLeft.getRightLeafNode();
				}
				
				
				Node tempParent = findParentNode(largestNodeFromLeft, this.rootNode);

				
				largestNodeFromLeft.setRightLeafNode(nodeToRemoveNode.getRightLeafNode());
				if(largestNodeFromLeft.value < tempParent.value){
					largestNodeFromLeft.setLeftLeafNode(nodeToRemoveNode.getLeftLeafNode().getLeftLeafNode());	
				}
				else{
					largestNodeFromLeft.setLeftLeafNode(nodeToRemoveNode.getLeftLeafNode());	
					tempParent.setRightLeafNode(null);
				}
				
				if(parentNode != null){
					if(nodeToRemoveNode.value < parentNode.value){
						parentNode.setLeftLeafNode(largestNodeFromLeft);
					}
					else{
						parentNode.setRightLeafNode(largestNodeFromLeft);
					}
				}
				else{
					this.rootNode = largestNodeFromLeft;
				}
			}
		}
		
		while(pathStack.size() > 0){
			checkBalance(pathStack.pop());
		}
		--count;
	}
	
	
	public void checkBalance(Node node){
			
		if(height(node.getLeftLeafNode()) - height(node.getRightLeafNode()) > 1){
			Node parentNode = findParentNode(node, this.rootNode);
			if(height(node.getLeftLeafNode().getLeftLeafNode()) > height(node.getLeftLeafNode().getRightLeafNode())){
				rightRotation(node, parentNode);
			}
			else{
				leftAndRightRotation(node, parentNode);
			}
		}
		else if(height(node.getLeftLeafNode()) - height(node.getRightLeafNode()) < -1){
			Node parentNode = findParentNode(node, this.rootNode);
			if(height(node.getRightLeafNode().getRightLeafNode()) > height(node.getRightLeafNode().getLeftLeafNode())){
				leftRotation(node, parentNode);
			}
			else{
				rightAndLeftRotation(node, parentNode);
			}
		}
	}
	
	//     Q                           P
	//    / \                         / \
	//   P   C   ==>   P   Q    ==>  A   Q
	//  / \           / \ / \           / \
	// A   B         A   B   C         B   C
	public void rightRotation(Node nodeQ, Node parentNode){
		if(nodeQ.getLeftLeafNode() == null)
			return;
		
		Node nodeP = nodeQ.getLeftLeafNode();
		
		nodeQ.setLeftLeafNode(nodeP.getRightLeafNode());
		nodeP.setRightLeafNode(nodeQ);
		
		if(parentNode == null){
			this.rootNode = nodeP;
		}
		else{
			if(nodeQ.value < parentNode.value){
				parentNode.setLeftLeafNode(nodeP);
			}
			else{
				parentNode.setRightLeafNode(nodeP);
			}
		}
	}
	
	//     P                           Q
	//    / \                         / \
	//   A   Q   ==>   P   Q    ==>  P   C
	//      / \       / \ / \       / \
	//     B   C     A   B   C     A   B 
	public void leftRotation(Node nodeP, Node parentNode){
		if(nodeP.getRightLeafNode() == null)
			return;
		Node nodeQ = nodeP.getRightLeafNode();
		
		nodeP.setRightLeafNode(nodeQ.getLeftLeafNode());
		nodeQ.setLeftLeafNode(nodeP);
		
		if(parentNode == null){
			this.rootNode = nodeQ;
		}
		else{
			if(nodeP.value < parentNode.value){
				parentNode.setLeftLeafNode(nodeQ);
			}
			else{
				parentNode.setRightLeafNode(nodeQ);
			}
		}
	}
	
	//       Q             Q                 Q                               B
	//      / \           / \               / \                            /   \
	//     P   C   ==>   /   C    ==>      B   C   ==>     B   Q    ==>   P     Q      
	//    / \           /                 / \             / \ / \        / \   / \
	//   A   B         P   B             P   Y           P   Y   C      A   X Y   C
	//      / \       / \ / \           / \             / \
	//     X   Y     A   X   Y         A   X           A   X
	public void leftAndRightRotation(Node node, Node parentNode){
		leftRotation(node.getLeftLeafNode(), parentNode);
		rightRotation(node, parentNode);
	}
	
	//       P             P                 P                               B
	//      / \           / \               / \                            /   \
	//     A   Q   ==>   A   \  ==>        A   B   ==>     P   B    ==>   P     Q      
	//        / \             \               / \         / \ / \        / \   / \
	//       B   C         B   Q             X   Q       A   X   Q      A   X Y   C
	//      / \           / \ / \               / \             / \
	//     X   Y         X   Y   C             Y   C           Y   C
	public void rightAndLeftRotation(Node node, Node parentNode){
		rightRotation(node.getRightLeafNode(), parentNode);
		leftRotation(node, parentNode);
	}
}
