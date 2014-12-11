package codingForFun;
import java.util.*;

// A number can be broken into different sub-sequence parts. Suppose a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. And this number is a colorful number,
// since product of every digit of a sub-sequence are different. That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40.
// But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. You have to write a function that tells if the given number is a colorful number or not.
public class ColorfulNumbers_1 {

	public boolean isColorfulNumber(int number) {
		if (number < 10) {
			return true;
		}
		ArrayList<Integer> product = new ArrayList<>();
		String colorS = String.valueOf(number);
		int len = colorS.length();
		for (int i = 1; i < len; i++) {
			for (int j = 0; i + j <= len; j++) {
				int sub = Integer.parseInt(colorS.substring(j, i + j));
				int subP = getProduct(sub);
				if (product.contains(subP)) {
					return false;
				}
				else {
					product.add(subP);
				}
			}
		}
		return true;
	}
	
	public int getProduct(int sub) {
		if (sub == 0) {
			return 0;
		}
		int result = 1;
		while (sub != 0) {
			result *= (sub % 10);
			sub /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ColorfulNumbers_1 cn = new ColorfulNumbers_1();
		System.out.println(cn.isColorfulNumber(3245));
		System.out.println(cn.isColorfulNumber(326));
		System.out.println(cn.isColorfulNumber(206));
		System.out.println(cn.isColorfulNumber(216));
		System.out.println(cn.isColorfulNumber(22));
	}
}
