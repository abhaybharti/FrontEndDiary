package javalearning.chapter2objectorientedconcepts;

public class OverloadingExample {
    public void click(){
        System.out.println("click()");
    }
    public void click(String locator){
        System.out.println("click() -> by locator");
    }
}
