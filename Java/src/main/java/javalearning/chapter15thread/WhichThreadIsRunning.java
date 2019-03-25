package javalearning.chapter15thread;

public class WhichThreadIsRunning implements Runnable{

    @Override
    public void run() {
        System.out.println("Name for running");
        System.out.println("Run by "+ Thread.currentThread().getName());
    }
}
