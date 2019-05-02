package javalearning.chapter2objectorientedconcepts;

public class OverloadingExampleTest {
    public static void main(String args[]){
        OverloadingExample overloadingExample = new OverloadingExample();
        overloadingExample.click();
        overloadingExample.click("ButtonLocator");
    }
}
