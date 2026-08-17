package MethodReference;
import java.util.*;

public class MethodReference {
    public static void main(String[] args) {
        //Method Reference Generic Syntax: className::methodName

        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
        //iterating using forEach loop which uses a Consumer type of object as argument 
        list.forEach(x -> System.out.println(x));

        //instead of the above implementation, we can use method reference too:
        list.forEach(System.out :: println);

        /*------ Types of Method Reference ------

        1. Static Method Reference

            Lambda:
                x -> Math.abs(x)

            Method Reference:
                Math::abs

            Explanation:
            Calls a static method directly using ClassName::methodName.


        2. Instance Method Reference (Particular Object)

            Lambda:
                x -> System.out.println(x)

            Method Reference:
                System.out::println

            Explanation:
            Calls an instance method on a specific object.
            Here System.out is a PrintStream object.


        3. Instance Method Reference (Arbitrary Object of a Particular Type)

            Lambda:
                str -> str.isEmpty()

            Method Reference:
                String::isEmpty

            Explanation:
            The lambda parameter itself becomes the object on which
            the method is invoked.

            Example:
                Predicate<String> p = String::isEmpty;

            Equivalent to:
                Predicate<String> p = str -> str.isEmpty();


        4. Constructor Method Reference

            Lambda:
                () -> new ArrayList<>()

            Method Reference:
                ArrayList::new

            Explanation:
            Used when a functional interface method simply creates
            and returns a new object.

            Example:
                Supplier<List<Integer>> supplier = ArrayList::new;

            Equivalent to:
                Supplier<List<Integer>> supplier = () -> new ArrayList<>();

        */
        
    }
}
