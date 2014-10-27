package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;




public class LeetTest {

	
	public static boolean isPalindromeNumber(int num){
		int power = 1;
		int length = 1;
		while(num / power >= 10){
			power *= 10;
			++length;
		}
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		int remain = num;
		while(power >= 1){
			int firstNum = remain / power;
			array.add(firstNum);
			remain %= power;
			power /= 10;
		}
		
		for(int i = 0; i < length / 2; ++i){
			if(array.get(i) != array.get(length-1-i))
				return false;
		}
		
		return true;
	}
	
	public static boolean isPalindromeNumber2(int num){
		int power = 1;
		while(num / power >= 10){
			power *= 10;
		}

		while(power >= 1){
			int firstNum = num / power;
			int lastNum = num % 10;
			if(firstNum != lastNum)
				return false;
			
			num = (num % power) / 10;
			power /= 100;
			
		}
		
		return true;
	}
	
	public static int isPalindromeString(String str){
		int maxLength = 1;
		String maxStr = str.substring(0,1);
		
		for(int i = 0; i < str.length()-1; ++i){
			String s1 = expand(str, i, i);
			if(s1.length() > maxLength){
				maxLength = s1.length();
				maxStr = s1;
			}
			String s2 = expand(str, i, i+1);
			if(s2.length() > maxLength){
				maxLength = s2.length();
				maxStr = s2;
			}
			
		}
		return maxLength;

	}
	
	private static String expand(String str, int s, int e){
		String subStr = str.substring(s, e + 1);
		String returnStr = subStr;
		while(s >= 0 && e < str.length() && subStr.charAt(0) == subStr.charAt(subStr.length()-1)){
			returnStr = subStr;
			subStr = str.substring(s, e + 1);
			--s;
			++e;
		}
		
		return returnStr;
	}
	
	public static void reverseWordsSequenceTest(){
		String str = "hello world!";
		System.out.print("Initial word string is \"" + str + "\"\n");
		str = reverseWordsSequence(str);
		System.out.print("Reversed word string is \"" + str + "\"\n");

	}
	

	private static String reverseWordsSequence(String s){
		String reverStr = "";
		int i = s.length()-1;
		
		
		while( i >= 0){
			if(s.charAt(i) == ' '){
				if(i == s.length()-1){
					s = s.substring(0, s.length()-1);
					i = s.length() -1;
				}
				else{
					String word = s.substring(i+1, s.length());
					if(reverStr.isEmpty())
						reverStr = reverStr.concat(word);
					else {
						reverStr = reverStr + " " +word;
					}
					s = s.substring(0, i);
					i = s.length() - 1;
				}
			}
			else {
				--i;
			}
		}
		
		if(!s.isEmpty()){
			if(reverStr.isEmpty())
				reverStr = reverStr.concat(s);
			else
				reverStr = reverStr + " " +s;
		}
		
		return reverStr;
	}
	
	public static int findSingleNumberTest(){
		
		int[] arr = {5,9,3,4,1,5,2,4,7,3,2,9,7};
		int[] arr2 = {5,9,3,4,1,5,2,4,7,3,2,9,7};
		int[] arr3 = {5,9,3,4,1,5,2,4,7,3,2,9,7};
		int number = findSingleNumber(arr);
		int number2 = findSingleNumberSolution2(arr2);
		int number3 = findSingleNumberSolution3(arr3);
		
		return number2;
	}
	
	public static int findSingleNumberPart2Test(){
		
		int[] arr = {5,2,9,7,3,4,9,1,5,3,4,2,4,5,7,3,2,9,7};
		int number = findSingleNumberPart2Solution2(arr);
		
		return number;
	}
	
	private static int findSingleNumber(int[] A) {
        
		Arrays.sort(A);
		
		for(int i = 0; i < A.length; i += 2){
			if(A[i] != A[i+1])
				return A[i];
		}
		return 0;
    }
	
	private static int findSingleNumberSolution2(int[] A) {
		int result = 0;
		
		Hashtable<Integer, Boolean> myHashtable = new Hashtable<>();
		for(int i = 0; i < A.length; ++i){
			if(myHashtable.containsKey(A[i]) != true)
				myHashtable.put(A[i], true);
			else {
				myHashtable.put(A[i], false);
			}
		}
		
		for(Integer i : myHashtable.keySet()){
			if(myHashtable.get(i) == true)
				return i;
		}
		
		return result;
	}
	
	private static int findSingleNumberSolution3(int[] A) {
		int result = 0;
	    for (int i = 0; i< A.length; i++){
	        result ^=A[i];
	    }
	    
	    return result;
	}
	
	private static int findSingleNumberPart2(int[] A){
		Hashtable<Integer, Integer> myHashtable = new Hashtable<>();
		for(int i = 0; i < A.length; ++i){
			if(myHashtable.containsKey(A[i]) != true){
				myHashtable.put(A[i], 1);
			}
			else{
				if(myHashtable.get(A[i]) == 1)
					myHashtable.replace(A[i], 2);
				else 
					myHashtable.replace(A[i], 3);
				
			}
		}
		
		for(Integer i : myHashtable.keySet()){
			if(myHashtable.get(i) == 1)
				return i;
		}
		return 0;
	}
	
	private static int findSingleNumberPart2Solution2(int[] A){
		
		int count[] = new int[32];
		int result = 0;
		
		for(int i = 0; i < 32; ++i){
			for(int j = 0; j < A.length; ++j){
				if((A[j] >> i & 1) == 1){
					count[i]++;
				}
			}
			
			int bit = count[i] % 3 << i;
			result |= bit;
		}
		
		return result;
	}
	
	public static void generatePascalTriangleTest(){
		List<List<Integer>> PascalTriangle = generatePascalTriangleInLoop(6);
		for(int i = 0; i < PascalTriangle.size(); ++i){
			List lineList = PascalTriangle.get(i);
			System.out.print("[");
			for(int j = 0; j < lineList.size()-1; ++j){
				System.out.print(lineList.get(j) + ", ");
			}
			System.out.print(lineList.get(lineList.size()-1));
			System.out.print("]" + "\n");
		}
		
	}
	
	private static List<List<Integer>> generatePascalTriangleRecur(int numRows) {
		 
		List<List<Integer>> lineList = new ArrayList<List<Integer>>();
//		List<Integer> curList = new ArrayList<Integer>();
//		 
//		if(numRows == 1){
//			curList.add(1);
//			lineList.add(curList);
//			return lineList;
//		}
//		else{
//			lineList = generatePascalTriangle(numRows - 1);
//			List<Integer> lastList = lineList.get(lineList.size() - 1);
//			curList.add(1);
//			for(int i = 0; i < lastList.size() - 1; ++i){
//				curList.add(lastList.get(i) + lastList.get(i+1));
//			}
//			curList.add(1);
//			lineList.add(curList);
			return lineList;
//		 }
	}
	
	private static List<List<Integer>> generatePascalTriangleInLoop(int numRows) {
		
		List<List<Integer>> lineList = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < numRows; ++i){
			List<Integer> curList = new ArrayList<Integer>();
			if(i == 0){
				curList.add(1);
				lineList.add(curList);
			}
			else{
				List<Integer> lastList = lineList.get(i-1);
				curList.add(1);
				for(int j = 0; j < lastList.size() - 1; ++j){
					curList.add(lastList.get(j) + lastList.get(j+1));
				}
				curList.add(1);
				lineList.add(curList);
			}
		}
		
		return lineList;
	}
	
	public  static int maxProductSubArrayTest(){
		
		int[] arr = {5,9,3,4,-1,5,2,4,7,-1,3,2,9,7};
		return maximumProductSubArraySolution(arr);
		
	}
	
	private static int maximumProductSubArray(int[] A){
		
		int value = 0;
		int negativeCount = 0;
		int submax = A[0];
		int submin = A[0];
		int realmax = A[0];
		
		for (int i = 1; i < A.length; i++) {
			if(A[i] > 0){
				submax = Math.max(submax * A[i], A[i]);
				submin = Math.min(submin * A[i], A[i]);
				
			}else{
				int temp = submax;
				submax = Math.max(submin * A[i], A[i]);
				submin = Math.min(temp * A[i], A[i]);
			}
			
			
			realmax = Math.max(realmax, submax);
		}
		
		return 0;
	}
	
	private static int maximumProductSubArraySolution(int[] A){
		if (A.length == 0) {
	        return 0;
	    }
		
		int maxherepre = A[0];
	    int minherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
	        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	    
	}
	
	public static String addBinaryTest(String strA, String strB){
		
		int currentBit = 0;
		int nextBit = 0;
		ArrayList<Integer> res = new ArrayList<>();
		if(strA.length() > strB.length()){
			for(int i = strA.length()-1; i >= 0; --i){
				int bitA = Character.getNumericValue(strA.charAt(i));
				int bitB;
				if(i < strA.length() - strB.length())
					bitB = 0;
				else 
					bitB = Character.getNumericValue(strB.charAt(i - (strA.length() - strB.length())));
				
				int add = bitA + bitB + nextBit;
				currentBit = add & 1;
				nextBit = (add >> 1) & 1;
				
				res.add(currentBit);
			}
			if(nextBit == 1)
				res.add(nextBit);
		}
		else{
			for(int i = strB.length()-1; i >= 0; --i){
				int bitB = Character.getNumericValue(strB.charAt(i));
				int bitA;
				if(i < strB.length()-1 - (strB.length() - strA.length()))
					bitA = 0;
				else 
					bitA = Character.getNumericValue(strA.charAt(i - (strB.length() - strA.length())));
				
				int add = bitA + bitB + nextBit;
				currentBit = add & 1;
				nextBit = (add >> 1) & 1;
				res.add(currentBit);
			}
			if(nextBit == 1)
				res.add(nextBit);
		}
		String str = "";
		for(int i = 0; i < res.size(); i++){
			str = str.concat(res.get(res.size() - 1 - i).toString());
		}
		return str;
	}

    public static String countAndSay(int n) {
        
    	String result = "";
    	String str = "1";
    	int count = 0;
    	char first = str.charAt(0);
    	for(int j = 1; j < n; ++j){
	    	result = "";
	    	for(int i = 0; i < str.length(); ++i){    		
	    		if(i == 0)
	    			first = str.charAt(0);
	    		if(first == str.charAt(i)){
	    			++count;
	    		}
	    		else{
	    			result = result.concat(String.valueOf(count)).concat(String.valueOf(str.charAt(i-1)));
	    			count = 1;
	    			first = str.charAt(i);
	    		}
	    		
    			if(i == str.length() - 1){
	    			result = result.concat(String.valueOf(count)).concat(String.valueOf(str.charAt(i)));
	    			count = 0;
    			}
	    	}
	    	str = result;

    	}
    	return String.valueOf(str);
    }
    
    public static int lengthOfLastWord(String s) {

    	while(s.length() > 0 && s.charAt(s.length() - 1) == ' '){
    		s = s.substring(0, s.length() - 1);
    	}
    	
    	if(s.isEmpty())
    		return 0;
    	
    	int index = s.lastIndexOf(" ");

    	
    	String last = s.substring(index + 1, s.length());
    	
        return last.length();
    }
    
    public static boolean isPalindrome(String s) {
    	//"A man, a plan, a canal: Panama"
    	if(s.isEmpty() == true)
    		return true;
    	
    	int index = s.length() - 1;
    	
    	while(index >= 0){
    		char c = s.charAt(index);
    		int ascii = (int) c;
    		if(!(ascii >= 65 && ascii <= 90) && !(ascii >= 97 && ascii <= 122) && !(ascii >= 48 && ascii <= 57)){
    			
    			if(index == s.length() - 1){
    				s = s.substring(0, index);
    			}else{
        			String s1 = s.substring(0, index);
        			String s2 = s.substring(index + 1, s.length());
        			s = s1.concat(s2);  				
    			}
    		}
    		--index;
    	}
    	
    	if(s.isEmpty() == true)
    		return true;
    	
    	index = 0;
    	while(index < s.length() / 2){
    		if(( (int)s.charAt(index) != (int)s.charAt(s.length() - 1 - index)) && ( Math.abs( (int)s.charAt(index) - (int)s.charAt(s.length() - 1 - index))) != 32){
    			return false;
    		}
    		index++;
    	}
    	
        return true;
    }
    public static boolean isPalindrome2(String s) {
    	if(s.isEmpty() == true)
    		return true;
    	
    	int forwardIndex = 0;
    	int backwardIndex = s.length() - 1;
    	
    	while(forwardIndex < backwardIndex){
    		int forwardC = (int) s.charAt(forwardIndex);
    		int backwardC = (int) s.charAt(backwardIndex);
    		
    		while(!(forwardC >= 65 && forwardC <= 90) && !(forwardC >= 97 && forwardC <= 122) && !(forwardC >= 48 && forwardC <= 57)){
    			forwardIndex++;
    			if(forwardIndex >= s.length())
    				break;
    			forwardC = (int) s.charAt(forwardIndex);
    		}
    		
    		while(!(backwardC >= 65 && backwardC <= 90) && !(backwardC >= 97 && backwardC <= 122) && !(backwardC >= 48 && backwardC <= 57)){
    			backwardIndex--;
    			if(backwardIndex < 0)
    				break;
    			backwardC = (int) s.charAt(backwardIndex);
    		} 		
    		if(forwardIndex >= backwardIndex)
    			break;
    		
    		
    		if(Math.abs(forwardC - backwardC) != 32 && Math.abs(forwardC - backwardC) != 0){
    			return false;
    		}
    		
    		forwardIndex++;
    		backwardIndex--;
    	}
    	
    	return true;
    }

	public int reverse(int x) {
		boolean neg = false;
        if (x < 0) {
        	neg = true;
        	x = -x;
        }
        
        int ret = 0;
        while (x / 10 > 0){
            ret = ret * 10+ x % 10;
            x = x / 10;
        }
        ret =ret * 10 + x;
        if (ret > 0x7fffffff) 
        	return 0; //overflow check.
        if (neg) 
        	return -ret;
        else
        	return ret;
        
    }
	
    public static int[] plusOne(int[] digits) {
        
    	int index = digits.length - 1;
    	List<Integer> array = new ArrayList<>();
    	int last = 1;
    	while(index >= 0){
    		int add = digits[index] + last;
    		if(add >= 10){
    			array.add(add - 10);
    			last = 1;
    			if(index == 0)
    				array.add(1);
    		}
    		else{
    			array.add(add);
    			last = 0;
    		}
			--index;
    	}
    	int[] result = new int[array.size()];
    	
    	for(int i = 0 ; i < array.size(); ++i){
    		result[i] = array.get(array.size() - 1 -i );
    		
    	}
    	
    	return result;
    }
    
    public int removeElement(int[] A, int elem) {
    	
    	
    	
        return 0;
    }


    
    public static int maxProfitI(int[] prices) {

    	int profit = 0;
    	int maxProfit = 0;
    	for(int i = 0; i < prices.length-1; ++i){
    		
   
    		profit += prices[i + 1] - prices[i];
    		if(profit < 0)
    			profit = 0;
    		else if(profit > maxProfit)
				maxProfit = profit;
    	}
    	
        return maxProfit;
    }
    
    public static int maxProfitII(int[] prices) {
    	
    	int profit = 0;
    	for(int i = 0; i < prices.length-1; ++i){
    		if(prices[i + 1] > prices[i])
    			profit += prices[i + 1] - prices[i];
    		
    	}
        return profit;
    }
    
    public static int maxProfitIII(int[] prices) {

    	int maxLose = 0;
    	int lose = 0;
    	int profit = 0;
    	int maxProfit = 0;
    	boolean loseFromStart = false;
    	for(int i = 0; i < prices.length-1; ++i){
    		
    		if(prices[1] < prices[0])
    			loseFromStart = true;
    		
    		if(loseFromStart == true){
    			if( prices[i + 1] < prices[i])
    				continue;
    			else {
    				loseFromStart = false;
				}
			}
    		
    		if(prices[i + 1] < prices[i]){
    			
    			lose += prices[i] - prices[i+1];
    			
    			if(i !=  prices.length-2 &&prices[i + 2] > prices[i + 1]){
    				if(lose > maxLose)
    					maxLose = lose;
    				lose = 0;
    			}
    		}
   
    		profit += prices[i + 1] - prices[i];
    		if(profit < 0)
    			profit = 0;
    		else if(profit > maxProfit)
				maxProfit = profit;
    	}
    	
        return maxProfit - maxLose;
    }
}
