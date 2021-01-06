// Teoretiske emner: arrays – anvendelse, fordele og ulemper (4.16).

package Andreas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		District district = new District("The Best", 54);
		System.out.printf("In the district %s the following is present:", district.getName());

		ArrayList<String> names = new ArrayList<String>(Arrays.asList("Flemming", "Jens", "Gunner", "Bens", "Gert", "Tobias", "Frans", "Emil", "Josefine",
				"Signe", "Maria", "Anna", "Emilie", "Preben"));

		Random random = new Random();

		String name;
		int meterNum;

		// create users in district
		User user = new User("test", 1203, 500);
		district.setUser(user);
		for (int i = 0; i < 200; i++) {
			name = names.get(random.nextInt(names.size()));
			do {
				meterNum = random.nextInt(10000);
			} while (district.userInDistrict(meterNum));
			user = new User(name, meterNum, 500);
			district.setUser(user);
		}

		// settle users in district
		ArrayList<Integer> usersMeterNum = district.getMeterNums();
		for (Integer integer : usersMeterNum) {
			System.out.println("\nThe user: " + district.getUserInDistrict(integer).getName());
			System.out.println("Calc of user in district w. meterNum: " + integer
					+ ", usage: " + user.calcUsage() + " m^3 water. The price to pay of: " + district.settleUser(integer) + " kr.");
		}

		for (Integer integer : usersMeterNum) {
			user = district.getUserInDistrict(integer);
			user.readMeter(random.nextInt(50));
			user.readMeter(random.nextInt(50));
			System.out.println("\nThe user: " + user.getName());
			System.out.println("Calc of user in district w. meterNum: " + integer
					+ ", usage: " + user.calcUsage() + " m^3 water. The price to pay of: " + district.settleUser(integer) + " kr.");
		}
	}
}
