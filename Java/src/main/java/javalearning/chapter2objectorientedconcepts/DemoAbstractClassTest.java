package javalearning.chapter2objectorientedconcepts;

public class DemoAbstractClassTest {
    void display() {
        System.out.println("Adding implementation");
    }

    public static void main(String args[]){
        // DemoAbstractClass d = new DemoAbstractClass(); // not allowed, throws compilation error
        DemoAbstractClass d = new DemoAbstractClass(){

            void display() {
              System.out.println("Adding implementation");
            }
        };

        d.display();

    }
}
