package javalearning.chapter6collectionsex;


import java.util.Objects;

public class equalsmethodExamples {

    private int moofValue;

    public equalsmethodExamples(int moofValue) {
        this.moofValue = moofValue;
    }

    public int getMoofValue() {
        return moofValue;
    }


    //equals() method is inherited from Object
    public boolean equals(Object o) {
        // - instanceOf test is performed to be sure you could cast the object argument to correct type
        // - If Object fails instanceOf test then runtime exception classcastException will come
        // - if you override equals() method, also override hashcode() method
        if((o instanceof equalsmethodExamples) && ((equalsmethodExamples) o).getMoofValue() == this.moofValue){
           return true;
        }else{
         return false;
        }
     }
}
