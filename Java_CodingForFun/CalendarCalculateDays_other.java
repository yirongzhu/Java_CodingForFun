package codingForFun;


// Take a date from the user in format mm/dd/yyyy. 
// Get the number of days between the 1st January of entered date and the entered date. 
// So if the user enters 23march2010. Print the number of days between 1 January 2010 and 23 March 2010.
public class CalendarCalculateDays_other {

	private static int[] NUM_OF_DAYS_MON = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
	}
	
	public int daysBetween(String date) {
		int year = Integer.parseInt(date.substring(date.length() - 4));
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3, 5));
		if (isLeapYear(year)) {
			NUM_OF_DAYS_MON[2] = 29;
		}
		int result = 0;
		for (int i = 1; i < month; i++) {
			result += NUM_OF_DAYS_MON[i];
		}
		result = result + day - 1;
		return result;
	}
	
	public static void main(String args[]) {
		CalendarCalculateDays_other difference = new CalendarCalculateDays_other();
		System.out.println("Number of days: " + difference.daysBetween("03/23/2010"));
	}
}
