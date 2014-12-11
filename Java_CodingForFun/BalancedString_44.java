package codingForFun;

import java.util.*;

// Given a string that has{},[],() and characters.Check if the string is balanced. E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
public class BalancedString_44 {

	private static final char[] bigParen = {'{', '}'};
	private static final char[] midParen = {'[', ']'};
	private static final char[] smallParen = {'(', ')'};
	
	public boolean checkValidParen(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == bigParen[0] || c == midParen[0] || c == smallParen[0]) {
				stack.push(c);
			}
			else if (c == bigParen[1]) {
				if (!stack.isEmpty() && stack.peek() == bigParen[0]) {
					stack.pop();
				}
				else {
					return false;
				}
			}
			else if (c == midParen[1]) {
				if (!stack.isEmpty() && stack.peek() == midParen[0]) {
					stack.pop();
				}
				else {
					return false;
				}
			}
			else if (c == smallParen[1]) {
				if (!stack.isEmpty() && stack.peek() == smallParen[0]) {
					stack.pop();
				}
				else {
					return false;
				}
			}
			else {
				continue;
			}
		}
		return stack.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		BalancedString_44 bs = new BalancedString_44();
		System.out.println(bs.checkValidParen("{a[(b)]}"));
		System.out.println(bs.checkValidParen("{a[(b])}"));
		System.out.println(bs.checkValidParen("{}a[(b)]"));
	}
}
