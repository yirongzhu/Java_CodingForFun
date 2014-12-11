package codingForFun;

// There¡¯s a word guessing game. One personthink a word, and the other one guess a word
// The person should return the number of bulls and cows for the guessing. Bullsrepresent the number of same characters in the same spots,
// whereas cowsrepresent the number of characters guessed right but in the wrong spots. Writea program with two input strings, return the number of bulls and cows.
public class BullCow_34 {

	public void bullsCows(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return;
		}
		int bulls = 0;
		int cows = 0;
		int i;
		int[] countS1 = new int[26];
		int[] countS2 = new int[26];
		for (i = 0; i < s1.length() && i < s2.length(); i++) {
			int s1c = (int) s1.toLowerCase().charAt(i);
			int s2c = (int) s2.toLowerCase().charAt(i);
			if (s1c == s2c) {
				bulls++;
			}
			countS1[s1c - 97]++;
			countS2[s2c - 97]++;
		}
		for ( ; i < s1.length(); i++) {
			countS1[s1.toLowerCase().charAt(i) - 97]++;
		}
		for ( ; i < s2.length(); i++) {
			countS2[s2.toLowerCase().charAt(i) - 97]++;
		}
		for (int j = 0; j < 26; j++) {
			cows += Math.min(countS1[j], countS2[j]);
		}
		cows -= bulls;
		System.out.println("Bulls: " + bulls);
		System.out.println("Cows: " + cows);
	}

	
	public static void main(String[] args) {
		BullCow_34 bc = new BullCow_34();
		bc.bullsCows("forum", "four");
		bc.bullsCows("Picture", "epic");
		bc.bullsCows("Groupon", "Ponder");
		bc.bullsCows("SWIM", "microsoft");
	}
}
