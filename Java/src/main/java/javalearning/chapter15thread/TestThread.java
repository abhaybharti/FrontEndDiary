package javalearning.chapter15thread;

public class TestThread {

    public static void main(String args[]){
        Runnable r = ()-> {
            for (int x = 1; x < 6; x++) {
                System.out.println("Runnable running " + x);
            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}
