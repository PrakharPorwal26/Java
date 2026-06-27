package AutoboxingUnboxing;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
         //Autoboxing
        int x = 10;
        Integer y = x; // Autoboxing: converting int to Integer
        
        System.out.println("Autoboxing: " + y); // y is a refernce of an Integer object, so that can't be printed directly, therefore toprint it, unboxing is done automatically by the compiler, and the value of y is printed.

        //Unboxing
        Integer a = 20; //Here, 20 is automatically converted to Integer object, autoboxing is done automatically by the compiler.
        int b = a; // Unboxing: converting Integer to int

        System.out.println("Unboxing: " + b);

        /*When is autoboxing and unboxing applied automatically by the compiler?
        -> Assignment of primitive type to wrapper class object and vice versa.
        -> Method calls where primitive types are passed as arguments to methods that expect wrapper class objects and vice versa.
        -> Arithmetic operations involving primitive types and wrapper class objects.
        */

        //----------NULL POINTER EXCEPTION----------//
        
        //Since Integer is a reference type, it can be assigned null value. But int is a primitive type, it can't be assigned null value. Therefore, when we try to unbox a null Integer object to int, it will throw NullPointerException.

        // Integer c = null;
        // int d = c; // Unboxing: converting Integer to int, but c is null, so it will throw NullPointerException, this is not compiler error, it will compile successfully, but at runtime it will throw NullPointerException.

    }
}
