package codingForFun;

// Find the seed of a number. Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seed for a given number.
public class SeedsNumber_31 {

	public void findSeedsNumber(int num) {
		if (num < 10) {
			System.out.println("The seed of " + num + " is " + num);
		}
		int seed = 10;
		int p = 1;
		while (seed <= num) {
			if (num % seed == 0) {
				int f = seed;
				p = f;
				while (f != 0) {
					p *= (f % 10);
					f /= 10;
				}
				if (p == num) {
					System.out.println("The seed of " + num + " is " + seed);
				}
			}
			seed++;
		}
	}
	
	public static void main(String[] args) {
		SeedsNumber_31 sn = new SeedsNumber_31();
		sn.findSeedsNumber(1716);
	}
}
