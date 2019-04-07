package javalearning.chapter18algoproblem;

public class ReverseWordsInSentence {
    public static void main(String args[]){
        //Sample string
        String stringToReverse = "This is Abhay";

        //Split string on blank space & store in String array
        String[] brokenStringOnSpace = stringToReverse.trim().split(" ");

        //Create StringBuffer object
        StringBuffer sb = new StringBuffer();

        //lenght of string array
        int len = brokenStringOnSpace.length;

        //
        for (int i = len - 1; i >= 0; i--) {
            StringBuffer sb1 = new StringBuffer(brokenStringOnSpace[i]);
            //reverse word in sentence
            sb.append(sb1.reverse());

            //append blank space in sentence
            sb.append(' ');
        }

        //print reversed sentence
        System.out.println("Reversed Sentence :" + sb.toString());
    }
}
