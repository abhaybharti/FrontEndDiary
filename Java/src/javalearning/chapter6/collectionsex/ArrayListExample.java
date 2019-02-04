package javalearning.chapter6.collectionsex;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String args[]){
        List<String> c = new ArrayList<>();
        c.add("oslo"); // add() method adds value in arrayList, element get added at last position
        c.add("paris");
      //  c.add("Rome");

        int index = c.indexOf("paris"); //returns index of element
        System.out.println(c + " "+ index);
        c.add(index, "London"); //add element at specified index
        System.out.println(c);
    }
}



/***
 *  ArrayList class is in java.util package
 *  ArrayList class implements the List interface
 **/