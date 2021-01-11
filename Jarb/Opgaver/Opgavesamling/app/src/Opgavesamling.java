import java.util.ArrayList;
import java.util.Arrays;

public class Opgavesamling {

    public Opgavesamling() {

    }

    public static void main(String[] args) {
        Opgavesamling opg = new Opgavesamling();
        System.out.println("OPG.1 -------------------------------------------------------");
        System.out.println("De specielle kvadrattal: " + opg.specielleKvadrattal(1, 100));

        System.out.println("\nOPG.2 -------------------------------------------------------");
        System.out.println("De specielle positionstal: " + opg.speciellePositionstal(0, 1000));

        System.out.println("\nOPG.3 -------------------------------------------------------");
        System.out.println("Indeholder nabobogstaver: " + opg.neighbors("aceghjlnp"));

        System.out.println("\nOPG.4 -------------------------------------------------------");
        System.out.println("Indeholder summen af to lig en tredje: " + opg.sumOfTwoEqualsThrid(new int[]{46,39,18,15,21}));

        System.out.println("\nOPG.5 -------------------------------------------------------");

        System.out.println("\nOPG.6 -------------------------------------------------------");

        System.out.println("\nOPG.7 -------------------------------------------------------");

        System.out.println("\nOPG.8 -------------------------------------------------------");

        System.out.println("\nOPG.9 -------------------------------------------------------");

        System.out.println("\nOPG.10 -------------------------------------------------------");

    }

    public ArrayList<Integer> specielleKvadrattal(int start, int slut) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        int count = 0;
        for (int i = start; i < slut; i++) {
            long kvadrattal = Math.round(Math.pow(i, 2));
            count++;
            if (kvadrattal > 10) {
                String kvadrattalString = String.valueOf(kvadrattal);
                int mid = (int) Math.ceil(kvadrattalString.length() / 2D);
                String[] stringParts = {kvadrattalString.substring(0, mid), kvadrattalString.substring(mid)};
                if (Integer.parseInt(stringParts[0]) + Integer.parseInt(stringParts[1]) == i) {
                    returnList.add(i);
                }
            }
        }
        return returnList;
    }

    public ArrayList<Integer> speciellePositionstal(int start, int slut) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i = start; i < slut; i++) {
            double result = 0;
            String num = String.valueOf(i);
            char[] digits = num.toCharArray();
            for (int j = 0; j < digits.length; j++) {
                result += Math.pow(Character.getNumericValue(digits[j]), j + 1);
            }
            if (i == result) {
                returnList.add(i);
            }
        }
        return returnList;
    }

    public boolean neighbors(String s) {
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        if (s.length() == 1)
            return false;
        for (int i = 0; i < alfabet.length() - 1; i++) {
            String alfabetPart = alfabet.substring(i, i + 2);
            for (int j = 0; j < s.length() - 1; j++) {
                if (alfabetPart.equals(s.substring(j,j + 2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sumOfTwoEqualsThrid(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sumOfTwo = arr[i] + arr[j];
                if (Arrays.stream(arr).anyMatch(f -> f == sumOfTwo) && i != j) {
                    return true;
                }

            }
        }
        return false;
    }

}
