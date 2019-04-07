package javalearning.chapter4stringexample;

public class ReplaceString {
    public static void main(String args[]) {
        String str = "I use webdriver. WebDriver is a tool for browser automation.";
        String toBeReplaced = "selenium";
        String toReplacedWith = "Firefox";
        System.out.println("Original String :- "+str);
        System.out.println("Replaced String :- "+str.replace("webdriver","Chrome"));
    }
}
