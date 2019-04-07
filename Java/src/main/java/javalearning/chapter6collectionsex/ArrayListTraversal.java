package javalearning.chapter6collectionsex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTraversal {

    public static void main(String args[]){
        // initializing ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add( 5);
        numbers.add( 6);
        numbers.add( 7);
        numbers.add(8);

        System.out.println("Iterating arrayList using for loop : ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }


        System.out.println();
        System.out.println("Using For Each Loop :");

        for (Integer i : numbers) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Looping ArrayList using Iterator :");
        Iterator it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
