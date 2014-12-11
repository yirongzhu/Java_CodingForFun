package codingForFun;

// There is one kind of numbers call FibbonaciNumber, which satisfy the following situation:
// A. can be spilt into several numbers;
// B. The first two number are the same, the next number is equal to the sum of previous two
// eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
// If you are given a range by the user, find all numbers that are Fibbonaci numbers.
public class FibbonaciNumber_19 {

	public void printAllAdditiveNumber(int low, int high) {
		if (low < 112 || low < 112 || low > high){  // error check
    		return;
    	}
		for (int value = low; value <= high; value++) {
			if (check(String.valueOf(value))) {
				System.out.println(value);
			}
		}
	}
	
	public boolean check(String num) {
		  for (int i = 1; i < num.length(); i++) {
			  int num1 = Integer.parseInt(num.substring(0,i));
			  
			  for (int j = i + 1; j < num.length(); j++) {
				  int temp_num1 = num1;
				  int num2 = Integer.parseInt(num.substring(i, j));
				  int thirdIndex = j;
				  int rest = Integer.parseInt(num.substring(thirdIndex, num.length()));
				  while (temp_num1 + num2 <= rest) {
					  int num3 = temp_num1 + num2;
					  String newNum = String.valueOf(num3);
					  int length = newNum.length();
					  if (thirdIndex + length > num.length()) {
						  break;
					  }
					  if (num.substring(thirdIndex, thirdIndex + length).equals(newNum)) {
						  thirdIndex += length;
						  if (thirdIndex == num.length()) {
							  return true;
						  }
						  temp_num1 = num2;
						  num2 = num3;
						  rest = Integer.parseInt(num.substring(thirdIndex, num.length()));
		      
					  }
					  else {
						  break;
					  }
				  }
			  }
		  }
		  return false;
	}
	
	public static void main(String[] args) {
		FibbonaciNumber_19 fn = new FibbonaciNumber_19();
		fn.printAllAdditiveNumber(112, 100000);
	}
}
