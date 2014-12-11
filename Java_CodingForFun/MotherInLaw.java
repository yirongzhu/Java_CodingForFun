package codingForFun;

import java.util.*;

public class MotherInLaw {
	public static List<String> motherInLaw(String str) {
		List<String> res = new LinkedList<String>();
		if (str == null || str.length() == 0)
			return res;
		HashSet<Integer> set = new HashSet<Integer>();
		List<Character> chars = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				return res;
			} else if (c >= 'a' && c <= 'z') { // lower case
				chars.add(c);
			} else { // record the positions that do not need change
				set.add(i);
			}
		}
		char[] seq = str.toCharArray();
		boolean[] used = new boolean[chars.size()];
		permute(res, set, chars, seq, used, 0, chars.size());
		return res;
	}

	private static void permute(List<String> res, HashSet<Integer> set,	List<Character> chars, char[] seq, boolean[] used, int start, int n) {
		if (n == 0) { // no available chars, find a permutation
			res.add(new String(seq));
			return;
		}
		if (set.contains(start)) { // this position is already feed, go next
									// directly
			permute(res, set, chars, seq, used, start + 1, n);
		} else {
			for (int i = 0; i < chars.size(); i++) { // try every available char
														// on this position
				if (used[i])
					continue;
				seq[start] = chars.get(i);
				used[i] = true;
				permute(res, set, chars, seq, used, start + 1, n - 1); // feed
																		// next
																		// position
				seq[start] = '\0';
				used[i] = false;
			}
		}
	}
}
