package codingForFun;

// SMS Problem 
// 1 - NULL, 2 - ABC, 3 - DEF, 4 - GHI, 5 - JKL, 6 - MON, 7 - PQRS, 8 - TUV, 9 - WXYZ, * - <Space>, # - <Break> 
// We must convert the numbers to text. 
// Eg 
// I/P - O/P 
// 22 - B 
// 23 - AD 
// 223 - BD 
// 22#2 - BA (# breaks the cycle) 
// 3#33 - DE 
// 2222 - 2 
// 2222#2 - 2A 
// 22222 - A (cycle must wrap around) 
// 222222 - B
public class SMS_5 {

	public String getSMSText(String str) {
		if(str == null || str.length() == 0) {
			return null;
		}
		String patterns[] = {"10", "ABC2", "DEF3", "GHI4", "JKL5", "MON6", "PQRS7", "TUV8", "WXYZ9", " *", "#"};
		int positions[] = {2, 4, 4, 4, 4, 4, 5, 4, 5, 2, 1};
		StringBuilder ParsedString = new StringBuilder();
		Character c = str.charAt(0);
		int counter = 0;
		int index = 0;
		int position = 0;
		for (int i = 1; i < str.length(); i++) {
			// System.out.println(c);
			if (str.charAt(i) == c) {
				counter++;
			} 
			else {
				if (c != '#') {
					if (c == '*') {
						index = 9;
					}
					else {
						index = ((int) c - 48) - 1;
					}
					position = counter % positions[index];
					char toAdd = patterns[index].charAt(position);
					if (toAdd != '0') {
						ParsedString.append(toAdd);
					}
					c = str.charAt(i);
					counter = 0;
				} 
				else {
					c = str.charAt(i);
				}
			}
		}
		if (c != '#') {
			if (c == '*') {
				index = 9;
			}
			else {
				index = ((int) str.charAt(str.length() - 1) - 48) - 1;
			}
			position = counter % positions[index];
			ParsedString.append(patterns[index].charAt(position));
		}
		return ParsedString.toString();
	}
	
	public static void main(String[] args) {
		SMS_5 sms = new SMS_5();
		System.out.println(sms.getSMSText("1"));
		System.out.println(sms.getSMSText("2"));
		System.out.println(sms.getSMSText("22"));
		System.out.println(sms.getSMSText("23"));
		System.out.println(sms.getSMSText("223"));
		System.out.println(sms.getSMSText("22#2"));
		System.out.println(sms.getSMSText("3#33"));
		System.out.println(sms.getSMSText("2222"));
		System.out.println(sms.getSMSText("2222#2"));
		System.out.println(sms.getSMSText("22222"));
		System.out.println(sms.getSMSText("222*222"));
	}
}
