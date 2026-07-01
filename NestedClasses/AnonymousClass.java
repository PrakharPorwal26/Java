package NestedClasses;

public class AnonymousClass {
    public static void main(String[] args) {
        Outer outer = new Outer(){
            String name = "Anonymous Class";
            @Override
            void display(){
                System.out.println("This is an" + " " + name);
                show();
            }
            //can also create methods in anonymous class, but we can't access them from outer class because they are not part of outer class. To access, call it inside the display().
            void show(){
                System.out.println("This is a method in the anonymous class");
            }
        };
        outer.display();
    }
}

class Outer{
    void display(){
        System.out.println("This is an outer class");
    }
}
