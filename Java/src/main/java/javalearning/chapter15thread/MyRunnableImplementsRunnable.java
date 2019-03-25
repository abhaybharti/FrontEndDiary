package javalearning.chapter15thread;

public class MyRunnableImplementsRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Implement Job running in my Runnable");
    }
}
