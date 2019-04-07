package javalearning.chapter6collectionsex;

public class ArrayExample {

    public static void main(String[] args) {
        // Step 1: declaration:
        int[] arrayOne;

        // Step 2: Array creation:
        arrayOne = new int[3];

        // Step 3: Array initialization:
        arrayOne[0] = 1;
        arrayOne[1] = 2;
        arrayOne[2] = 3;

        // Lets see how many elements are present in array
        System.out.println("size of array is ===" + arrayOne.length);

        // Printing individual value using index example lets print value
        System.out.println("Value present on 4th place is " + arrayOne[1]);

        // Printing all values of array using index
        for (int i = 0; i <= arrayOne.length; i++) {
            System.out.println("Value sitted at index= " + i + " is "
                    + arrayOne[i]);
        }

        // Second type of array initialization
        int[] array1 = {2, 4, 5, 6, 10, 12, 13};
        System.out.println("size of array is ===" + arrayOne.length);

        // example of taking the max value of interator i.e. the size of array
        for (int j = 0; j < array1.length; j++) {
            System.out.println("Value sitted at index= " + j + " is "
                    + array1[j]);
        }
    }
}


