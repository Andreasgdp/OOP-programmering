import java.util.Scanner;

public class Date_input {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a date (Format: YYYYMMDD): ");
		int date = input.nextInt();
		String lenTest = Integer.toString(date);
		while (lenTest.length() != 8) {
			System.out.println("Enter a date (Format: YYYYMMDD): ");
			date = input.nextInt();
			lenTest = Integer.toString(date);
		}
		input.close();
		Date_input dateOb = new Date_input(date);

		System.out.println("Date: " + dateOb.getDate());
		System.out.println("Year: " + dateOb.getYear());
		System.out.println("Month: " + dateOb.getMonth());
		System.out.println("Day: " + dateOb.getDay());
		System.out.println("Quarter: " + dateOb.getQuarter());
	}

	private int date;

	// Constructor
	public Date_input(int date) {
		this.date = date;
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
		return ((this.getMonth()-1)/3) + 1;
	}

}