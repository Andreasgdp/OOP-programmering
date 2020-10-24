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
		if (this.users.size() <= 200) {
			users.add(user);
		} else {
			System.out.println("The district has reached it's limit in size!");
		}
	}

	public int settleUser(int measureNum) {
		
	}

}