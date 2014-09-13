import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.portable.ValueBase;


public class BinaryTree {
	
	Node rootNode;
	int count;
	
	public BinaryTree(){
		count = 0;
	}
	
	
	void insert(Node newNode){
		if(rootNode == null){
			this.rootNode = newNode;
		}
		else{
			insertNode(this.rootNode, newNode);
		}
		count++;
	}
	
	private void insertNode(Node currentNode, Node newNode){
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
	}
	
	public Node getRootNode(){
		return this.rootNode;
	}
	
	public boolean contains(Node currentNode, Node newNode){
		
		if(currentNode == null)
			return false;
		
		if(currentNode.value == newNode.value){
			return true;
		}
		else{
			if(newNode.value < currentNode.value){
				return contains(currentNode.getLeftLeafNode(), newNode);
			}
			else {
				return contains(currentNode.getRightLeafNode(), newNode);
			}
		}
	}
	
	public Node findNode(Node currentNode, Node newNode){
		if(currentNode == null)
			return null;
		
		if(currentNode.value == newNode.value){
			return currentNode;
		}
		else{
			if(newNode.value < currentNode.value){
				return findNode(currentNode.getLeftLeafNode(), newNode);
			}
			else {
				return findNode(currentNode.getRightLeafNode(), newNode);
			}
		}
	}
	

	public int findMin(Node currentNode){
		if(currentNode == null)
			return -1;
		else{
			if(currentNode.getLeftLeafNode() == null)
				return currentNode.value;
			else {
				return findMin(currentNode.getLeftLeafNode());
			}
		}
	}
	
	public int findMax(Node currentNode){
		if(currentNode == null)
			return -1;
		else {
			if(currentNode.getRightLeafNode() == null)
				return currentNode.value;
			else {
				return findMax(currentNode.getRightLeafNode());
			}
		}
	}
	
	public boolean remove(Node removeNode){
		Node nodeToRemoveNode =  findNode(this.rootNode, removeNode);
		if(nodeToRemoveNode == null)
			return false;
		
		Node parentNode = findParentNode(removeNode, this.rootNode);
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
		
		return false;

	}

	public Node findParentNode(Node node, Node rNode){
		if(rNode == null)
			return null;
		if(node.value == rNode.value)
			return null;
		
		if(node.value < rNode.value){
			if(rNode.getLeftLeafNode() == null)
				return null;//Tree doesn't contain node
			else{
				if(rNode.getLeftLeafNode().value == node.value)
					return rNode;
				else {
					return findParentNode(node, rNode.getLeftLeafNode());
				}
			}
		}
		else {
			if(rNode.getRightLeafNode() == null)
				return null;//Tree doesn't contain node
			else {
				if(rNode.getRightLeafNode().value == node.value)
					return rNode;
				else {
					return findParentNode(node, rNode.getRightLeafNode());
				}
			}
		}
	}
	
	//Pre-Order Traverse method
	public void preorderTraverse(Node rNode){
		if(rNode != null){
			System.out.print(rNode.value + ",");
			preorderTraverse(rNode.getLeftLeafNode());
			preorderTraverse(rNode.getRightLeafNode());
		}
	}
	
	//Post-Order Traverse method
	public void postorderTraverse(Node rNode){
		if(rNode != null){

			postorderTraverse(rNode.getLeftLeafNode());
			postorderTraverse(rNode.getRightLeafNode());
			System.out.print(rNode.value + ",");
		}
	}
	
	//In-Order Traverse method
	public void inorderTraverse(Node rNode){
		if(rNode != null){
			inorderTraverse(rNode.getLeftLeafNode());
			System.out.print(rNode.value + ",");
			inorderTraverse(rNode.getRightLeafNode());
		}
	}
	
	//Breadth First Traverse method
	public void breadthFirstTraverse(Node rNode){
		
		Queue<Node> queue = new LinkedList();
		
		
		while(rNode != null){
			System.out.print(rNode.value + ",");
			
			if(rNode.getLeftLeafNode() != null){
				queue.offer(rNode.getLeftLeafNode());
			}
			if(rNode.getRightLeafNode() != null){
				queue.offer(rNode.getRightLeafNode());
			}
			
			if(queue.isEmpty() == false){
				rNode = queue.poll();
			}
			else{
				rNode = null;
			}
		}
	}
	
	
}
