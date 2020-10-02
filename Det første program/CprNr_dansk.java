import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import util.Identifier;
import util.TypeTester;

public class CprNr_dansk {
	private String number;
	private int intNumber;
	private Identifier identifier;
	private TypeTester tt;
	private Date date;

	public static void main(String[] args) {
		CprNr_dansk cpr = new CprNr_dansk("0502201972");
		System.out.println(cpr.getAlder());
	}

	public CprNr_dansk(String cprNr) {
		this.tt = new TypeTester();
		this.number = cprNr;
		this.intNumber = Integer.parseInt(this.number);
		this.identifier = this.getIdentifier();
		this.date = this.getDato();
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
		int yearDiff = java.lang.Math.abs(currDate.getAar() - this.date.getAar() - 1);
		if (this.date.getMaaned() >= currDate.getMaaned() && this.date.getDag() >= currDate.getDag())
			yearDiff++;

		return yearDiff;
	}
}
