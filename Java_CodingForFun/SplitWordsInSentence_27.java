package codingForFun;

// Given a string.Replace the words whose length>=4 and is even,with a space between the two equal halves of the word.consider only alphabets for finding the eveness of the word 
// I/P "A person can't walk in this street" 
// O/P "A per son ca n't wa lk in th is str eet"
public class SplitWordsInSentence_27 {

	public String splitSentence(String str) {
		String[] arr = str.split(" ");
		String out = "";
		for (String word : arr) {
			if (isFourLetter(word)) {
				out += splitWord(word) + " ";
			} 
			else {
				out += word + " ";
			}
		}
		return out;
	}

	public boolean isFourLetter(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				count++;
			}
		}
		return (count >= 4 && count % 2 == 0) ? true : false;
	}

	public String splitWord(String str) {
		int count = 0;
		String out = "";
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				count++;
			}
			temp += str.charAt(i);
			if (count == str.length() / 2) {
				out += temp + " ";
				count = 0;
				temp = "";
			}
		}
		return out.trim();
	}
	
	public static void main(String[] args) {
		SplitWordsInSentence_27 swis = new SplitWordsInSentence_27();
		System.out.println(swis.splitSentence("A person can't walk in this street"));
		System.out.println(swis.splitSentence("A boy isn't playin in a garden"));
		System.out.println(swis.splitSentence("I d'ont know"));
	}
}
