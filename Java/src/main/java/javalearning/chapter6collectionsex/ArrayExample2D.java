package javalearning.chapter6collectionsex;

public class ArrayExample2D {
    public static void main(String[] args) {

        System.out.println("=============2 Diemensional Array Example=========");
        // Step 1: declaration:
        int array2D[][] = null;

        // Step 2: Array creation:
        array2D = new int[2][2];

        // Step 3: Initialization:
        array2D[0][0] = 2;
        array2D[0][1] = 3;
        array2D[1][0] = 4;
        array2D[1][1] = 5;

        //Printing all values
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Value at index= " + i + j + " is  "
                        + array2D[i][j]);
            }
        }

        System.out.println("=============3 Diemensional Array Example=========");
        int[][][] array3D = {{{1, -2, 3},{2, 3, 4}},{{-4, -5, 6, 9},{1},{2, 3}}};

        // for..each loop to iterate through elements of 3d array
        for (int[][] array2Dtmp: array3D) {
            for (int[] array1D: array2Dtmp) {
                for(int item: array1D) {
                    System.out.println(item);
                }
            }
        }

    }
}


