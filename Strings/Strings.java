package Strings;
//String is a class from java.lang package. 
public class Strings {
    public static void main(String[] args) {
        
        /*------Properties of String */

        //1. String is immutable, which means once a string object is created, it cannot be changed. If we try to change the value of a string, a new string object will be created in the memory. 
        String s1 = "Hello";
        s1.concat("World"); //this won't change the value of s1. A new string object will be created in the memory with value "HelloWorld", but s1 will still point to "Hello".
        System.out.println(s1); //prints Hello

        //2. Literal vs new()
        
        //Literal: Creates an object in the string pool. If the same string is created again, it will point to the same object in the string pool.
        String s2 = "Hello";
        String s3 = "Hello"; //s2 and s3 will point to the same object in the string pool.
        System.out.println(s2 == s3); //prints true

        //new(): Creates an object in the heap memory.
        String s4 = new String("Hello");
        String s5 = new String("Hello"); //s4 and s5 will point to different objects in the heap memory.
        System.out.println(s4 == s5); //prints false

        /*Golden Rule: Only compile time constants go to String Pool automatically and Runtime created strings go to the heap. */

        //Examples:

        //1:
        String s6 = "ja" + "va"; //this is a compile time constant, so it will go to the string pool.
        String s7 = "java"; //this is also a compile time constant, so it will go to the string pool.
        System.out.println(s6 == s7); //prints true

        //String Pool: "java"

        //2:
        String s8 = "ja";
        String s9 = s8 + "va"; //this is a runtime created string, so it will go to the heap. Although, "va" will go to the string pool because it is a compile time constant, but no reference points to "va" in the string pool, so it will be garbage collected.
        String s10 = "java";

        System.out.println(s9 == s10); //prints false

        //String Pool: "ja" , "va"
        //Heap: "java"

        //3:
        String s11 = "java";
        String s12 = s11; //since we are not doing any concatenation or any other operation, this will be a compile time constant, therefore goes to string pool.
        System.out.println(s11 == s12); //prints true

        //String Pool: "java"

        //4:
        String s13 = "Hello";
        s13 = "World"; //this will create a new string object in the string pool with value "World" and s13 will point to it. The old string object "Hello" will be garbage collected if no reference points to it.
        System.out.println(s13); //prints World

        //String Pool: "Hello", "World" --> "Hello" will be garbage collected.

        //5:
        String s14 = new String("Hello");
        String s15 = "Hello"; //s15 will point to the "Hello" created by s14's constructor.
        System.out.println(s14 == s15); //prints false

        //String Pool: "Hello"--> This comes from the literal "Hello" inside the constructor of s14. s15 points to this object.
        //Heap: "Hello"--> This comes from the new String("Hello"). s14 points to this object.

    }
}
