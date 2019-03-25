package javalearning.chapter2objectorientedconcepts;

// super class
class SuperFruit
{
    public SuperFruit()
    {
        System.out.println("Super class constructor");
        System.out.println("Super class object hashcode :" +
                this.hashCode());
        System.out.println(this.getClass().getName());
    }
}