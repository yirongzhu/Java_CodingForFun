package codingForFun;

// Print all palindromes of size greater than or equal to 3 of a given string. (How to do it with DP)?
/*
Let F[u,v] = 1 if the sub-string of S from u to v (i.e. S[u]..S[v]) is a palindrome, F[u,v] = 0 otherwise. 
Then I will need to compute all F[i,j]. Finally, I will check if F[i,i+k] == 1 with k>=3, if so I will output the sub-string from i to i+k. 
Formula to compute F[u,v]: 

F[u,v] = 3 cases: 
1. u == v: F[u,v] = 1; 
2. u == v+1: F[u,v] = (S[u] == S[v]); 
3. u >= v+2: F[u,v] = (S[u] == S[v]? F[u+1,v-1] : 0) 

So, code may look like this:


for (k=0; k<n;   k++)
for (i=0;  i<n-k; i++){
	u = i;
	v = i+k;
	F[u,v] = the_formula_above;
}
*/

public class Palindromes_35 {

	public void display(char[] a, int low, int high) {
		for (int i = low; i <= high; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public void getPalin(char[] a, int n) {
		int low;
		int high;
		for (int i = 1; i < n; i++) {
			low = i - 1;
			high = i;
			while (low >= 0 && high < n && a[low] == a[high]) {
				if (high - low + 1 >= 3) {
					display(a, low, high);

				}
				low--;
				high++;
			}
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < n && a[low] == a[high]) {
				if (high - low + 1 >= 3) {
					display(a, low, high);
				}
				low--;
				high++;
			}
		}
	}
	
	public void displayAllPalin(String s) {
		if (s == null || s.length() == 0) {
			return;
		}
		char[] c = s.toCharArray();
		int length = c.length;
		getPalin(c, length);
	}
	
	public static void main(String[] args) {
		Palindromes_35 p = new Palindromes_35();
		String s = "cabbaabbacasdasdsdsdsdassadsadasdasadsadasda";
		p.displayAllPalin(s);
	}
}
