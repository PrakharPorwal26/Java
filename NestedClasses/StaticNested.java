package NestedClasses;

public class StaticNested {
    public static void main(String[] args) {

        //Creating instance of static nested class, no need to create instance of outer class
        Outer.Inner inner = new Outer.Inner();
        inner.display(); 
        inner.show(); // we can access static variables of outer class from Inner class

        //Indirect access of non-static members of outer class from static nested class
        Outer outer = new Outer();
        inner.accessOuter(outer);

        //There are more ways to access non-static members of outer class from static nested class, eg by passing the Outer class's reference to the static nested class's constructor and then using that reference to access the non-static members of outer class.
    }
}

class Outer{
    int x = 10; // this can't be accessed directly from static nested class, if we need to access it, we need to create instance of outer class. 
    static int data = 30;
    static class Inner{
        void display(){
            System.out.println("This is a static nested class");
        }

        void show(){
            System.out.println("Data is: "+data);
        }

        //Indirect way of accessing non-static members of outer class from static nested class
        void accessOuter(Outer outer){
            System.out.println("Value of x is: "+outer.x);
        }
    }
}

//Use Cases of Static Nested Class:
//1. As helper class for the outer class.
//2. To group classes that will only be used in one place, which increases encapsulation.
//3. Builder Design Patter -> Need to learn this
//4. Static Nested Class can have static methods and static variables, which can be accessed without creating an instance of the static nested class.