package codingForFun;

import java.util.Scanner;

// Take a series of integers as input till a zero is entered. Among these given integers, find the maximum of the odd numbers and the minimum of the even integers
// (not including zero) and print them.
public class FindMaxMinNumber_22 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int in = 0;
		while (true) {
			in = scan.nextInt();
			if (in == 0) {
				break;
			}
			if (in % 2 == 0 && in < min) {
				min = in;
			}
			if (in % 2 == 1 && in > max) {
				max = in;
			}
		}
		System.out.println("The maximum of the odd numbers is: " + max);
		System.out.println("The minimum of the even numbers is: " + min);
	}
}
