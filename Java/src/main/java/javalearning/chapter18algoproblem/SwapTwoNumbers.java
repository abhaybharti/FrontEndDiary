package javalearning.chapter18algoproblem;

public class SwapTwoNumbers {
    public static void main(String args[]){
        int firstNumber = 10;
        int secondNumber = 20;

        System.out.println("Before Number is Swapped - firstNumber - "+firstNumber+ " , secondNumber - "+secondNumber);
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;

        System.out.println("After Number is Swapped - firstNumber - "+firstNumber+ " , secondNumber - "+secondNumber);
    }
}
