package javalearning.chapter18algoproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateCharacterInString {

    public static void main(String args[]) {
        //String value
        String strValue = "BPharatB";

        //Create a HashMap object
        Map<Character,Integer > duplicateCharMap = new HashMap<Character,Integer>();

        //store string value to character array
        char[] stringToCharArray = strValue.toLowerCase().toCharArray();

        //iterate character array
        for(Character c : stringToCharArray){
            if(duplicateCharMap.containsKey(c)){
                //increment count in hashmap
                duplicateCharMap.put(c, duplicateCharMap.get(c)+1);
            }else
            {
                //add in hashmap
                duplicateCharMap.put(c, 1);
            }
        }

        //printing character and repeat count
        Set<Character> keys = duplicateCharMap.keySet();
        for(Character ch : keys){
            //if char count is more than 1 then only print
            if(duplicateCharMap.get(ch) > 1)
            {
                System.out.println(ch +" is "+ duplicateCharMap.get(ch) +" repeated in String");
            }
        }
    }
}
