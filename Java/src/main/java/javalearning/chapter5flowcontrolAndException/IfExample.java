package javalearning.chapter5flowcontrolAndException;

public class IfExample {
    public static void main(String args[]){
        int x =2;

        //Simple if statement
        if (x < 3){
            System.out.println("Inside if statement");
        }

        //if, Else statement
        if (x > 3){
            System.out.println("Inside if statement");
        }else{
            System.out.println("Inside else block");
        }

        //if, Else if, else statement
        if (x > 3) {
            System.out.println("Inside if statement");
        }else if (x < 3){
            System.out.println("Inside if else statement");
        }else{
            System.out.println("Inside else block");
        }

        //nested if else statement
        if (x < 3){
            if (x == 2){
                System.out.println("Inside nested if block");
            }else{
                System.out.println("Inside nested else block");
            }
        }
    }
}
