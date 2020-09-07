public class Date {
	public static void main(String[] args) {
		Date dateOb = new Date(20200907);
		System.out.println(dateOb.getMonth(dateOb.getDate()));
	}

	private int date;
	private String dateString;

	// Constructor
	public Date(int date) {
		this.date = date;
		this.dateString = Integer.toString(date);
	}

	public int getDate() {
		return this.date;
	}

	public int getYear() {
		return this.date / 10000;
	}

	public int getMonth(int date) {
		String first = String.valueOf(this.dateString.charAt(4));
		String second = String.valueOf(this.dateString.charAt(5));
		String month = first + second;
		int monthNumber = Integer.parseInt(month);

		return monthNumber;
	}

	public int getDay() {
		String first = String.valueOf(this.dateString.charAt(6));
		String second = String.valueOf(this.dateString.charAt(7));
		String day = first + second;
		int dayNumber = Integer.parseInt(day);

		return dayNumber;
	}

	public int getQuarter() {
		int quarter = 0;

		if (this.getMonth(this.date) <= 3) {
			quarter = 1;
		} else if (this.getMonth(this.date) <= 6) {
			quarter = 2;
		} else if (this.getMonth(this.date) <= 9) {
			quarter = 3;
		} else {
			quarter = 4;
		}

		return quarter;
	}

}