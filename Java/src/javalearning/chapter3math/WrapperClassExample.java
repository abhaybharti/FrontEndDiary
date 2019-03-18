package javalearning.chapter3math;

public class WrapperClassExample {

    public static void main(String args[]){
        Integer number = new Integer(55); //int
        System.out.println("number - "+number);

        Integer number1 = new Integer("55"); //string
        System.out.println("String - "+number1);

        Float number3 = new Float(55.01); //double argument
        Float number4 = new Float(55.01f); //float argument
        Float number5 = new Float("55.0f"); //String

        System.out.println("Double - "+number3);
        System.out.println("Float - "+number4);
        System.out.println("Float String - "+number5);

        Character c1= new Character('C');
        System.out.println("Character - "+c1);

        Boolean b = new Boolean(true); //"true", "True", "tRUE" -all string values give true
        System.out.println("Boolean - "+b);
        b = new Boolean("True");
        System.out.println("Boolean - "+b);
        b = new Boolean("tRUE");
        System.out.println("Boolean - "+b);
    }
}
