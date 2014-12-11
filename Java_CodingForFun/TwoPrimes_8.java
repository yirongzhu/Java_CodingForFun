package codingForFun;

// Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes. Write a function which takes a number as input,
// verify if is an even number greater than 2 and also print at least one pair of prime numbers.
public class TwoPrimes_8 {

	public void getTwoPrimes(int num) {
		if (num <= 2 || num % 2 != 0) {
			return;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (isPrime(i) && isPrime(num - i)) {
				System.out.println("(" + i + ", " + (num - i) + ")");
			}
		}
	}
	
	public boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TwoPrimes_8 tp = new TwoPrimes_8();
		for (int i = 0; i <= 100; i++) {
			tp.getTwoPrimes(i);
		}
	}
}
