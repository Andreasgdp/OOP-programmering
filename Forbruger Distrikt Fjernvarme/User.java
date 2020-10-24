/**
 * User
 */
public class User {

	private String name;
	private int measureNum;
	private int newReading;
	private int lastReading;
	private int meterMax;

	public User() {
		this.name = "default";
		this.measureNum = 0;
		this.newReading = 0;
		this.lastReading = 0;
		this.meterMax = 0;
	}

	public User(String name, int measureNum, int newReading, int lastReading, int meterMax) {
		this.name = name;
		this.measureNum = measureNum;
		this.newReading = newReading;
		this.lastReading = lastReading;
		this.meterMax = meterMax;
	}

	public int getMeasureNum() {
		return this.measureNum;
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