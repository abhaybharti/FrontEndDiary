package javalearning.chapter5flowcontrolAndException;


// For loop syntax
    /*for (Initialization  ;  Condition ;  Iteration )
    {
        loop body
    }*/

public class ForExample {
    ForExample(){

    }
    public static void main(String args[]){
        for (int i =0; i < 5; i++){
            System.out.println("i is - "+i);
        }

        //Integer array
        int [] number = {1,2,3,4,5};

        //Enhanced For Each loop
        System.out.println("For Each Loop");
        for (int i : number){
            System.out.println(i);
        }

        //Basic For loop
        System.out.println("Basic For Loop");
        for (int i =0; i<number.length; i++){
            System.out.println(i);
        }
    }
}
