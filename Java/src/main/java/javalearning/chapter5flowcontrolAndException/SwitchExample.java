package javalearning.chapter5flowcontrolAndException;

public class SwitchExample {

    public static void main(String args[]){
        int x = 1;
        switch(x){
            case 1: {
                System.out.print("Inside case 1");
                break;
            }
            case 2 :{
                System.out.print("Inside case 2");
                break;
            }
            case 3:{
                System.out.print("Inside case 3");
                break;
            }
            default:
                System.out.print("Inside default case");
        }
    }
}
