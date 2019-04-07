package javalearning.chapter18algoproblem;

public class FibonacciNumSeries {
    public static void main(String args[]) {
        // number of elements you want to generate in the Fibonacci Series
        int maxNumber = 10;
        int previousNumber = 0;
        int nextNumber = 1;

        System.out.println("Fibonacci Series of "+maxNumber+" numbers:");

        for (int i = 1; i <= maxNumber; ++i)
        {
            System.out.print(previousNumber+" ");

            int sum = previousNumber + nextNumber;

            //In each iteration, assign second number to the previous number
            previousNumber = nextNumber;

            //Assign the sum of last two numbers to the next number
            nextNumber = sum;
        }
    }
}
