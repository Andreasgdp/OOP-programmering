package Andreas;

import java.util.*;

public class Date {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int date;
		String lenTest;
		do {
			System.out.println("Enter a date (Format: YYYYMMDD): ");
			while (!scanner.hasNextInt()) {
				String input = scanner.next();
				System.out.printf("\"%s\" is not a valid number.\n", input);
			}
			date = scanner.nextInt();
			lenTest = Integer.toString(date);

		} while (lenTest.length() != 8);

		scanner.close();

		Date dateOb = new Date(date);

		System.out.println("\nDate: " + dateOb.getDate());
		System.out.println("Year: " + dateOb.getYear());
		System.out.println("Month: " + dateOb.getMonth());
		System.out.println("Day: " + dateOb.getDay());
		System.out.println("Quarter: " + dateOb.getQuarter());
		System.out.println("Is leap year: " + dateOb.leapYear());
		System.out.println("Is valid date: " + dateOb.validDate());
		System.out.println("Day in the year: " + dateOb.dayInYear());
		System.out.println("Days left in the year: " + dateOb.restDaysInYear());
		System.out.println("The weekday of the date '" + dateOb.getDate() + "' : " + dateOb.weekDay() + " "
				+ dateOb.weekDayName());
		Date dateTest = new Date(20000923);
		System.out.println("Days difference between '" + dateTest.getDate() + "' and '" + dateOb.getDate() + "': "
				+ dateOb.differenceInDays(dateTest));
		dateOb.setDatePlusOne();
		System.out.println("This is the new date plus one: " + dateOb.getDate());
		dateOb.setDateMinusOne();
		dateOb.setDateMinusOne();
		System.out.println("This is the new date minus one: " + dateOb.getDate());
		dateOb.setNewDate(20220506);
		System.out.println("This is the new date after setting to '20220506': " + dateOb.getDate());
		dateOb.setNewDate(20220545);
		int dateBefore = dateOb.getDate();
		int days = -20;
		dateOb.addDaysToDate(days);
		System.out.println("This is the new date after adding " + days + " to " + dateBefore + ": " + dateOb.getDate());
	}

	private int date;
	private int year;
	private int month;
	private int day;
	private List<Integer> shortMonths;
	private List<Integer> longMonths;

	// Constructor
	public Date(int date) {
		this.date = date;
		this.year = this.getYear();
		this.month = this.getMonth();
		this.day = this.getDay();

		// Short months without February
		this.shortMonths = new ArrayList<Integer>();
		this.shortMonths.addAll(Arrays.asList(4, 6, 9, 11));

		this.longMonths = new ArrayList<Integer>();
		this.longMonths.addAll(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
	}

	public int getDate() {
		return this.date;
	}

	public int getYear() {
		return this.date / 10000;
	}

	public int getMonth() {
		return (this.date / 100) % 100;
	}

	public int getDay() {
		return this.date % 100;
	}

	public int getQuarter() {
		return ((this.getMonth() - 1) / 3) + 1;
	}

	public void setYear(int year) {
		this.year = year;
		this.updateDate();
	}

	public void setMonth(int month) {
		this.month = month;
		this.updateDate();
	}

	public void setDay(int day) {
		this.day = day;
		this.updateDate();
	}

	public void updateDate() {
		String year = Integer.toString(this.year);
		String month = String.format("%02d", this.month);
		String day = String.format("%02d", this.day);
		String date = year + month + day;
		this.date = Integer.parseInt(date);
	}

	public boolean leapYear() {
		/*
		 * Det er skudår hvis årstallet er deleligt med 4. Bortset fra dem der er
		 * delelige med 100, bortset fra dem, der er delelige med 400 som alligevel er
		 * skudår.
		 */
		boolean result = false;
		if (this.year % 4 == 0)
			result = true;
		if (this.year % 100 == 0)
			result = false;
		if (this.year % 400 == 0)
			result = true;

		return result;
	}

	public boolean leapYearInput(int year) {
		/*
		 * Det er skudår hvis årstallet er deleligt med 4. Bortset fra dem der er
		 * delelige med 100, bortset fra dem, der er delelige med 400 som alligevel er
		 * skudår.
		 */
		boolean result = false;
		if (year % 4 == 0)
			result = true;
		if (year % 100 == 0)
			result = false;
		if (year % 400 == 0)
			result = true;

		return result;
	}

	public boolean validDate() {
		// Check for correct month num
		if (!(this.month <= 12 && this.month > 0))
			return false;

		// Check for dates before the start of the Gregorian calender
		if (this.date < 17000301)
			return false;

		// Their is no month with more than 31 days
		if (this.day == 0 || this.day > 31)
			return false;

		if (this.shortMonths.contains(this.month))
			return (this.day <= 30) ? true : false;
		else if (this.month == 2)
			if (this.leapYear())
				return (this.day <= 29) ? true : false;
			else
				return (this.day <= 28) ? true : false;
		else
			return true;
	}

	private int daysInMonth(int month) {
		return (this.shortMonths.contains(month)) ? ((month != 2) ? 30 : ((this.leapYear()) ? 29 : 28)) : 31;
	}

	public int dayInYear() {
		int totalDays = 0;

		for (int i = 1; i < this.month; i++) {
			totalDays += this.daysInMonth(i);
		}
		totalDays += this.day;
		return totalDays;

	}

	public int restDaysInYear() {
		int daysToSubtractFrom = (this.leapYear()) ? 366 : 365;

		return daysToSubtractFrom - this.dayInYear();

	}

	public void setDatePlusOne() {
		// Add one day to the date and go through month and year to add to if necessary
		this.day += 1;
		this.updateDate();
		if (!this.validDate()) {
			this.day = 1;
			this.month += 1;
			this.updateDate();
			if (!this.validDate()) {
				this.month = 1;
				this.year += 1;
				this.updateDate();
			}
		}
	}

	public void setDateMinusOne() {
		// Remove one day to the date and go through month and year to remove to if
		// necessary
		this.day -= 1;
		this.updateDate();
		if (!this.validDate()) {
			this.month -= 1;
			if (this.month == 0) {
				this.year -= 1;
				this.month = 12;
			}
			this.day = 31;
			this.updateDate();
			while (!this.validDate()) {
				this.day -= 1;
				this.updateDate();
			}
		}
	}

	public void setNewDate(int date) {
		Date newDate = new Date(date);
		if (newDate.validDate()) {
			this.day = newDate.getDay();
			this.year = newDate.getYear();
			this.month = newDate.getMonth();
			this.updateDate();
		} else
			System.out.println("The date " + date + " is not valid. The date is still: " + this.getDate());
	}

	public void addDaysToDate(int days) {
		if (days > 0) {
			for (int i = 0; i < days; i++) {
				this.setDatePlusOne();
			}
		} else {
			for (int i = 0; i < java.lang.Math.abs(days); i++) {
				this.setDateMinusOne();
			}
		}
	}

	private Date getFistDate(Date date) {
		return (this.getDate() < date.getDate()) ? this : date;
	}

	private Date getLastDate(Date date) {
		return (this.getDate() > date.getDate()) ? this : date;
	}

	public int differenceInDays(Date date) {
		int totalDays = 0;
		Date first = this.getFistDate(date);
		Date last = this.getLastDate(date);

		while (first.getDate() != last.getDate()) {
			first.setDatePlusOne();
			totalDays += 1;
		}

		return totalDays + 1;
	}

	public int weekDay() {
		// 1 marts år 1700 er mandag, brug % 7
		// 17170301 % 7 = 1
		Date firstDay = new Date(17000301);
		int dayDifference = this.differenceInDays(firstDay);

		switch (dayDifference % 7) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			case 0:
				return 7;

			default:
				return -1;
		}
	}

	public String weekDayName() {
		// 1 marts år 1700 er mandag, brug % 7
		// 17170301 % 7 = 1
		Date firstDay = new Date(17000301);
		int dayDifference = this.differenceInDays(firstDay);

		switch (dayDifference % 7) {
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Freitag";
			case 6:
				return "Saturday";
			case 0:
				return "Sunday";

			default:
				return "None";
		}
	}
}