package javalearning.chapter5flowcontrolAndException;

public class Factorial {
    public static void main(String args[]) {
        int i, fact = 1;
        //Number to calculate factorial
        int number = 3;

        //Iterate through all number upto number
        for (i = 1; i <= number; i++) {
            fact *=  i;
        }

        //Print factorial value
        System.out.println("Factorial of " + number + " is: " + fact);
    }
}
