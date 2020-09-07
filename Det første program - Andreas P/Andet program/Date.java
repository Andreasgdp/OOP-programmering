public class Date {
	public static void main(String[] args) {
		Date date = new Date(20200907);
		System.out.println(date.getMonth());
	}

	private int date;
	private String dateString;

	public Date(int i) {

	}

	public void Dato(int aDate) {
		date = aDate; // Format: YYYYMMDD
		dateString = Integer.toString(date);
	}

	public int getDate() {
		return date;
	}

	public int getYear() {
		return date / 10000;
	}

	public int getMonth() {
		String first = String.valueOf(dateString.charAt(4));
		String second = String.valueOf(dateString.charAt(5));
		String month = first + second;
		int monthNumber = Integer.parseInt(month);

		return monthNumber;
	}

	// public int getDay()
	// {
	// return
	// }

	// public int getKvartal()
	// {
	// return
	// }

}
