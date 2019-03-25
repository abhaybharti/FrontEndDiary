package javalearning.chapter4stringexample;

public class ReverseAnArray {

    public static void main(String args[]){
        int [] array1={1, 2, 3, 4, 5};
        int arrayLenght = array1.length;
        int [] newArray = new int[arrayLenght];;
        int k = 0;
        for (int i = arrayLenght-1; i>=0; i--){
            newArray[k] = array1[i];
            k++;
        }

        for (int t =0; t < newArray.length;t++)
        System.out.println(newArray[t]);
    }
}
