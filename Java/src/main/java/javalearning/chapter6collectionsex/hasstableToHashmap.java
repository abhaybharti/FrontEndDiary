package javalearning.chapter6collectionsex;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class hasstableToHashmap {
    public static void main(String args[]) {

        //----------hashtable -------------------------
        Hashtable<Integer, String> htEx = new Hashtable<Integer, String>();
        htEx.put(101, "akash");
        htEx.put(101, "Vikash"); //does not allow duplicate key
        htEx.put(102, "Raji");
        htEx.put(103, "Rahul");
        htEx.put(104, "Rahul"); //allows duplicate values
        System.out.println("-------------Print Hash table values--------------");
        for (Map.Entry m : htEx.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //----------------hashmap--------------------------------
        HashMap<Integer, String> hmEx = new HashMap<Integer, String>();
        hmEx.put(100, "Ajit");
        hmEx.put(100, "Ajit"); //does not allow duplicate key
        hmEx.put(104, "Ajit");  //hash map allows duplicate values
        hmEx.put(101, "Vikay");
        hmEx.put(102, "Rahul");
        System.out.println("-----------Print Hash map values-----------");
        for (Map.Entry m : hmEx.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}