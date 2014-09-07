import java.util.Arrays;


public class Algorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    int[] array = Sort.generateRandomArray();
		for (int i : array) {
			System.out.print(i);
			System.out.print(", ");
		}
		
		System.out.print("\n");
		

		int arrayFront[] = Arrays.copyOfRange(array, 0, 4);
		int arrayBack[] = Arrays.copyOfRange(array, 5, 9);
		
//		Sort.selectionSort(array);
//		Sort.insertionSort(array);
		Sort.mergeSort(array, 0, array.length-1);
		for (int i : array) {
			System.out.print(i);
			System.out.print(", ");
		}
	}
	
	

}
