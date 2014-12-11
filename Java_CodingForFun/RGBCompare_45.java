package codingForFun;

// Given a string of RGB value (rr, gg, bb)which represents in hexadecimal. Compare if rr or gg or bb is the biggest,
// or two of those values are equal and larger than the third one, or three values are equal with each other.
public class RGBCompare_45 {

	public int hToD(char c) {
		if (c == 'A' || c == 'a') {
			return 10;
		}
		else if (c == 'B' || c == 'b') {
			return 11;
		}
		else if (c == 'C' || c == 'c') {
			return 12;
		}
		else if (c == 'D' || c == 'd') {
			return 13;
		}
		else if (c == 'E' || c == 'e') {
			return 14;
		}
		else if (c == 'F' || c == 'f') {
			return 15;
		}
		else {
			return (int) c;
		}
	}
	
	public int hexiToDeci(String s) {
		int len = s.length();
		int result = 0;
		for (int i = len - 1; i >= 0; i--) {
			char c = s.charAt(i);
			result += hToD(c) * Math.pow(16, len - 1 - i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		RGBCompare_45 r = new RGBCompare_45();
		System.out.println(r.hexiToDeci("cafe"));
	}
}
