package codingForFun;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
*/
// you are to write a program that simulates a cash register.  for example, if something cost $10.25 and the customer pays with a $20 bill,
// the program will print out the most efficient "change-breakdown" which is 1 five, 4 ones, and 3 quarters.
public class CoinChange_20 {
	
	public void findCoinChange(double cost, double paid) {
		double rest = paid - cost;
		int ten = 0, five = 0, one = 0, quarter = 0, nickel = 0, dime = 0, cent = 0;
		while (true) {
			if (rest >= 10) {
				ten++;
				rest -= 10;
			}
			else if (rest >= 5) {
				five++;
				rest -= 5;
			}
			else if (rest >= 1) {
				one++;
				rest -= 1;
			}
			else if (rest >= 0.25) {
				quarter++;
				rest -= 0.25;
			}
			else if (rest >= 0.10) {
				dime++;
				rest -= 0.10;
			}
			else if (rest >= 0.05) {
				nickel++;
				rest -= 0.05;
			}
			else if (rest >= 0.01) {
				cent++;
				rest -= 0.01;
			}
			if (rest <= (double) 0) {
				break;
			}
		}
		System.out.println("Tens = " + ten + " Fives = " + five + " Ones = " + one + " Quarters = " + quarter + " dimes = " + dime + " nickels = " + nickel + " cents = " + cent);
	}

	public static void main(String[] args) {
		CoinChange_20 cc = new CoinChange_20();
		double cost = 10.25;
		double paid = 20;
		cc.findCoinChange(cost, paid);
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter total cost");
		try {
			double cost = Double.parseDouble(br.readLine());

			System.out.println("Enter the amount paid");
			double amount = Double.parseDouble(br.readLine());

			double ret = amount - cost;

			int one = 0, five = 0, ten = 0, quarter = 0, nickel = 0, dime = 0, cent = 0;
			while (true) {
				System.out.println(ret);
				if (ret >= 10) {
					ten++;

					ret -= 10;
				} else if (ret >= 5) {
					five++;

					ret -= 5;
				} else if (ret >= 1) {
					one++;

					ret -= 1;
				} else if (ret >= 0.25) {
					quarter++;

					ret -= 0.25;
				} else if (ret >= 0.10) {
					dime++;

					ret -= 0.10;
				} else if (ret >= 0.05) {
					nickel++;

					ret -= 0.05;
				} else if (ret >= 0.01) {
					cent++;

					ret -= 0.01;
				}

				if (ret <= (double) 0) {
					break;
				}

			}
			System.out.println("Tens = " + ten + " Five = " + five + " One = "
					+ one + " Quarter = " + quarter + " dime = " + dime
					+ " nickel = " + nickel + " cent = " + cent);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
