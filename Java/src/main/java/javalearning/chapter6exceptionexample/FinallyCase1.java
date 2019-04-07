package javalearning.chapter6exceptionexample;

public class FinallyCase1 {
    public static void main(String args[]){
        try{
            int number=30/5;
            System.out.println(number);
        }
        catch(NullPointerException e){
            System.out.println(e);
        }
        finally{
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}
