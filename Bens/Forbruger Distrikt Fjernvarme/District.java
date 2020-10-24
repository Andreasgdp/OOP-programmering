import java.util.ArrayList;

/**
 * District
 */
public class District {
	private String name;
	private int pricePrM3;
	// private User[] users = new User[200];
	private ArrayList<User> users = new ArrayList<User>();
	private int numUsers;

	public District() {
		this.name = "default";
		this.pricePrM3 = 0;
	}

	public District(String name, int pricePrM3) {
		this.name = name;
		this.pricePrM3 = pricePrM3;
	}

	public void setUser(User user) {
		int maxNumUsers = 200;
		if (this.users.size() < maxNumUsers && this.numUsers < maxNumUsers) {
			users.add(user);
			this.numUsers++;
		} else {
			System.out.println("The district has reached it's limit in size of: " + maxNumUsers);
		}
	}

	public int settleUser(int meterNum) {
		int returnVal = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getMeterNum() == meterNum) {
				User user = users.get(i);
				returnVal = user.calcUsage() * this.pricePrM3;
				break;
			}
		}

		return returnVal;
	}

	public boolean userInDistrict(int meterNum) {
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getMeterNum() == meterNum) {
				return true;
			}
		}
		return false;
	}

	public User getUserInDistrict(int meterNum) {
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getMeterNum() == meterNum) {
				return this.users.get(i);
			}
		}
		return null;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Integer> getMeterNums() {
		ArrayList<Integer> usersMeterNum = new ArrayList<Integer>();
		for (int i = 0; i < this.users.size(); i++) {
			usersMeterNum.add(this.users.get(i).getMeterNum());
		}
		return usersMeterNum;
	}

}