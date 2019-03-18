package javalearning.chapter7polymorphism;

/***
 *  While overriding a method in child class, we can not make method more restricted. For example -
 *  if parent class has public method, we can't make private or protected method in child class
 *  yes, if parent class has protected, we can make public in child class
 */


public class B extends A{

    public void getTest(){
        System.out.println("Inside child class ");
    }

    private void getTest(int a){
        System.out.println("Inside child class " + a);
    }

    public static void main(String args[]){
        A a = new A();
        a.getTest();
        a = new B();
        a.getTest();


        B b = new B();
        int c = 5;
        b.getTest(c);
        b.getTest();
    }
}
