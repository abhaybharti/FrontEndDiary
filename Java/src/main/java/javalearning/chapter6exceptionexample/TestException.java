package javalearning.chapter6exceptionexample;

public class TestException {
    public static void main(String args[]){
        try{
            throw new UserDefinedException(100);
            // throw is used to create a new exception and throw it.
        }
        catch(UserDefinedException e){
            System.out.println(e) ;
        }
    }
}
