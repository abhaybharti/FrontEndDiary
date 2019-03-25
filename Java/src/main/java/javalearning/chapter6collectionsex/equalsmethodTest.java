package javalearning.chapter6collectionsex;

public class equalsmethodTest {

    public static void main(String args[]){
        equalsmethodExamples one = new equalsmethodExamples(8);
        equalsmethodExamples two = new equalsmethodExamples(8);

        if(one.equals(two)){
            System.out.println("one and tow are equal");
        }
    }
}
