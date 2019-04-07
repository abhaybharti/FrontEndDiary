package javalearning.chapter18algoproblem;

public class FindLargestValueFromArray {
    public static void main(String[] args){
        int[] arr={20,3,22,9,17,4,23,2};

        int val=arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] > val){
                val=arr[i];
            }
        }
        System.out.println("Largest value Array is : "+ val);
    }
}
