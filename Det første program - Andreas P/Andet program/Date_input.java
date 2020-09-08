import java.util.Scanner;

public class Date_input {
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
		return ((this.getMonth() - 1) / 3) + 1;
	}

}