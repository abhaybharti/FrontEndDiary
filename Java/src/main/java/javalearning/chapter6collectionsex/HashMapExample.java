package javalearning.chapter6collectionsex;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        print(map);
        map.put("Ajay", 10);
        map.put("Alex", 30);
        map.put("Vijay", 20);
        System.out.println("Size of map is: " + map.size());
        print(map);
        if (map.containsKey("Vijay")) {
            Integer a = map.get("Vijay");
            System.out.println("value for key is:- " + a);
        }

        map.clear();
        print(map);
    }

    public static void print(Map<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("map is empty");
        } else {
            System.out.println(map);
        }
    }

}
