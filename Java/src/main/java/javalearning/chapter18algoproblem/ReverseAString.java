package javalearning.chapter18algoproblem;

public class ReverseAString {

    public static void main(String args[]){
        /** --------- Reverse String using StringBuffer -> reverse() method -------- **/
        String stringToReverse = "Selenium";

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = stringToReverse.length()-1; i >=0; i-- ){
            stringBuilder.append(stringToReverse.charAt(i));
        }
        System.out.println("Reversed String : "+ stringBuilder.toString());


        /** --------- Reverse String using StringBuffer -> reverse() method -------- **/

        StringBuffer newStr = new StringBuffer("This is the string to reverse"); //Sample String
        System.out.println("Reversed String : "+newStr.reverse()); //Reversed string
    }
}
