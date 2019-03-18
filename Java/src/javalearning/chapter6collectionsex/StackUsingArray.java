package javalearning.chapter6collectionsex;

public class StackUsingArray {

    private int maxSize; // size of stack
    private long [] stackArray;
    private int top;


    public StackUsingArray(int s) {
        this.maxSize = s;
        this.stackArray = new long [maxSize];
        this.top = -1;
    }


    public void push(long j){
        stackArray[++top] = j;
    }


    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
     return (top == maxSize - 1);
    }

    public static void main(String args[]){
        StackUsingArray  stck = new StackUsingArray(5);
        stck.push(0);
        stck.push(1);
        stck.push(2);
        stck.push(3);
        stck.push(4);

        while (!stck.isEmpty()) {
            long value = stck.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
