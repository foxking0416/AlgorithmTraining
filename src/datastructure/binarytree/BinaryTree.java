package datastructure.binarytree;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.omg.CORBA.IRObject;



public class BinaryTree {
	
	protected Node rootNode;
	protected int count;
	
	public BinaryTree(){
		count = 0;
	}
	
	
	public void insert(Node newNode){
		if(rootNode == null){
			this.rootNode = newNode;
		}
		else{
			insertNode(this.rootNode, newNode);
		}
		count++;
	}
	
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
	
	public int height(Node node){
		
		if(node == null)
			return -1;
		
		int leftHeight = height(node.getLeftLeafNode());
		int rightHeight = height(node.getRightLeafNode());
		
		if(leftHeight > rightHeight)
			return leftHeight + 1;
		else 
			return rightHeight + 1;
		
		
	}
	
	public int minDepth(Node rNode) {
        if(rNode == null)
        	return 0;
        
        if(rNode.getLeftLeafNode() == null && rNode.getRightLeafNode() == null)
        	return 1;
        else if(rNode.getLeftLeafNode() == null)
        	return minDepth(rNode.getRightLeafNode()) + 1;
        else if(rNode.getRightLeafNode() == null)
        	return minDepth(rNode.getLeftLeafNode()) + 1;
        
        int leftHeight = minDepth(rNode.getLeftLeafNode());
        int rightHeight = minDepth(rNode.getRightLeafNode());
        
        if(leftHeight < rightHeight)
        	return leftHeight + 1;
        else 
			return rightHeight + 1;
		
    }
	
	public void remove(Node removeNode){
		Node nodeToRemoveNode =  findNode(this.rootNode, removeNode);
		if(nodeToRemoveNode == null)
			return;
		
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
//				if(largestNodeFromLeft.value < tempParent.value){
//					largestNodeFromLeft.setLeftLeafNode(nodeToRemoveNode.getLeftLeafNode().getLeftLeafNode());	
//				}
//				else{
					largestNodeFromLeft.setLeftLeafNode(nodeToRemoveNode.getLeftLeafNode());	
					tempParent.setRightLeafNode(null);
//				}
				
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
		
		--count;
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
	public void preorderTraverseRecursion(Node rNode){
		if(rNode != null){
			System.out.print(rNode.value + ",");
			preorderTraverseRecursion(rNode.getLeftLeafNode());
			preorderTraverseRecursion(rNode.getRightLeafNode());
		}
	}
	
	public void preorderTraverseLoop(Node rNode){
		ArrayList<Integer> array = new ArrayList<>();
		
		Stack<Node> myStack = new Stack<>();
		myStack.push(rNode);
		
		while(myStack.isEmpty() != true){
			Node node = myStack.pop();
			
			array.add(node.value);
			if(node.getRightLeafNode() != null)
				myStack.push(node.getRightLeafNode());
			if(node.getLeftLeafNode() != null)
				myStack.push(node.getLeftLeafNode());
			
		}
		
		for (int i =0; i < array.size(); ++i){
			System.out.print(array.get(i) + ",");
		}
	}
	
	//Post-Order Traverse method
	public void postorderTraverseRecursion(Node rNode){
		if(rNode != null){

			postorderTraverseRecursion(rNode.getLeftLeafNode());
			postorderTraverseRecursion(rNode.getRightLeafNode());
			System.out.print(rNode.value + ",");
		}
	}
	
	public void postorderTraverseLoop(Node rNode){
		ArrayList<Integer> array = new ArrayList<>();
		
		Stack<Node> treeStack = new Stack<>();
		treeStack.push(rNode);
		while(treeStack.empty() != true){
			Node node = treeStack.pop();
			array.add(node.value);
			
			if(node.getLeftLeafNode() != null)
				treeStack.push(node.getLeftLeafNode());
			if(node.getRightLeafNode() != null)
				treeStack.push(node.getRightLeafNode());
			
		}
		
		ArrayList<Integer> returnList = new ArrayList<>();
	
		//Print element from end to start
		for (int i = array.size()-1 ; i >= 0; --i) {
			returnList.add(array.get(i));
			//			System.out.print(array.get(i) + ",");
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
	
	public void inorderTraverseLoop(Node rNode){
		
		HashMap<Node, Boolean> myHashtable = new HashMap<>();
		ArrayList<Integer> array = new ArrayList<>();
		
		Stack<Node> treeStack = new Stack<>();
		treeStack.push(rNode);
		while(treeStack.empty() != true){
			
			Node node = treeStack.pop();
			if(myHashtable.containsKey(node) || (node.getLeftLeafNode() == null && node.getRightLeafNode() == null)){
				array.add(node.value);	
			}else{
				myHashtable.put(node, true);
				
				if(node.getRightLeafNode() != null)
					treeStack.push(node.getRightLeafNode());
				
				treeStack.push(node);
				

				if(node.getLeftLeafNode() != null)
					treeStack.push(node.getLeftLeafNode());
			}
		}
		
	
		//Print element from end to start
		for (int i = 0; i < array.size(); ++i) {
			System.out.print(array.get(i) + ",");

		}
	}
	
	//Breadth First Traverse method
	public void breadthFirstTraverse(Node rNode){
		
		Queue<Node> queue = new LinkedList<Node>();
		
		
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
		
	//Level-Order Traverse method
	public void levelOrderTraverse(Node rNode){

		ArrayList<ArrayList<Integer>> array = new ArrayList<>();
		if(rNode == null)
		    return;
		Queue<Node> currentLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();
		ArrayList<Integer> tempArray = new ArrayList<>();
		
		while(rNode != null){

			tempArray.add(rNode.value);
			
			if(rNode.getLeftLeafNode() != null){
				nextLevel.add(rNode.getLeftLeafNode());
			}
			if(rNode.getRightLeafNode() != null){
				nextLevel.add(rNode.getRightLeafNode());
			}

			
			if(currentLevel.isEmpty() == false){
				rNode = currentLevel.poll();
			}
			else{
				ArrayList<Integer> storeArray = new ArrayList<>();
				System.out.print("[");
				for(Integer i : tempArray){
					storeArray.add(i);
					System.out.print(i + ",");
				}
				System.out.print("]");				
				array.add(storeArray);
				tempArray.clear();
				
				if(nextLevel.isEmpty() == false){

					for(Node n : nextLevel) {
						currentLevel.add(n);
				    }
					
					nextLevel.clear();
					rNode = currentLevel.poll();
				}
				else{
					break;
				}
			}

		}
	}
	
	//Zigzag-Order Traverse method
	public void zigzagLevelOrderTraverse(Node rNode){

		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		boolean leftToRight = true;
		
		while(rNode != null){
			System.out.print(rNode.value + ",");
			
			if(leftToRight){
				if(rNode.getLeftLeafNode() != null){
					nextLevel.push(rNode.getLeftLeafNode());
				}
				if(rNode.getRightLeafNode() != null){
					nextLevel.push(rNode.getRightLeafNode());
				}
			}else {
				if(rNode.getRightLeafNode() != null){
					nextLevel.push(rNode.getRightLeafNode());
				}
				if(rNode.getLeftLeafNode() != null){
					nextLevel.push(rNode.getLeftLeafNode());
				}
			}


			
			if(currentLevel.isEmpty() == false){
				rNode = currentLevel.pop();
			}
			else{
				if(nextLevel.isEmpty() == false){
					currentLevel = (Stack<Node>)nextLevel.clone();// = nextLevel;
					
					nextLevel.clear();
					leftToRight = !leftToRight;
					rNode = currentLevel.pop();
				}
				else{
					break;
				}
			}

		}
	}

	
	public Node inorderSucc(Node n){
		if(n == null)
			return null;
		
		if(n.getRightLeafNode() != null){
			return findTheMostLeftNode(n.getRightLeafNode());
		}
		else{
			Node parentNode = findParentNode(n, this.rootNode);
			
			while (parentNode != null) {
				if( n.value < parentNode.value){
					break;
				}
				n = parentNode;
				parentNode = findParentNode(n, this.rootNode);
			}
			
			
			return parentNode;
		}
		
		
		
	}
	
	public Node findTheMostLeftNode(Node n){
		
		if(n.getLeftLeafNode() == null)
			return n;
		else 
			return findTheMostLeftNode(n.getLeftLeafNode());
	}
	
	public boolean cover(Node root, Node n){
		if(root.equals(n))
			return true;	
		else{
			boolean leftCover = false;
			boolean rightCover = false;
			if(root.getLeftLeafNode() != null)
				leftCover = cover(root.getLeftLeafNode(), n);
			if(root.getRightLeafNode() != null)
				rightCover = cover(root.getRightLeafNode(), n);
			
			return (leftCover || rightCover);
		}
		
//		return false;
	}

	public boolean isSameTree(Node p, Node q) {
        
		boolean result = true;
		
		if(p == null && q == null)
			return true;
		
		result &= (p.value == q.value);
		if(result == false)
			return false;
		
		if(p.getLeftLeafNode() != null && q.getLeftLeafNode() != null)
			result &= isSameTree(p.getLeftLeafNode(), q.getLeftLeafNode());
		else if(p.getLeftLeafNode() == null && q.getLeftLeafNode() != null)
			return false;
		else if(p.getLeftLeafNode() != null && q.getLeftLeafNode() == null)
			return false;		
		
		if(result == false)
			return false;
		
		if(p.getRightLeafNode() != null && q.getRightLeafNode() != null)
			result &= isSameTree(p.getRightLeafNode(), q.getRightLeafNode());
		else if(p.getRightLeafNode() == null && q.getRightLeafNode() != null)
			return false;
		else if(p.getRightLeafNode() != null && q.getRightLeafNode() == null)
			return false;
		
		return result;
    }

    public boolean hasPathSum(Node root, int sum) {
        
    	if(root.getLeftLeafNode() == null && root.getRightLeafNode() == null){
    		if(sum == root.value)
    			return true;
    		else 
				return false;
    	}
    	
    	boolean resultLeft = false;
    	boolean resultRight = false;
    	
    	if(root.getLeftLeafNode() != null){
    		resultLeft = hasPathSum(root.getLeftLeafNode(), sum - root.value);
    	}
    	if(root.getRightLeafNode() != null){
    		resultRight = hasPathSum(root.getRightLeafNode(), sum - root.value);
    	}
    	
    	return (resultLeft | resultRight);
    }
    
    public static boolean isSymmetric(Node root) {
        
    	if(root == null)
    		return true;
    	
    	if(root.getLeftLeafNode() != null && root.getRightLeafNode() == null){
    		return false;
    	}
    	if(root.getLeftLeafNode() == null && root.getRightLeafNode() != null){
    		return false;
    	}
    	
    	return symmetric(root.getLeftLeafNode(), root.getRightLeafNode());
    }
    
    private static boolean symmetric(Node p, Node q){
    	
		boolean result = true;
    	
    	if(p == null && q == null)
    		return true;
    	
		result &= (p.value == q.value);
		if(result == false)
			return false;
		
		if(p.getLeftLeafNode() != null && q.getRightLeafNode() != null)
			result &= symmetric(p.getLeftLeafNode(), q.getRightLeafNode());
		else if(p.getLeftLeafNode() == null && q.getRightLeafNode() != null)
			return false;
		else if(p.getLeftLeafNode() != null && q.getRightLeafNode() == null)
			return false;	
    	
		if(result == false)
			return false;
		
		if(p.getRightLeafNode() != null && q.getLeftLeafNode() != null)
			result &= symmetric(p.getRightLeafNode(), q.getLeftLeafNode());
		else if(p.getRightLeafNode() == null && q.getLeftLeafNode() != null)
			return false;
		else if(p.getRightLeafNode() != null && q.getLeftLeafNode() == null)
			return false;
    	
    	return result;
    }

    public static Node flatten(Node root){
    	
//    	Node right;
//    	if(root.getRightLeafNode() != null )
//    		right = root.getRightLeafNode();
    	
    	flattenHelper(root, null);
    	
//    	if(root.getLeftLeafNode() != null){}
    	
    	
    		
    	return root;
    }
    
    private static Node flattenHelper(Node root, Node right){
    	
       	Node currentRight = null;
    	if(root.getRightLeafNode() != null){
    		currentRight = flattenHelper(root.getRightLeafNode(), right);
    	
    	}
    	
    	Node currentLeft = null;
    	if(root.getLeftLeafNode() != null){
    		if(currentRight != null)
    			currentLeft = flattenHelper(root.getLeftLeafNode(), currentRight);
    		else
    			currentLeft = flattenHelper(root.getLeftLeafNode(), right);
    		
    	}
    	
    	if(currentLeft != null){
    		root.setRightLeafNode(currentLeft);
    		root.setLeftLeafNode(null);
    	
    	}
    	
    	if(currentLeft == null && currentRight == null)
    		root.setRightLeafNode(right);
    	return root;
    	
    }
    
    
}
