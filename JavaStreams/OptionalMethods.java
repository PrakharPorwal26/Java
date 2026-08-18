package JavaStreams;

import java.util.*;

public class OptionalMethods {

    public static void main(String[] args) {

        /* =====================================================
           CREATING OPTIONAL OBJECTS
           ===================================================== */

        Optional<String> optionalName =
                Optional.of("Prakhar");

        Optional<String> emptyOptional =
                Optional.empty();


        /* =====================================================
           GETTING VALUES FROM OPTIONAL
           ===================================================== */

        // get()
        // Returns the value if present.
        // Throws NoSuchElementException if empty.

        System.out.println("get(): " + optionalName.get());

        // isPresent()
        // Returns true if a value exists.

        System.out.println(
                "isPresent(): "
                        + optionalName.isPresent());

        // ifPresent()
        // Executes the given action only if value exists.

        optionalName.ifPresent(
                name -> System.out.println("Hello " + name)
        );


        /* =====================================================
           DEFAULT VALUE METHODS
           ===================================================== */

        // orElse()
        // Returns the value if present,
        // otherwise returns the provided default value.

        String name1 =
                emptyOptional.orElse("Default Name");

        System.out.println("orElse(): " + name1);

        // orElseThrow()
        // Returns value if present,
        // otherwise throws the specified exception.

        try {
            String name2 =
                    emptyOptional.orElseThrow(
                            () -> new RuntimeException("Value not found")
                    );

            System.out.println(name2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ifPresentOrElse()
        // Executes first block if value exists,
        // otherwise executes second block.

        optionalName.ifPresentOrElse(
                value -> System.out.println("Value: " + value),
                () -> System.out.println("No Value Found")
        );

        emptyOptional.ifPresentOrElse(
                value -> System.out.println("Value: " + value),
                () -> System.out.println("No Value Found")
        );


        /* =====================================================
           OPTIONAL TRANSFORMATION METHODS
           ===================================================== */

        // map()
        // Transforms the value if present.
        // Returns Optional of transformed result.

        Optional<Integer> length =
                optionalName.map(String::length);

        System.out.println("map(): " + length.get());


        // flatMap()
        // Similar to map(), but the mapping function
        // itself returns an Optional.
        // Prevents nested Optional<Optional<T>>.

        Optional<String> upperCase =
                optionalName.flatMap(
                        str -> Optional.of(str.toUpperCase())
                );

        System.out.println("flatMap(): " + upperCase.get());


        // filter()
        // Keeps the value only if the condition is true.

        Optional<String> filtered =
                optionalName.filter(
                        str -> str.length() > 5
                );

        System.out.println("filter(): " + filtered);

        Optional<String> filtered2 =
                optionalName.filter(
                        str -> str.length() > 20
                );

        System.out.println("filter(): " + filtered2);


        /* =====================================================
           QUICK NOTES
           =====================================================

           Getting Value:
           - get()
           - isPresent()
           - ifPresent()

           Default Handling:
           - orElse()
           - orElseThrow()
           - ifPresentOrElse()

           Transformation:
           - map()
           - flatMap()
           - filter()

           Optional helps avoid NullPointerException
           by explicitly representing the presence
           or absence of a value.
        */
    }
}
