package codingForFun;

// Get a date (mon/day/year) from user. Print exact the week of dates (Sun to Sat). ex) input: 2/20/2001 if the day is Wednesday 
// output: Sunday 2/17/2001 
// Monday 2/18/2001 
// Tuesday 2/19/2001 
// Wednesday 2/20/2001 
// Thursday 2/21/2001 
// Friday 2/22/2001 
// Saturday 2/23/2002
public class Calendar_30 {

	private static final int[] NUM_OF_DAYS_MON = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] DAY = new String[] {"Sunday", "Monday", "Tuesday", "WednesDay", "Thursday", "Friday", "Saturday"};
	
	public boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
	}
	
	public int numOfDaysInMonthAndYear(int month, int year) {
		if (isLeapYear(year) && month == 2) {
			return NUM_OF_DAYS_MON[month] + 1;
		}
		else {
			return NUM_OF_DAYS_MON[month];
		}
	}
	
	public void printDate(int year, int month, int date, int day) {
		System.out.println(DAY[day] + " " + month + "/" + date + "/" + year);
	}
	
	public void printWeek(int year, int month, int date, int day) {
		if (month > 12 || month < 1 || date > NUM_OF_DAYS_MON[month] || date < 1 || day < 0 || day > 6) {
			return;
		}
		for (int d = day; d > 0; d--) {
			if (date == 1) {
				if (month == 1) {
					year--;
					month = 12;
					date = numOfDaysInMonthAndYear(month, year);
				}
				else {
					month--;
					date = numOfDaysInMonthAndYear(month, year);
				}
			}
			else {
				date--;
			}
		}
		for (int d = 0; d < 7; d++) {
			printDate(year, month, date, d);
			if (date == numOfDaysInMonthAndYear(month, year)) {
				if (month == 12) {
					year++;
					month = 1;
					date = 1;
				}
				else {
					month++;
					date = 1;
				}
			}
			else {
				date++;
			}
		}
	}
	
	public static void main(String[] args) {
		Calendar_30 c = new Calendar_30();
		c.printWeek(1996, 3, 2, 3);
	}
}
