import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import util.Identifier;
import util.TypeTester;

public class CprNr_dansk {
	private String number;
	private int intNumber;
	private Identifier identifier;
	private TypeTester tt;
	private Date date;
	private List<Integer> cprWeights;

	public static void main(String[] args) {
		CprNr_dansk cpr = new CprNr_dansk("0502201972");
		System.out.println(cpr.erValid());
	}

	public CprNr_dansk(String cprNr) {
		this.tt = new TypeTester();
		this.number = cprNr;
		this.intNumber = Integer.parseInt(this.number);
		this.identifier = this.getIdentifier();
		this.date = this.getDato();
		this.cprWeights = new ArrayList<Integer>();
		this.cprWeights.addAll(Arrays.asList(4, 3, 2, 7, 6, 5, 4, 3, 2, 1));
	}

	private Identifier getIdentifier() {
		return new Identifier(this.intNumber);
	}

	private Date getDato() {
		Date date = new Date(17000301);
		date.setDay(this.getDag());
		date.setMonth(this.getMaaned());
		date.setYear(this.getAar());
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

	public int getDag() {
		return this.intNumber / 100000000;
	}

	public int getMaaned() {
		return (this.intNumber / 1000000) % 100;
	}

	public int getAar() {
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

	public int getAlder() {
		Date currDate = this.getCurrDate();
		int yearDiff = java.lang.Math.abs(currDate.getYear() - this.date.getYear() - 1);
		if (this.date.getMonth() < currDate.getMonth() || (this.date.getMonth() == currDate.getMonth() && this.date.getDay() <= currDate.getDay()))
			yearDiff++;

		return yearDiff;
	}

	public boolean erMand() {
		return (this.identifier.fourth % 2 == 1) ? true : false;
	}

	public boolean erKvinde() {
		return (this.identifier.fourth % 2 != 1) ? true : false;
	}

	private boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private int calcWeightCPR(String cprNr) {
		int counter = 0;
		for (int i = 0; i < cprNr.length(); i++){
			int num = Character.getNumericValue(cprNr.charAt(i));
			num *= this.cprWeights.get(i);
			counter += num;
		}
		return counter;
	}

	public boolean erValid() {
		return (this.number.length() == 10 && this.isNumeric(this.number) && this.date.validDate() && this.calcWeightCPR(this.number) % 11 == 0) ? true : false;
	}
}
