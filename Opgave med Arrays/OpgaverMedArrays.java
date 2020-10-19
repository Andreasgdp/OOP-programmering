import java.util.Arrays;

public class OpgaverMedArrays {

    public OpgaverMedArrays() {
    }

    public void printStringArray() {
        String[] myStrings = new String[6];

        myStrings[0] = "this";
        myStrings[1] = "is";
        myStrings[2] = "Andy";
        myStrings[3] = "Warhol";
        myStrings[4] = "take";
        myStrings[5] = "one";

        for (int i = 0; i < myStrings.length; i++)
            System.out.println(myStrings[i]);
    }

    public static void printIntegerArray(int[] myInts) {
        for (int i = 0; i < myInts.length; i++)
            System.out.println(myInts[i]);
    }

    public int sumOfArray(int[] myInts) {
        // returnerer summen af elementerne i arrayet
        int sum = 0;
        for (int i = 0; i < myInts.length; i++) {
            sum += myInts[i];
        }
        return sum;
    }

    public int averageOfArray(int[] myInts) {
        // returnerer gennemsnitsværdien (udregnet ved heltalsdivision)
        return sumOfArray(myInts) / myInts.length;
    }

    public int maxOfArray(int[] myInts) {
        // returnerer den største værdi i arrayet
        int max = 0;
        for (int i = 0; i < myInts.length; i++) {
            if (myInts[i] > max) {
                max = myInts[i];
            }
        }
        return max;
    }

    public static void sortArray(int[] myInts) {
        // sorterer arrayet og skriver det ud
        Arrays.sort(myInts);
        System.out.printf("Modified arr[] : %s", Arrays.toString(myInts));
    }

    public static void addMatrices(int[][] a, int[][] b) {
        // adder to matricer af samme størrelse og udskriv resultatet
        // tjek efterfølgende metode printMatrix for inspiration
        int rowA = a.length;
        int colA = a[0].length;
        int rowB = b.length;
        int colB = b[0].length;

        if (rowA == rowB && colA == colB) {
            int[][] sumMatrix = new int[rowA][colB];

            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colB; j++) {
                    sumMatrix[i][j] = a[i][j] + b[i][j];
                    System.out.print(sumMatrix[i][j] + " ");
                }
            }

        } else {
            System.out.println("Matriserne er ikke af samme størrelse!");
        }

    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                System.out.print(m[i][j] + " ");
        System.out.println("\nLength " + m.length + " Width " + m[0].length);
    }

    public static void main(String[] args) {
        int[] myInts = { 17, 12, 89, 2, 43, 67, 11 };

        OpgaverMedArrays o = new OpgaverMedArrays();

        System.out.println(o.sumOfArray(myInts));

        printIntegerArray(myInts);

        int[][] filter = { { -1, 0, 7, 4 }, { -2, 1, 8, 5 }, { -3, 2, 9, 6 } };
        int[][] filter2 = { { -1, 0, 7, 4 }, { -2, 1, 8, 5 }, { -3, 2, 9, 6 } };

        addMatrices(filter, filter2);
        printMatrix(filter);

    }

}
