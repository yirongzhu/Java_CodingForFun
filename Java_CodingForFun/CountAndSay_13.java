package codingForFun;

// First,let user input a number, say 1. Then, the function will generate the next 10 numbers which satisfy this condition: 
// 1, 11,21,1211,111221,312211... 
// explanation: first number 1, second number is one 1, so 11. Third number is two1(previous number), so 21. next number one 2 one 1, so 1211 and so on...
public class CountAndSay_13 {

	public void count10Numbers(int num) {
		String dp = String.valueOf(num);
		System.out.print(dp + " ");
		for (int i = 0; i < 10; i++) {
			int j = 0;
			StringBuffer now = new StringBuffer();
			while (j < dp.length()) {
				int count = 1;
				while (j < dp.length() - 1 && dp.charAt(j) == dp.charAt(j + 1)) {
					count++;
					j++;
				}
				now.append(count);
				now.append(dp.charAt(j));
				j++;
			}
			dp = now.toString();
			System.out.print(dp + " ");
		}
	}
	
	public static void main(String[] args) {
		CountAndSay_13 cas = new CountAndSay_13();
		cas.count10Numbers(1);
	}
}
