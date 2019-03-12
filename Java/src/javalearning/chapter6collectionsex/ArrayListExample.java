package javalearning.chapter6collectionsex;

import java.util.ArrayList;
import java.util.List;

/***
   1. ArrayList class is in java.util package
   2. The ArrayList class extends AbstractList and implements the List interface
   3. ArrayList supports dynamic arrays that can grow as needed
   4. ArrayList is initialized by a size, however the size can increase if collection grows or shrunk if objects are removed from the
      collection.
   5. maintain order of elements
   6. ArrayList allows to randomly access the list.
   7. ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases.

 method -
 boolean addAll(Collection c) - Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. Throws NullPointerException, if the specified collection is null.
 boolean addAll(int index, Collection c) - Inserts all of the elements in the specified collection into this list, starting at the specified position. Throws NullPointerException if the specified collection is null.

 int lastIndexOf(Object o) - Returns the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.

 removeRange(int fromIndex, int toIndex) - Removes from this List all of the elements whose index is between fromIndex, inclusive and toIndex, exclusive.
 **/


public class ArrayListExample {
    public static void main(String args[]){
        List<String> c = new ArrayList<>();
        c.add("oslo"); // add() method adds element to the end arrayList
        c.add("paris");
        c.add("Rome");

        int index = c.indexOf("paris"); //returns index of element
        System.out.println(c + " "+ index);
        c.add(index, "London"); //add element at index point & shifts the remaining element back (e.g. what was index, is not index+1

        System.out.println(c);

        System.out.println(c.contains("paris")); // returns true/false, whether element is in arraylist

        System.out.print(c.get(index)); //returns object at index

        c.remove("paris"); // remove fist occurance of the object & shifts later elements towards the beginning one space
        c.remove(index);  // remove element at that index & shifts later elements towards the beginning one space
        System.out.println("size() : "+c.size()); //return number of elements from arrayList
        c.clear(); //remove  all element from arraylist


        System.out.println(c);

    }
}


