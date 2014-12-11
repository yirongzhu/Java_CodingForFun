package codingForFun;

// Given a number find whether the digits in the number can be used to form an equation with + and '='.
// That is if the number is123, we can have a equation of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
public class PlusEqualNumber_47 {

	public static int count = 0;

	public static int check(int n1, int n2, int n3) {
		count++;
		if (n1 + n2 == n3) {
			System.out.println(n1 + "+" + n2 + "=" + n3);
			return 1;
		} else if (n2 + n3 == n1) {
			System.out.println(n2 + "+" + n3 + "=" + n1);
			return 2;
		} else if (n1 + n3 == n2) {
			System.out.println(n1 + "+" + n3 + "=" + n2);
			return 3;
		} else
			return 0;
	}

	public static void main(String args[]) {
		String f = "17512";
		int n = f.length() / 2;
		System.out.println(n);
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n + i + 1; j++) {
				int num1 = Integer.parseInt(f.substring(0, i + 1));
				int num2 = Integer.parseInt(f.substring(i + 1, j + 1));
				int num3 = Integer.parseInt(f.substring(j + 1, f.length()));
				int temp = check(num1, num2, num3);
				if (temp == 0)
					continue;
				else
					break;

			}
		System.out.println(count);
	}
}
