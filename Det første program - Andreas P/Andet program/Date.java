public class Date 
{
	private int date;

	public Date() {

	}

	public Dato(int aDate) {
		date = aDate; // Format: YYYYMMDD
		dateString = Integer.toString(date);
	}

	public int getDate() {
		return date;
	}

	public int getYear() {
		return date / 10000;
	}

	public int getMonth()
	{
		first = dateString.charAt(4);
		second = dateString.charAt(5);
		month = Integer.parseInt(first + second);

		return month;
	}

	// public int getDay()
	// {
	// 	return
	// }

	// public int getKvartal()
	// {
	// 	return
	// }

	public static void main(String[] args) {
		Date date = new Date(20200907);
		System.out.println(date.getMonth());
	}
}

