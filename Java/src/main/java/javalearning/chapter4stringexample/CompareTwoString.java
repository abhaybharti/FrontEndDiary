package javalearning.chapter4stringexample;

import java.util.Objects;

public class CompareTwoString {

    public static int stringCompare(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    public static void main(String args[]){
        String s1 = "ABCD";
        String s2 = "ABCD";

        //using equals() method
        System.out.println("str.equals() - " + s1.equals(s2));

        //using equalsIgnore() method
        System.out.println("str.equalsIgnore() - "+s1.equalsIgnoreCase(s2));

        //using object.equals()
        System.out.println("Objects.equals() - "+ Objects.equals(s1,s2));

        //string compareTo() method
        //it returns 0 if equal, positive number if 1st Stringis greater, negative number if 2nd string is greater
        System.out.println("str.compareTo() - "+s1.compareTo(s2));

        //User defined method
        String string1 = new String("Geeksforgeeks");
        String string2 = new String("Practice");
        String string3 = new String("Geeks");
        String string4 = new String("Geeks");

        // Comparing for String 1 < String 2
        System.out.println("Comparing " + string1 + " and " + string2 + " : " + stringCompare(string1, string2));

        // Comparing for String 3 = String 4
        System.out.println("Comparing " + string3 + " and " + string4 + " : " + stringCompare(string3, string4));

        // Comparing for String 1 > String 4
        System.out.println("Comparing " + string1 + " and " + string4 + " : " + stringCompare(string1, string4));

    }
    }

