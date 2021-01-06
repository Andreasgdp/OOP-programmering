// Teoretiske emner: arrays – anvendelse, fordele og ulemper (4.16).

package Andreas;

import java.util.ArrayList;

/**
 * District
 */
public class District {
    private final String name;
    private final double pricePrM3;
    // private User[] users = new User[200];
    private final ArrayList<User> users = new ArrayList<>();
    private int numUsers;

    public District() {
        this.name = "default";
        this.pricePrM3 = 0;
    }

    public District(String name, double pricePrM3) {
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

    public double settleUser(int meterNum) {
        double returnVal = -1;
        for (User value : this.users) {
            if (value.getMeterNum() == meterNum) {
                returnVal = value.calcUsage() * this.pricePrM3;
                break;
            }
        }

        return returnVal;
    }

    public boolean userInDistrict(int meterNum) {
        for (User user : this.users) {
            if (user.getMeterNum() == meterNum) {
                return true;
            }
        }
        return false;
    }

    public User getUserInDistrict(int meterNum) {
        for (User user : this.users) {
            if (user.getMeterNum() == meterNum) {
                return user;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getMeterNums() {
        ArrayList<Integer> usersMeterNum = new ArrayList<>();
        for (User user : this.users) {
            usersMeterNum.add(user.getMeterNum());
        }
        return usersMeterNum;
    }

}