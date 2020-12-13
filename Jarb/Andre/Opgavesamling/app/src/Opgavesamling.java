import java.util.ArrayList;

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

        System.out.println("\nOPG.4 -------------------------------------------------------");

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


}
