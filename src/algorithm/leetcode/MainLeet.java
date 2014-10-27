package algorithm.leetcode;

import javax.swing.InputMap;

public class MainLeet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPalindromeNumber();
		
		testPalindromeString();
		testReverseWordString();
		testFindSingle();
		testFindSinglePart2();
		testGeneratePascalTriangle();
		testMaximumProductSubArray();
		testAddBinary();
		testCountAndSay();
		testLengthOfLastWord();
		testIsPalindrome();
		testPlusOne();
		testMaxProfitI();
		testMaxProfitIII();
	}
	
	private static void testPalindromeNumber(){
		System.out.print("****Test Palindrome Number****" + "\n");
		int num = 10203;
		
		if(LeetTest.isPalindromeNumber(num))
		System.out.print("Number " + num + " is Palindrome Number");
		else {
			System.out.print("Number " + num + " isn't Palindrome Number" + "\n");
		}
		System.out.print("\n");
	}
	
	private static void testPalindromeString(){
		
		System.out.print("****Test Palindrome String****" + "\n");
		String str = "aabcksvregervdgdfg";
	
		System.out.print("String " + str + " maximum Palindrome length is " + LeetTest.isPalindromeString(str) + "\n");
		System.out.print("\n");
	}
	
	private static void testReverseWordString(){
		System.out.print("****Test Reverse Word****" + "\n");
		LeetTest.reverseWordsSequenceTest();
		System.out.print("\n");
		
	}
	
	private static void testFindSingle(){
		System.out.print("****Test Find Single****" + "\n");
		int answer = LeetTest.findSingleNumberTest();
		System.out.print("The Single Number is " + answer + "\n");
		System.out.print("\n");
	}
	
	private static void testFindSinglePart2(){
		System.out.print("****Test Find Single Part2****" + "\n");
		int answer = LeetTest.findSingleNumberPart2Test();
		System.out.print("The Single Number is " + answer + "\n");
		System.out.print("\n");
	}
	
	private static void testGeneratePascalTriangle(){
		System.out.print("****Test Generate Pascal Triangle****" + "\n");
		LeetTest.generatePascalTriangleTest();
		System.out.print("\n");
	}
	
	private static void testMaximumProductSubArray(){
		System.out.print("****Test Masimun Product SubArray****" + "\n");
		
		System.out.print("The maximum product is " + LeetTest.maxProductSubArrayTest() + "\n");
		System.out.print("\n");
	}
	
	private static void testAddBinary(){
		System.out.print("****Test Add Binary****" + "\n");
		
		System.out.print("The binary result is " + LeetTest.addBinaryTest("1","1") + "\n");
		System.out.print("\n");
	}
	
	private static void testCountAndSay(){
		System.out.print("****Test Count And Say****" + "\n");
		
		System.out.print("The result is " + LeetTest.countAndSay(1) + "\n");
		System.out.print("\n");
	}
	
	private static void testLengthOfLastWord(){
		System.out.print("****Test Length Of Last Word****" + "\n");
		
		System.out.print("The result is " + LeetTest.lengthOfLastWord(" ") + "\n");
		System.out.print("\n");
	}
	
	private static void testIsPalindrome(){
		System.out.print("****Test Is Palindrome String****" + "\n");
		
		System.out.print("The result is " + LeetTest.isPalindrome2(".,") + "\n");
		System.out.print("\n");
	}
	
	private static void testPlusOne(){
		System.out.print("****Test Plus One****" + "\n");
		
		int[] input = new int[]{0};
		
		int[] result = LeetTest.plusOne(input);
		String str = "";
		for(int i = 0; i < result.length; ++i){
			str = str.concat(String.valueOf(result[0]));
		}
		
		System.out.print("The result is " + str + "\n");
		System.out.print("\n");
	}
	
	private static void testMaxProfitI(){
		System.out.print("****Test Maximum Profit I****" + "\n");
		int[] input = new int[]{3,3,5,0,0,3,1,4};
		
		int profit = LeetTest.maxProfitI(input);
		System.out.print("The maximum profit is " + profit + "\n");
		System.out.print("\n");
	}
	
	private static void testMaxProfitIII(){
		System.out.print("****Test Maximum Profit III****" + "\n");
		int[] input = new int[]{2,1,4,5,2,9,7};
//		int[] input = new int[]{3,3,5,0,0,3,1,4};		
		int profit = LeetTest.maxProfitIIII(input);
		System.out.print("The maximum profit is " + profit + "\n");
		System.out.print("\n");
	}
}
