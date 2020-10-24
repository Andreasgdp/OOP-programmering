/**
 * User
 */
public class User {

	private String name;
	private int meterNum;
	private int newReading;
	private int lastReading;
	private int meterMax;

	public User() {
		this.name = "default";
		this.meterNum = 0;
		this.newReading = 0;
		this.lastReading = 0;
		this.meterMax = 0;
	}

	public User(String name, int meterNum, int meterMax) {
		this.name = name;
		this.meterNum = meterNum;
		this.meterMax = meterMax;
		this.newReading = 0;
		this.lastReading = 0;
	}

	public int getMeterNum() {
		return this.meterNum;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	public void readMeter(int userMeasurement) {
		this.lastReading = this.newReading;
		this.newReading = userMeasurement;
	}

	public int calcUsage() {
		return java.lang.Math.abs(this.newReading - this.lastReading);
	}
}