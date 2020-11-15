import java.util.ArrayList;
import java.util.Arrays;

public class Opgavesamling {

    public Opgavesamling() {

    }

    public static void main(String[] args) {
        Opgavesamling opg = new Opgavesamling();
        opg.kvadNum();
        opg.potensNum();
        System.out.println(opg.neighbors("hsgafkroduitjsla"));
        System.out.println(opg.neighbors("krstuoinnaqwlp"));
        int[] arr = new int[] {17,29,512,58,43};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));
        arr = new int[] {46,39,18,15,21};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));
        arr = new int[] {45,29,31,58,99};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));

    }

    // OPG1 ------------------------------------------------------------------------------------------------------------

    public void kvadNum() {
        ArrayList<ArrayList<Integer>> possibilityList = new ArrayList<>();
        possibilityList.add(new ArrayList<>(Arrays.asList(1, 99, 100)));
        for (int i = 1; i < 99; i++) {
            for (int j = 0; j < 50; j++) {
                if ((i + j) <= 100) {
                    possibilityList.add(new ArrayList<>(Arrays.asList(i, j, (i + j))));
                }
            }
        }

        for (ArrayList<Integer> integers : possibilityList) {
            System.out.println(integers.get(0) + " + " + integers.get(1) + " = " + integers.get(2));
        }
    }


    // OPG1 ------------------------------------------------------------------------------------------------------------
    // OPG2 ------------------------------------------------------------------------------------------------------------
    public void potensNum() {
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> potensList = new ArrayList<>();
        long potensNum = 0;
        for (int i = 1; i <= 1000; i++) {
            String numStr = Integer.toString(i);

            for (int j = 0; j < numStr.length(); j++) {
                int num = Character.getNumericValue(numStr.charAt(j));
                numList.add(num);
            }

            for (int j = 0; j < numList.size(); j++) {
                potensNum += Math.pow(numList.get(j), j + 1);
            }

            if (i == potensNum) {
                potensList.add(i);
            }

            potensNum = 0;
            numList = new ArrayList<>();

        }
        for (Integer integer : potensList) {
            System.out.println(integer);
        }
    }

    // OPG2 ------------------------------------------------------------------------------------------------------------
    // OPG3 ------------------------------------------------------------------------------------------------------------
    public boolean neighbors(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> checkAlphabetPairs = new ArrayList<>();
        for (int i = 0; i < alphabet.length(); i++) {
            if (!(i == alphabet.length() - 1)) {
                String pair = alphabet.charAt(i) + String.valueOf(alphabet.charAt(i + 1));
                checkAlphabetPairs.add(pair);
            }
        }

        ArrayList<String> checkPairs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!(i == s.length() - 1)) {
                String pair = s.charAt(i) + String.valueOf(s.charAt(i + 1));
                checkPairs.add(pair);
            }
        }

        for (String pair : checkAlphabetPairs) {
            if (checkPairs.contains(pair)) {
                return true;
            }
        }

        return false;
    }
    // OPG3 ------------------------------------------------------------------------------------------------------------
    // OPG4 ------------------------------------------------------------------------------------------------------------
    public boolean sumOfTwoEqualsThird(int[] arr) {

        for (int elm1 : arr) {
            for (int elm2 : arr) {
                if (contains(arr, (elm1 + elm2)) && !(elm1 == elm2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    // OPG4 ------------------------------------------------------------------------------------------------------------


}
