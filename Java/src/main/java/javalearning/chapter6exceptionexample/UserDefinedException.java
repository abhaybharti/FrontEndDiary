package javalearning.chapter6exceptionexample;

public class UserDefinedException extends Exception {
    int counter;

    UserDefinedException(int errorCount) {
        counter = errorCount;
    }

    public String toString(){
        return ("Exception Counter =  "+counter) ;
    }
}
