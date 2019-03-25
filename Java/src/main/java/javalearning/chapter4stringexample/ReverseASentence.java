package javalearning.chapter4stringexample;

public class ReverseASentence {


    public static void main(String args[]) {
    String s1 = "My Name is Abhay";
    System.out.println(s1);

    String s2 [] = s1.split(" ");
        System.out.println(s2.length);
    for (int i =0; i <s2.length;i++){
        System.out.println(s2[i]);
        StringBuilder sb = new StringBuilder(s2[i]);
        s2[i] = sb.reverse().toString()+ " ";
    }
        for (int i =0; i <s2.length;i++){
            System.out.print(s2[i]);
        }
    }
}
