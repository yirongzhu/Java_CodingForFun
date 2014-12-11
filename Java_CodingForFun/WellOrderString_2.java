package codingForFun;

import java.util.*;

// You know a password is well-ordered string. Well-ordered string means that the order of the characters is in an alphabetical increasing order.
// Like ¡°abEm¡± is a well-ordered number. However, ¡°abmE¡± is not a well-order number. Given an input# that tells you also how many digits are in the password, print all possible passwords.
public class WellOrderString_2 {

	public void findWellOrderString(int num) {
		String result = "";
		char last = 'a';
		findWellOrderStringHelper(num, result, last);
	}
	
	public void findWellOrderStringHelper(int num, String result, char last) {
		if (num == 0) {
			System.out.println(result);
			return;
		}
		else {
			for (char add = last; add <= 'z'; add++) {
				findWellOrderStringHelper(num - 1, result + add, (char) (last + 1));
				findWellOrderStringHelper(num - 1, result + String.valueOf(add).toUpperCase(), (char) (last + 1));
			}
		}
	}
	
	public void findWellOrderString1(int num) {
		ArrayList<String> result = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			result.add(c + "");
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			result.add(c + "");
		}
		for (int i = 1; i < num; i++) {
			ArrayList<String> now = new ArrayList<>();
			for (String e : result) {
				char last = e.toLowerCase().charAt(e.length() - 1);
				for (char add = (char) (last + 1); add < 'z'; add++) {
					now.add(e + add);
					now.add(e + String.valueOf(add).toUpperCase());
				}
			}
			result = now;
		}
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		WellOrderString_2 wos = new WellOrderString_2();
		wos.findWellOrderString1(3);
	}
}
