package codingForFun;

// Write a program to generate all palindrome dates by taking the beginning and the ending dates as an input from the user.
// The format of the date is given as MMDDYYYY.
public class PalindromeDate_other {

	private static int[] NUM_OF_DAYS_MON = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
	}
	
	private boolean isValidDate(String date) {
		int year = Integer.parseInt(date.substring(4));
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(2, 4));
		if (isLeapYear(year)) {
			NUM_OF_DAYS_MON[2] = 29;
		}
		else {
			NUM_OF_DAYS_MON[2] = 28;
		}
		return (year < 0 || month < 1 || month > 12 || day < 0 || day > NUM_OF_DAYS_MON[month]) ? false : true;
	}
	
	private boolean isFirstDateBeforeSecond(String firstDate, String secondDate) {
		int firstYear = Integer.parseInt(firstDate.substring(4));
		int secondYear = Integer.parseInt(secondDate.substring(4));
		int firstMonth = Integer.parseInt(firstDate.substring(0, 2));
		int secondMonth = Integer.parseInt(secondDate.substring(0, 2));
		int firstDay = Integer.parseInt(firstDate.substring(2, 4));
		int secondDay = Integer.parseInt(secondDate.substring(2, 4));
		if (firstYear < secondYear) {
			return true;
		}
		else if (firstYear == secondYear){
			if (firstMonth < secondMonth) {
				return true;
			}
			else if (firstMonth == secondMonth) {
				if (firstDay < secondDay) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	private String yearReverse(int year) {
		String result = "";
		String y = String.valueOf(year);
		for (int i = y.length() - 1; i >= 0 ; i--) {
			result += y.charAt(i);
		}
		return result;
	}
	
	public void printPalindrome(String startDate, String endDate) {
		if (!isValidDate(startDate) || !isValidDate(endDate)) {
			return;
		}
		int startYear = Integer.parseInt(startDate.substring(4));
		int endYear = Integer.parseInt(endDate.substring(4));
		for (int i = startYear; i <= endYear; i++) {
			String palindromeDate = yearReverse(i) + String.valueOf(i);
			if (isValidDate(palindromeDate) && !isFirstDateBeforeSecond(palindromeDate, startDate) && !isFirstDateBeforeSecond(endDate, palindromeDate)) {
				System.out.println(palindromeDate);
			}
		}
	}
	
	public void printPalindrome1(int year1, int year2) {
		String mm = "";
		String dd = "";
		String yy = "";
		int m = 0;
		int d = 0;
		for (int currentYear = year1; currentYear <= year2; currentYear++) {
			if ((currentYear % 400 == 0) || ((currentYear % 100 != 0) && (currentYear % 4 == 0))) {
				NUM_OF_DAYS_MON[2] = 29;
			}
			yy = Integer.toString(currentYear);
			mm = Integer.toString(currentYear % 10) + Integer.toString((currentYear / 10) % 10);
			dd = Integer.toString((currentYear / 100) % 10) + Integer.toString((currentYear / 1000) % 10);
			m = Integer.parseInt(mm);
			d = Integer.parseInt(dd);
			if (m > 0 && m <= 12 && d > 0 && d <= NUM_OF_DAYS_MON[m - 1]) {
				System.out.println(mm + dd + yy);
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromeDate_other po = new PalindromeDate_other();
		po.printPalindrome("01019220", "02029230");
		po.printPalindrome1(9220, 9230);
	}
}
