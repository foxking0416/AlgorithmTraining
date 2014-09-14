package datastructure.avltree;
import datastructure.binarytree.*;

public class AVLTree {

	//     Q                           P
	//    / \                         / \
	//   P   C   ==>   P   Q    ==>  A   Q
	//  / \           / \ / \           / \
	// A   B         A   B   C         B   C
	public void rightRotation(Node node){
		if(node.getLeftLeafNode() == null)
			return;
		
		node.setLeftLeafNode(node.getLeftLeafNode().getRightLeafNode());
		node.getLeftLeafNode().setRightLeafNode(node);
	}
	
	//     P                           Q
	//    / \                         / \
	//   A   Q   ==>   P   Q    ==>  P   C
	//      / \       / \ / \       / \
	//     B   C     A   B   C     A   B 
	public void leftRotation(Node node){
		if(node.getRightLeafNode() == null)
			return;
		
		node.setRightLeafNode(node.getRightLeafNode().getLeftLeafNode());
		node.getRightLeafNode().setLeftLeafNode(node);
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
	
	
	
	public void checkBalance(Node node){
			
		if(height(node.getLeftLeafNode()) - height(node.getRightLeafNode()) > 1){
			if(height(node.getLeftLeafNode().getLeftLeafNode()) > height(node.getLeftLeafNode().getRightLeafNode())){
				rightRotation(node);
			}
			else{
				leftAndRightRotation(node);
			}
		}
		else if(height(node.getLeftLeafNode()) - height(node.getRightLeafNode()) < -1){
			if(height(node.getRightLeafNode().getRightLeafNode()) > height(node.getRightLeafNode().getLeftLeafNode())){
				leftRotation(node);
			}
			else{
				rightAndLeftRotation(node);
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
	public void leftAndRightRotation(Node node){
		leftRotation(node.getLeftLeafNode());
		rightRotation(node);
	}
	
	public void rightAndLeftRotation(Node node){
		rightRotation(node.getRightLeafNode());
		leftRotation(node);
	}
}
