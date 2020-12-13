import java.util.Arrays;

public class OpgaverMedArrays_jbl {
    
    public OpgaverMedArrays_jbl() {
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
        int average = sumOfArray(myInts) / myInts.length;
        return average;
    }
    
    public int maxOfArray(int[] myInts) {
        // returnerer den største værdi i arrayet
        int max = myInts[0];
        for (int i = 0; i < myInts.length; i++) {
            if (max < myInts[i]) {
                max = myInts[i];
            }
        }
        return max;
    }
    
    public static void sortArray(int[] myInts) {
        // sorterer arrayet og skriver det ud
        Arrays.sort(myInts); 
        System.out.printf("Sorted array: %s", Arrays.toString(myInts)); 
    }
    
    public static void addMatrices(int[][] a, int[][] b) {
        // adder to matricer af samme størrelse og udskriv resultatet
        // tjek efterfølgende metode printMatrix for inspiration
        int rowA = a.length;
        int colB = b[0].length;

        int[][] sum_matrix = new int[rowA][colB];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                sum_matrix[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("\n");
        printMatrix(sum_matrix);
    }
    
    public static void printMatrix(int[][] m) {
         for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                System.out. print(m[i][j] + " ");
         System.out.println("\nLength "+m.length+" Width "+m[0].length);
    }
    
    public static void main(String[] args) {
        int[] myInts = {17,12,89,2,43,67,11};
        
        OpgaverMedArrays_jbl o = new OpgaverMedArrays_jbl();
        
        System.out.println("Sum of array: " + o.sumOfArray(myInts));
        System.out.println("Average of array: " + o.averageOfArray(myInts));
        System.out.println("Max of array: " + o.maxOfArray(myInts));
        sortArray(myInts);

        int[][] filter = {
            {-1, 0, 7},
            {-2, 1, 8},
            {-3, 2, 9}
        };
        int[][] filter2 = {
            {-1, 0, 7},
            {-2, 1, 8},
            {-3, 2, 9}
        };
        addMatrices(filter, filter2);
        
        //printIntegerArray(myInts);
        
        printMatrix(filter);
    }
}
