import java.util.ArrayList;
import java.util.Arrays;


public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testSorting();
		testBinaryTree();
	}
	
	
	private static void testShortestPath(){
		
	}
	
	private static void testSorting(){
	    int[] array = Sort.generateRandomArray();
		for (int i : array) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n");
		
		
		int arrayToSort1[] = array.clone();
		int arrayToSort2[] = array.clone();
		int arrayToSort3[] = array.clone();
		int arrayToSort4[] = array.clone();
		
		Sort.selectionSort(arrayToSort1);
		System.out.print("Selection Sort Result: ");
		for (int i : arrayToSort1) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n");
		
		Sort.insertionSort(arrayToSort2);
		System.out.print("Selection Sort Result: ");
		for (int i : arrayToSort2) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n");
		
		Sort.mergeSort(arrayToSort3, 0, arrayToSort3.length-1);
		System.out.print("Selection Sort Result: ");
		for (int i : arrayToSort3) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n");
		
		
		Sort.quickSort(arrayToSort4, 0, arrayToSort4.length-1);
		System.out.print("Selection Sort Result: ");
		for (int i : arrayToSort4) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n");
		
	}

	
	private static void testBinaryTree(){
		
		BinaryTree binaryTree = new BinaryTree();
		ArrayList<Node> array = new ArrayList<Node>();
		
//		Node rootNode = new Node((int)(Math.random() * 100));
//		binaryTree.insert(rootNode);
//		array.add(rootNode);
//		System.out.print(rootNode.value + ",");
//		
//		for(int i = 1; i < 10 ; i++){
//			int value = (int)(Math.random() * 100);
//			Node newNode = new Node(value);
//			
//			
//			binaryTree.insert(newNode);
//			array.add(newNode);
//			System.out.print(value + ",");
//		}
		
		
		Node rootNode = new Node(50);
		Node node1 = new Node(25);
		Node node2 = new Node(75);
		Node node3 = new Node(15);
		Node node4 = new Node(40);
		Node node5 = new Node(69);
		Node node6 = new Node(83);
		Node node7 = new Node(53);
		Node node8 = new Node(99);
		Node node9 = new Node(77);
		Node node10 = new Node(48);
		Node node11 = new Node(49);
		Node node12 = new Node(39);
		Node node13 = new Node(45);
		Node node14 = new Node(1);
		Node node15 = new Node(17);
		Node node16 = new Node(50);
		Node node17 = new Node(76);
		binaryTree.insert(rootNode);
		binaryTree.insert(node1);
		binaryTree.insert(node2);
		binaryTree.insert(node3);
		binaryTree.insert(node4);
		binaryTree.insert(node5);
		binaryTree.insert(node6);
		binaryTree.insert(node7);
		binaryTree.insert(node8);
		binaryTree.insert(node9);
		binaryTree.insert(node10);
		binaryTree.insert(node11);
		binaryTree.insert(node12);
		binaryTree.insert(node13);
		binaryTree.insert(node14);
		binaryTree.insert(node15);
		binaryTree.insert(node16);
		binaryTree.insert(node17);
		
		
		System.out.print("\n");
		System.out.print("Preorder Traverse: ");
		binaryTree.preorderTraverse(rootNode);
		System.out.print("\n");
		System.out.print("Postorder Traverse: ");
		binaryTree.postorderTraverse(rootNode);
		System.out.print("\n");
		System.out.print("Inorder Traverse: ");//Sequence will be from small to big
		binaryTree.inorderTraverse(rootNode);
		System.out.print("\n");
		System.out.print("Breadth First Traverse: ");//Sequence will be from small to big
		binaryTree.breadthFirstTraverse(rootNode);
		
		int maxValue = binaryTree.findMax(rootNode);
		int minValue = binaryTree.findMin(rootNode);
		Node pNode = binaryTree.findParentNode(node9, rootNode);
		
		System.out.print("\n");
		System.out.print("Min value = " + minValue);
		System.out.print("\n");
		System.out.print("Max value = " + maxValue);
		System.out.print("\n");
		System.out.print("Node " + node9.value + "'s parent node value = " + pNode.value);
		System.out.print("\n");
		
		binaryTree.remove(rootNode);
		rootNode = binaryTree.getRootNode();
		System.out.print(rootNode.value);
		System.out.print("\n");
		binaryTree.preorderTraverse(rootNode);
	
	}
	
}
