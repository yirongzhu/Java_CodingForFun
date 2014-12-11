package codingForFun;

// Suppose you want to do the subtraction of two numbers. Each digit of the numbers is divided and put in an array. Like A=[1, 2, 3, 4, 5], B=[4, 5, 3, 5].
// You should output an array C=[7, 8, 1, 0]. Remember that your machine can¡¯t hand numbers larger than 20.
public class SubstractionTwoArrays_37 {

	public static int[] sub(int[] a, int[] b) {
		int alen = a.length;
		int blen = b.length;
		int maxlen = Math.max(alen, blen);
		int[] atemp = new int[maxlen];
		int[] btemp = new int[maxlen];
		int[] temparr;
		int mul = 1;
		for (int i = 0; i < alen; i++) {
			atemp[maxlen - 1 - i] = a[alen - i - 1];
		}
		for (int i = 0; i < blen; i++) {
			btemp[maxlen - 1 - i] = b[blen - i - 1];
		}
		for (int i = 0; i < maxlen; i++) {
			if (atemp[i] < btemp[i]) {
				temparr = atemp;
				atemp = btemp;
				btemp = temparr;
				mul = -1;
				break;
			}
		}
		int[] out = new int[maxlen];
		int carry = 0;
		for (int i = 0; i < maxlen; i++) {
			int temp = atemp[maxlen - i - 1] - btemp[maxlen - i - 1] - carry;
			if (temp >= 0) {
				out[maxlen - i - 1] = temp;
				carry = 0;
			} else {
				out[maxlen - i - 1] = 10 + temp;
				carry = 1;
			}
		}
		out[0] *= mul;
		return out;
	}
	
	public int[] minus (int[] a, int[] b) {
	    if (a == null || b == null || a.length != b.length) {
	        return null;
	    }
	    int len = a.length;
	    int[] result = new int[len];
	    boolean negative = false;
	    int[] temp;
	    int i;
	    for (i = 0; a[i] == b[i] && i < len; i++);
	    if (i < len && a[i] < b[i]) {
	        negative = true;
	        temp = a;
	        a = b;
	        b = temp;
	    }
	    int check = 0;
	    for (int j = len - 1; j > 0; j--) {
	        if (a[j] > 0 && a[j] - check >= b[j]) {
	            result[j] = a[j] - check - b[j];
	            check = 0;
	        }
	        else if (a[j] == 0 && a[j] - check >= b[j]) {
	            result[j] = 0;
	            check = 0;
	        }
	        else {
	            result[j] = a[j] - check + 10 - b[j];
	            check = 1;
	        }
	    }
	    if (negative) {
	        result[0] = -result[0];
	    }
	    return result;
	}

}
