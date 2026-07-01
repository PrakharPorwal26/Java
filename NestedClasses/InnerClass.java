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

    int x = 10;

    class Inner{
        int x = 20;
        void display(){
            
            System.out.println("This is an inner class");

            System.out.println(x); //prints 20 because inner class has access to outer class's members, but if inner class has a member with the same name as outer class, then inner class's member will be used. This is called variable shadowing.

            System.out.println(Outer.this.x); //prints 10 because we are using Outer.this to access outer class's member variable x.

        }
        void show(){
            System.out.println("This is a method in the inner class");
        }
    }
}

