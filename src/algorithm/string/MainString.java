package algorithm.string;

public class MainString {
	public static void main(String[] args) {
		testLCS();
		testTransform();
	}
	
	private static void testLCS(){
		System.out.print("****LCS Test****" + "\n");
		String strX = "CATCGA";
		String strY = "GTACCGTCA";
		
		LCS lcs = new LCS(strX, strY);
		lcs.computeLCSTable();
		
		String strLCS = lcs.findLCS("", strX.length(), strY.length());
		
		System.out.print("LCS: " + strLCS);
		System.out.print("\n");
		System.out.print("\n");
	}
	
	private static void testTransform(){

		System.out.print("****Transform Test****" + "\n");
		
		String strX = "ACAAGC";
		String strY = "CCGT";
		
		Transform transform = new Transform(strX, strY);
		int cost = transform.computeTransformTable();
		System.out.print("Cost is " + cost + "\n");
		
		String strTransform = transform.assembleTransformation("", strX.length(), strY.length());
		System.out.print("String after transform: " + strTransform + "\n");
	}
}
