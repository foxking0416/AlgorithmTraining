package datastructure.linkedlist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		linklistTest.removeDuplicatedLinkListNode();
		//linklistTest.addList();
		testFindBeginning();
		testSwapPairs();
		testDeleteDuplicates();
		testMergeTwoLists();
		testInsertionSortList();
		testSortList();
		testReorderList();
		
	}
	
	private static void testFindBeginning() {
		System.out.print("****Find Beginning Test****" + "\n");	
		LinkedListTest linklistTest = new LinkedListTest();
		linklistTest.findBeginningTest();
		System.out.print("\n");
	}
	
	private static void testSwapPairs(){
		System.out.print("****Swap Pairs Test****" + "\n");	
		System.out.print("Swap the 1st and 2nd element, swap the 3rd and 4th element, ..." + "\n");	
		LinkedListTest.swapPairsTest();
		System.out.print("\n");
	}
	
	private static void testDeleteDuplicates(){
		System.out.print("****Delete Duplicates Test****" + "\n");	
		LinkedListTest.deleteDuplicatesTest();
		System.out.print("\n");
	}
	
	private static void testMergeTwoLists(){
		System.out.print("****Merge Two Lists Test****" + "\n");	
		LinkedListTest.testMergeTwoLists();
		System.out.print("\n");
	}

	private static void testSortList(){
		System.out.print("****Merge Sort List Test****" + "\n");	
		LinkedListTest.sortListTest();
		System.out.print("\n");
	}
	
	private static void testReorderList(){
		System.out.print("****Reorder List Test****" + "\n");	
		LinkedListTest.reorderList();
		System.out.print("\n");
	}
	
	private static void testInsertionSortList(){
		System.out.print("****Insertion Sort List Test****" + "\n");	
		LinkedListTest.insertionSortListTest();
		System.out.print("\n");
	}
}
