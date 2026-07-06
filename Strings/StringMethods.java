package Strings;

public class StringMethods {
    public static void main(String[] args) {
        String s = "Hello World";

        /*----Length/Emptiness Methods */
        System.out.println("Length of string: " + s.length());
        System.out.println("Is string empty? " + s.isEmpty());
        System.out.println("Is string blank? " + s.isBlank());

        //1- length() prints the length of the string, if the string has only blank spaces, still it will calculate those spaces in the length.
        //2- isEmpty() checks if the string is empty or not, if the string has only blank spaces, it will return false.
        //3- isBlank() checks if the string is blank or not, if the string has only blank spaces, it will return true.

        /*---------Character Access Methods */
        System.out.println("Character at index 0: " + s.charAt(0)); //gives the character at the specified index.
        char[] charArray = s.toCharArray(); //O/p: [H, e, l, l, o,  , W, o, r, l, d]
        for(char c: charArray){
            System.out.print(c + ", ");
        }

        /*---------Comparison Methods */ 
        String s2 = "Hello World";
        System.out.println("Are strings equal? " + s.equals(s2)); //will return true because equals() has been overridden by String class. If we check s == s2 it will be false.

        String s3 = "HELLO WORLD";
        System.out.println("Are string equal ignoring the casing? " + s3.equalsIgnoreCase(s2)); //return true because it ignores the case

        String s4 = "abc";
        String s5 = "abd";

        System.out.println("Lexicographical difference between both strings: " + s4.compareTo(s5));
        /*compareTo() returns an integer value based on the lexicographical difference between both the stings:
        -ve(): if s4 is smaller than s5
        0: s4 == s5
        +ve(): if s4 is greater than s5

        it adds the unicode/ascii values of strings and then subtract s4's value from s5 and returns the answer.
        */

        /*------Searching Methods */
        System.out.println("Does s contain Hello? " + s.contains("Hello")); //true
        System.out.println("Index of H in Hello: " + s.indexOf("H")); //0
        System.out.println("Last Index of l in Hello World: " + s.lastIndexOf("l"));
        System.out.println("Does Hello World start with X?: " + s.startsWith("X") );// false

        /*------Extraction/ Transformation Methods */
        System.out.println("Substring Hello in Hello World: " + s.substring(0,6)); //0 is inclusive, 6 is exlusive.
        System.out.println("Upper Case: " + s.toUpperCase());
        System.out.println("Lower Case: " + s.toLowerCase());

        String s6 = "      Prakhar       ";
        System.out.println(s6.trim()); //removes extra spaces from any string from beginning and end. ASCII friendly
        System.out.println(s6.strip()); //Unicode Friendly, same as trim.
        System.out.println("Repeating 3 times: " + s.repeat(3)); //Repeats Hello World 3 times without space.
        System.out.println("Replacing H with J: " + s.replace('H','J')); //Jello World


        String s7 = "Prakhar, Tushar, Aman";
        String[] arr = s7.split(",");//Splits on basis of delimiter
        for(String names: arr){
            System.out.println(names);
        }

        //join() - static method
        System.out.println(String.join(",", "a", "b", "c")); //a-b-c

        /*------Conversion Methods */
        //valueOf() is a static method, performs conversion
        String s8 = new String(String.valueOf(10));
        System.out.println(s8); //O/p: 10 (string)
        
        //conversion of string to byte array
        byte[] byteArr = s.getBytes();
        for(byte b: byteArr){
            System.out.println(b + ", ");
        }

        /*-----Advance Methods */

        //1: intern() - This method, when called, creates a copy of the value of the object in string pool, if not already present.
        String s9 = new String("Hello");
        String s10 = s9;
        System.out.println(s10==s9); //returns true
        /* For the above scenario:
        Heap: s9 --> Hello <-- s10
        String Pool - Hello
        */

        String s11 = s9.intern();
        System.out.println(s9 == s11); //returns false
        /* For the above scenario
        Heap: s9 --> Hello
        String Pool: s11 --> Hello
        */

        //format() - To print formatted output omitting use of "+"
        String name = "Prakhar";
        int age = 25;
        System.out.println(String.format("Hello %s, your age is %s.", name, age)); 
        //Output: Hello Prakhar, your age is 25
    }
}
