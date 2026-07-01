package NestedClasses;

public class LocalClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display();
        
    }
}

class Outer{
    void display(){

        int x = 10; //local variable
        //x++; incrementing local variable, this is not allowed because of Rule of Effectively Final Variable.

        class Inner{
            void show(){
                System.out.println("This is a method in the inner class");
                System.out.println(x); //accessing local variable from outer method
            }
        }
        Inner inner = new Inner();
        inner.show();
    }
}
