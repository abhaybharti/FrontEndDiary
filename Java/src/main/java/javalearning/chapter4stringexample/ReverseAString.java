package javalearning.chapter4stringexample;

import java.util.Scanner;

public class ReverseAString {
    public static void main(String args[]){
        System.out.println("Enter string to reverse:");

        Scanner read = new Scanner(System.in);
        String str = read.nextLine();
        String reverse = "";


        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }

        System.out.println("Reversed string is:");
        System.out.println(reverse);

        StringBuffer str1 = new StringBuffer("ABCD");
        System.out.println(str1.reverse());

        StringBuilder str2 = new StringBuilder("ABCDEFG");
        System.out.println(str2.reverse());
    }
}
