package codingForFun;

// Find the largest sum contiguous sub array. The length of the returned sub array must beat least of length 2.
public class LargestSumSubArray_11 {

	/**
	 * Copyright: NineChapter
	 * - Algorithm Course, Mock Interview, Interview Questions
	 * - More details on: http://www.ninechapter.com/
	 */

	// Version 1: Sliding Window

	public class Solution {
	    public int maxSubArray(int[] A) {
	        if (A == null || A.length == 0){
	            return 0;
	        }
	        
	        int max = Integer.MIN_VALUE, sum = 0;
	        for (int i = 0; i < A.length; i++) {
	            sum += A[i];
	            max = Math.max(max, sum);
	            sum = Math.max(sum, 0);
	        }

	        return max;
	    }
	}

	// Version 2: Prefix Sum

	public class Solution1 {
	    public int maxSubArray(int[] A) {
	        if (A == null || A.length == 0){
	            return 0;
	        }
	        
	        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
	        for (int i = 0; i < A.length; i++) {
	            sum += A[i];
	            max = Math.max(max, sum - minSum);
	            minSum = Math.min(minSum, sum);
	        }

	        return max;
	    }
	}
}
