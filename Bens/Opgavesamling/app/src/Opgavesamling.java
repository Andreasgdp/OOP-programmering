import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Opgavesamling {

    public Opgavesamling() {

    }

    public static void main(String[] args) {
        Opgavesamling opg = new Opgavesamling();
        // OPG1---------------------------------------------------------------------------------------------------------
        System.out.println("OPG1-------------------------------------------------------------------------------------");
        opg.kvadNum();
        // OPG1---------------------------------------------------------------------------------------------------------

        // OPG2---------------------------------------------------------------------------------------------------------
        System.out.println("OPG2-------------------------------------------------------------------------------------");
        opg.potensNum();
        // OPG2---------------------------------------------------------------------------------------------------------

        // OPG3---------------------------------------------------------------------------------------------------------
        System.out.println("OPG3-------------------------------------------------------------------------------------");
        System.out.println(opg.neighbors("hsgafkroduitjsla"));
        System.out.println(opg.neighbors("krstuoinnaqwlp"));
        // OPG3---------------------------------------------------------------------------------------------------------

        // OPG4---------------------------------------------------------------------------------------------------------
        System.out.println("OPG4-------------------------------------------------------------------------------------");
        int[] arr = new int[]{17, 29, 512, 58, 43};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));
        arr = new int[]{46, 39, 18, 15, 21};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));
        arr = new int[]{45, 29, 31, 58, 99};
        System.out.println(Arrays.toString(arr));
        System.out.println(opg.sumOfTwoEqualsThird(arr));
        // OPG4---------------------------------------------------------------------------------------------------------

        // OPG5---------------------------------------------------------------------------------------------------------
        System.out.println("OPG5-------------------------------------------------------------------------------------");
        System.out.println(opg.isPalindrom("arr"));
        System.out.println(opg.isPalindrom("mellem"));
        System.out.println(opg.isPalindrom("otto"));
        System.out.println(opg.isPalindrom("kajak"));
        System.out.println(opg.isPalindrom("en af dem der tit red med fane"));
        System.out.println(opg.isPalindrom("en af dem der tit red med fanes"));
        // OPG5---------------------------------------------------------------------------------------------------------

        // OPG6---------------------------------------------------------------------------------------------------------
        System.out.println("OPG6-------------------------------------------------------------------------------------");
        System.out.println(opg.checkRegisterNum("MA39604"));
        System.out.println(opg.checkRegisterNum("KD47612"));
        System.out.println(opg.checkRegisterNum("KD476123"));
        System.out.println(opg.checkRegisterNum("K247612"));
        System.out.println(opg.checkRegisterNum("KD4d612"));
        // OPG6---------------------------------------------------------------------------------------------------------
        // OPG7---------------------------------------------------------------------------------------------------------
        System.out.println("OPG7-------------------------------------------------------------------------------------");
        System.out.println(opg.areBracketsBalanced("(())()"));
        System.out.println(opg.areBracketsBalanced("()()((()))"));
        System.out.println(opg.areBracketsBalanced("()())"));
        System.out.println(opg.areBracketsBalanced(")(()()"));
        // OPG7---------------------------------------------------------------------------------------------------------
        // OPG8---------------------------------------------------------------------------------------------------------
        System.out.println("OPG8-------------------------------------------------------------------------------------");
        opg.numBiggerNum();
        // OPG8---------------------------------------------------------------------------------------------------------
        // OPG9---------------------------------------------------------------------------------------------------------
        System.out.println("OPG9-------------------------------------------------------------------------------------");
        StringTokenizer tokenizer = new StringTokenizer("abc def ghi", " ,.");
        System.out.println(tokenizer.numChars());
        System.out.println(tokenizer.containsDoubleDelim());
        tokenizer = new StringTokenizer("abc def,, ghi", " ,.");
        System.out.println(tokenizer.containsDoubleDelim());
        // OPG9---------------------------------------------------------------------------------------------------------
        // OPG10---------------------------------------------------------------------------------------------------------
        System.out.println("OPG10------------------------------------------------------------------------------------");
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(opg.sumOfTwoEqualsX(arr, 4));
        System.out.println(opg.sumOfTwoEqualsX(arr, 100));

        arr = new int[]{6, 8, 14, 84, 299};
        System.out.println(opg.sumOfTwoEqualsX(arr, 4));
        System.out.println(opg.sumOfTwoEqualsX(arr, 14));
        // OPG10---------------------------------------------------------------------------------------------------------

    }

    private static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    // OPG1 ------------------------------------------------------------------------------------------------------------
    private boolean isInteger(double number) {
        return number % 1 == 0;// if the modulus(remainder of the division) of the argument(number) with 1 is 0 then return true otherwise false.
    }

    public void kvadNum() {
        ArrayList<ArrayList<Integer>> possibilityList = new ArrayList<>();
        possibilityList.add(new ArrayList<>(Arrays.asList(1, 99, 100)));
        for (int i = 1; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                String number = i + Integer.toString(j);
                if (isInteger(Math.sqrt(Integer.parseInt(number)))) {
                    if (j >= i && (i + j) <= 100) {
                        possibilityList.add(new ArrayList<>(Arrays.asList(i, j, (i + j))));
                    } else {
                        break;
                    }
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

    // OPG4 ------------------------------------------------------------------------------------------------------------
    // OPG5 ------------------------------------------------------------------------------------------------------------
    public boolean isPalindrom(String text) {
        if (text.contains(" ")) {
            text = text.replaceAll("\\s+", "");
        }
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    // OPG5 ------------------------------------------------------------------------------------------------------------
    // OPG6 ------------------------------------------------------------------------------------------------------------
    public boolean checkRegisterNum(String num) {
        if (num.length() != 7) {
            return false;
        }

        for (int i = 0; i < 2; i++) {
            char ch = num.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                return false;
            }
        }

        for (int i = 2; i < 7; i++) {
            char ch = num.charAt(i);
            if (!(Character.isDigit(ch))) {
                return false;
            }
            if (ch == 0) {
                return false;
            }
        }

        return true;
    }

    // OPG6 ------------------------------------------------------------------------------------------------------------
    // OPG7 ------------------------------------------------------------------------------------------------------------
    // https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
    public boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
    // OPG7 ------------------------------------------------------------------------------------------------------------
    // OPG8 ------------------------------------------------------------------------------------------------------------
    public void numBiggerNum() {
        int biggerCounter = 0;

        for (int i = 100000; i < 999999; i++) {
            String numStr = Integer.toString(i);
            int currNum = 0;
            for (int j = 0; j < numStr.length(); j++) {
                if (j > currNum) {
                    currNum = j;
                } else {
                    continue;
                }
                biggerCounter++;

            }
        }
        System.out.println("Der findes " + biggerCounter + " af 6-cifrede tal, hvor hver ciffer er større end det foregående");
    }

    // OPG8 ------------------------------------------------------------------------------------------------------------
    // OPG10 -----------------------------------------------------------------------------------------------------------
    public boolean sumOfTwoEqualsX(int[] arr, int x) {

        ArrayList<ArrayList<Integer>> sumCompinations = new ArrayList<>();
        for (int j : arr) {
            for (int k : arr) {
                if (j != k) {
                    sumCompinations.add((new ArrayList<>(Arrays.asList(j, k))));
                }
            }
        }
        for (ArrayList<Integer> pair : sumCompinations) {
            if (pair.get(0) + pair.get(1) == x) {
                return true;
            }
        }


        return false;
    }
    // OPG10 -----------------------------------------------------------------------------------------------------------


}
