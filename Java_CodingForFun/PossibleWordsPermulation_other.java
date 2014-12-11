package codingForFun;

// get a string(word) from user, then make every possible permutation words. 
// Ex)intput: tree => output : tree, rtee, rete, reet, etre, eetr, eert, eter, eret, teer, reet...
public class PossibleWordsPermulation_other {

	public static void main(String[] args) {
		char a[] = {'t', 'r', 'e', 'e'};
		permute(a, 0);
	}

	public static void permute(char[] a, int k) {
		if (k == a.length) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.print("\n");
			return;
		} else {
			for (int i = k; i < a.length; i++) {
				char temp = a[k];
				a[k] = a[i];
				a[i] = temp;
				permute(a, k + 1);
				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
	}
}
