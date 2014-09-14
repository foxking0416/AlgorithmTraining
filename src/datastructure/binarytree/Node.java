package datastructure.binarytree;

public class Node {
	public int value;
	
//	Node parentNode;
	private Node leftLeafNode;
	private Node rightLeafNode;
	
	public Node(int v){
		this.value = v;
	}
	
//	public void setParentNode(Node node){
//		this.parentNode = node;
//	}
	
	public void setLeftLeafNode(Node node){
//		node.parentNode = this;
		this.leftLeafNode = node;
	}
	
	public void setRightLeafNode(Node node){
//		node.parentNode = this;
		this.rightLeafNode = node;
	}
	
//	public Node getParentNode(){
//		return this.parentNode;
//	}
	
	public Node getLeftLeafNode(){
		return this.leftLeafNode;
	}
	
	public Node getRightLeafNode(){
		return this.rightLeafNode;
	}
	
}
