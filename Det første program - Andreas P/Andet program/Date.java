import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		// return ((this.date - this.getDay()) % 10000) / 100;
		// return (this.date % 10000) / 100;
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
		String month = Integer.toString(this.month);
		String day = Integer.toString(this.day);
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

	}

	public void setDateMinusOne() {

	}

	public void setNewDate(int date) {
		Date newDate = new Date(date);
		if (newDate.validDate())
			this.date = newDate.getDate();
		else
			System.out.println("The date is not valid");
	}

	public int differenceInDays(Date_test date) {
		return 1;

	}

	public int weekDay() {
		return 1;
	}
}

/*
 * class Dato { public: // Dato(); // Dato(int); // int getDatoen(); // int
 * getAar(); // int getMaaned(); // int getDag(); // int getKvartal(); void
 * setAar(int); void setMaaned(int); void setDag(int); bool skudAar(); bool
 * validDato(); // 20201711 er fx ikke valid int dagIAar(); // 10. februar er fx
 * årets 41. dag int restDageIAar(); // 25. november resterer der 36 dage i året
 * void setDatoPlusEn(); // 2019.12.31 bliver til 2020.01.01 void
 * setDatoMinusEn(); // 20191101 bliver til 20191031 void setNyDato(int); //
 * Kaldt med 27 bliver 19991217 til 20000113 int forskelIDage(Dato); //
 * Forskellen mellem 19630107 og 20200914 er 21070 int ugeDag(); // Hvis datoen
 * er en mandag returneres 1, tirsdag 2, etc. ~Dato(); private: int datoen = 0;
 * };
 */