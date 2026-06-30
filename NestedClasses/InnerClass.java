package NestedClasses;

public class InnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        //If we don't want to create an instance of outer class, we can also create an instance of inner class like this:

        Outer.Inner inner1 = new Outer().new Inner();

        inner.display();
        inner1.show();
    }
}

class Outer{
    class Inner{
        void display(){
            System.out.println("This is an inner class");
        }
        void show(){
            System.out.println("This is a method in the inner class");
        }
    }
}

