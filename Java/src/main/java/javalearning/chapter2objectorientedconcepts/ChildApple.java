package javalearning.chapter2objectorientedconcepts;

public class ChildApple extends SuperFruit {
    public ChildApple()
    {
        System.out.println("Subclass constructor invoked");
        System.out.println("Sub class object hashcode :" +
                this.hashCode());
        System.out.println(this.hashCode() + "   " +
                super.hashCode());

        System.out.println(this.getClass().getName() + "  " +
                super.getClass().getName());
    }
}
