package javalearning.chapter15thread;

public class WhichThreadIsRunningTest {
    public static void main(String args[]){
        WhichThreadIsRunning wr = new WhichThreadIsRunning();
        Thread t = new Thread(wr);
        t.setName("Abhay");
        t.start();
    }
}
