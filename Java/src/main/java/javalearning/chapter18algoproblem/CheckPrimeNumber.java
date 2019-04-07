package javalearning.chapter18algoproblem;

public class CheckPrimeNumber {

    static boolean isPrime(int number) {
        // Corner case
        if (number <= 1) {
            return false;
        }

        // Check from 2 to n-1
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (isPrime(17))
            System.out.println("Prime Number");
        else
            System.out.println("Not a Prime Number");
    }
}
