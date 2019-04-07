package javalearning.chapter4stringexample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacterAndItsCountInString {

    public static void main(String args[]){
        String providedString = "Abhaybb";
        Map<Character,Integer > duplicateCharMap = new HashMap<Character,Integer>();
        char[] stringToCharArray = providedString.toLowerCase().toCharArray();

        for(Character ch : stringToCharArray){
            if(duplicateCharMap.containsKey(ch)){
                duplicateCharMap.put(ch, duplicateCharMap.get(ch)+1);
            }else
            {
                duplicateCharMap.put(ch, 1);
            }
        }

        //printing charcter and duplicate value
        Set<Character> keys = duplicateCharMap.keySet();
        for(Character ch : keys){
          if(duplicateCharMap.get(ch) > 1)
            {
                System.out.println(ch +" is "+ duplicateCharMap.get(ch) +" Times in String");
            }
        }
    }
}