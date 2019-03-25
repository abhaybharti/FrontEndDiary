package javalearning.chapter4stringexample;

import java.util.Scanner;

public class ReverseASentenceUsingChatAt {
    public static void main(String args[]) {
        String s1 = "My Name is Abhay";
        System.out.println(s1);

        String s2 [] = s1.split(" ");
        System.out.println(s2.length);
        for (int i =0; i <s2.length;i++){
            System.out.println(s2[i]);
            String temp1=
            for (int j = s2[i].length(); j > 0;j--){
                String temp = s2[i];
                String temp1 = ""+temp.charAt(j);

            }
            StringBuilder sb = new StringBuilder(s2[i]);
            s2[i] = sb.reverse().toString()+ " ";
        }

        for (int i =0; i <s2.length;i++){
            System.out.print(s2[i]);
        }
    }
}
