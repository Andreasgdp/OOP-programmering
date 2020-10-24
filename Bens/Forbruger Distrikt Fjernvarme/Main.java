import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		District district = new District("The Best", 150);
		System.out.printf("In the district %s the following is present:", district.getName());
		ArrayList<String> names = new ArrayList<String>();

		names.addAll(Arrays.asList("Flemming", "Jens", "Gunner", "Bens", "Gert", "Tobias", "Frans", "Emil", "Josefine",
				"Signe", "Maria", "Anna", "Emilie"));

		Random random = new Random();

		String name;
		int meterNum;

		// create users in district
		User user = new User("test", 1203, 20000);
		district.setUser(user);
		for (int i = 0; i < 200; i++) {
			name = names.get(random.nextInt(names.size()));
			meterNum = random.nextInt(10000);
			while (district.userInDistrict(meterNum)) {
				meterNum = random.nextInt(10000);
			}
			user = new User(name, meterNum, 20000);
			district.setUser(user);
		}

		// settle users in district
		ArrayList<Integer> usersMeterNum = district.getMeterNums();
		for (int i = 0; i < usersMeterNum.size(); i++) {
			System.out.println("\nThe user: " + district.getUserInDistrict(usersMeterNum.get(i)).getName());
			System.out.println("Calc of user in district w. meterNum: " + usersMeterNum.get(i)
					+ " And a price to pay of: " + district.settleUser(usersMeterNum.get(i)));
		}

		for (int i = 0; i < usersMeterNum.size(); i++) {
			user = district.getUserInDistrict(usersMeterNum.get(i));
			user.readMeter(random.nextInt(1000));
			System.out.println("\nThe user: " + user.getName());
			System.out.println("Calc of user in district w. meterNum: " + usersMeterNum.get(i)
					+ " And a price to pay of: " + district.settleUser(usersMeterNum.get(i)));
		}
	}
}
