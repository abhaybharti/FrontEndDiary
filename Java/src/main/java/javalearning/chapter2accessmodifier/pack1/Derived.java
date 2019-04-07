package javalearning.chapter2accessmodifier.pack1;

public class Derived extends Base {

    public void show() {
        new Base().display();//Compilation Error ew Base().display(); is not direct inheritance and a protected method can only be access by object of same package and since instance is being created in another package so Protected method can not be accessed.
        display(); //valid call
        new Derived().display(); //valid call Second way of using the protected method in Derived Class is to call the instance of Derived class to access the protected method of its Superclass Base.
    }
}
