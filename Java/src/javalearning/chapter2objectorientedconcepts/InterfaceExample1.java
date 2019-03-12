package javalearning.chapter2objectorientedconcepts;

/***
 *  1. All interface methods are implicitly public, even without public keyword methods are public and abstract
 *  2. Unless methods are declared static or default, they are public
 *  3. All variables declared in interface, must be public, static and final. Interface can only declare constants.
 *  4. interface method cannot be marked final, strictfp or native
 *  5. An interface can extend one or more other interfaces
 *  6. An interface can extend only other interface
 *  7. An interface cannot implement another interface or class
 *   ----- static interface methods
 *   8. static interface methods are declared using static keyword
 *   9. static interface methods are public by default and the public modifier is optional
 *   10. static interfac methods cannot be marked as private, protected, final or abstract
 *   11. static interface methods must have a concrete method body
 */
interface InterfaceExample1 {
    int value = 23; //this become final variable & can't modified by implementation class
    void bounce(); //abstract method, is same as public abstract void bounce();
    void setBounceFactor(int bf); //abstract method

    // static methods in interface
    static int m1(){ return 42; } //legal
    static void m2(){;} //legal
    //abstract static void m3(){;} //illegal, abstract not allowed
    //static void m5(); //illegal, needs a method body
}
