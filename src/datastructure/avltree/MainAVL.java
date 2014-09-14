package datastructure.avltree;

import datastructure.binarytree.Node;

public class MainAVL {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAVLTree();
	}
	
	private static void testAVLTree(){
	//  1       1           1               2            2           2               2
	//	         \           \             / \          / \         / \             / \
	//     ==>    2    ==>    2     ==>   1   3   ==>  1   3  ==>  1   3     ==>   1   4
	//                         \                            \           \             / \
	//                          3                            4           4           3   5
	//                                                                    \
	//                                                                     5
		AVLTree tree = new AVLTree();
		Node rootNode = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		tree.insert(rootNode);
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node3);
		tree.insert(node4);

		
		System.out.print("Preorder Traverse: ");
		tree.preorderTraverse(tree.getRootNode());
		System.out.print("\n");
		
		System.out.print("Postorder Traverse: ");
		tree.postorderTraverse(tree.getRootNode());
		System.out.print("\n");
		
		tree.remove(node3);
		System.out.print("Preorder Traverse after removed: ");
		tree.preorderTraverse(tree.getRootNode());
		System.out.print("\n");
		
		System.out.print("Postorder Traverse after removed: ");
		tree.postorderTraverse(tree.getRootNode());
		System.out.print("\n");
	}
}
