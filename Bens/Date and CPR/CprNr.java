import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import util.Identifier;

public class CprNr {
	private String number;
	private int intNumber;
	private Identifier identifier;
	private Date date;
	private List<Integer> cprWeights;

	public static void main(String[] args) {
		CprNr cpr = new CprNr("0502201972");
		System.out.println(cpr.getAge());
		System.out.println(cpr.isValid());
	}

	public CprNr(String cprNr) {
		this.number = cprNr;
		this.intNumber = Integer.parseInt(this.number);
		this.identifier = this.getIdentifier();
		this.date = this.getDate();
		this.cprWeights = new ArrayList<Integer>();
		this.cprWeights.addAll(Arrays.asList(4, 3, 2, 7, 6, 5, 4, 3, 2, 1));
	}

	private Identifier getIdentifier() {
		return new Identifier(this.intNumber);
	}

	private Date getDate() {
		Date date = new Date(17000301);
		date.setDay(this.getDay());
		date.setMonth(this.getMonth());
		date.setYear(this.getYear());
		return date;
	}

	public String getCprNr() {
		return this.number;
	}

	public void setCprNr(String cprNr) {
		this.number = cprNr;
	}

	private Date getCurrDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
		LocalDateTime now = LocalDateTime.now();

		return new Date(Integer.parseInt(dtf.format(now)));
	}

	public int getDay() {
		return this.intNumber / 100000000;
	}

	public int getMonth() {
		return (this.intNumber / 1000000) % 100;
	}

	public int getYear() {
		String lastDigitsYear = String.format("%02d", (this.intNumber / 10000) % 100);
		String firstDigitsYear = "00";
		String stringYear;
		int year;
		int value = this.identifier.first;
		if (value >= 0 && value <= 3)
			firstDigitsYear = "19";
		else if (value >= 4 && value <= 5)
			firstDigitsYear = "18";
		else if (value >= 6 && value <= 9)
			firstDigitsYear = "20";

		stringYear = firstDigitsYear + lastDigitsYear;
		year = Integer.parseInt(stringYear);

		return year;
	}

	public int getAge() {
		Date currDate = this.getCurrDate();
		int yearDiff = java.lang.Math.abs(currDate.getYear() - this.date.getYear() - 1);

		if (this.date.getMonth() < currDate.getMonth()
				|| (this.date.getMonth() == currDate.getMonth() && this.date.getDay() <= currDate.getDay()))
			yearDiff++;

		return yearDiff;
	}

	public boolean isMan() {
		return (this.identifier.fourth % 2 == 1) ? true : false;
	}

	public boolean isWoman() {
		return !this.isMan();
	}

	private boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private int calcWeightCPR(String cprNr) {
		int counter = 0;
		for (int i = 0; i < cprNr.length(); i++) {
			int num = Character.getNumericValue(cprNr.charAt(i));
			num *= this.cprWeights.get(i);
			counter += num;
		}
		return counter;
	}

	public boolean isValid() {
		return (this.number.length() == 10 && this.isNumeric(this.number) && this.date.validDate()
				&& this.calcWeightCPR(this.number) % 11 == 0) ? true : false;
	}
}
