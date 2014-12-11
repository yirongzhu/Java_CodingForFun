package codingForFun;

// Write a program to add the substring 
// eg :say you have a list {1 7 6 3 5 8 9 } and user is entering a sum 16. Output should display (2-4) that is {7 6 3} cause 7+6+3=16.
public class SubstringAddition_43 {

	// Note: has to be continuous subarray for addition, else would be 3-sum or n-sum.
	public void checkSubstringAddition(int[] array, int sum)
	{
		for (int i = 0; i < array.length; i++) {
			int total = 0;	
			for(int j = i; j < array.length; j++) {
				total += array[j];
				if (total == sum) {
					System.out.println("(" + (i + 1) + "-" + (j + 1) + ")");
				}
				if (total > sum) {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		SubstringAddition_43 sa = new SubstringAddition_43();
		int [] array = {1, 7, 6, 3, 5, 8, 9};
		int sum = 16;
		sa.checkSubstringAddition(array, sum);
		
	}
}
