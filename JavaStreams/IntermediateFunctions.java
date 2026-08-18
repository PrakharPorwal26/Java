package JavaStreams;
import java.util.*;
import java.util.stream.*;

public class IntermediateFunctions {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(1,58,62,4,4,11,13,34,34));

        /*---- Intermediate Operations ----*/
        list.stream()                    // Source
            .filter(x -> x > 10)         // Keep elements matching the condition (Predicate)
            .map(x -> x * 2)             // Transform each element (Function)
            .peek(System.out::println)   // Perform an action without modifying the stream (mainly for debugging)
            .sorted()                    // Sort elements in natural order (stateful)
            // .sorted((a,b) -> b-a)     // Sort in descending order
            .distinct()                  // Remove duplicate elements (stateful)
            .forEach(System.out::println); // Terminal operation

        /*---- flatMap() ----*/

        // 2-D List
        List<List<Integer>> list2 = List.of(
                List.of(1,2),
                List.of(3,4),
                List.of(4,5)
        );

        list2.stream()
                .flatMap(x -> x.stream()) // Convert Stream<List<Integer>> to Stream<Integer>
                .map(y -> y * 2)
                .forEach(System.out::println);

        /*---- limit() and skip() ----*/

        Stream.iterate(1, x -> x + 1) // Infinite stream: 1,2,3,4,...
                .limit(10)            // Take first 10 elements
                .skip(3)              // Skip first 3 elements
                .forEach(System.out::println);

    }
}

// filter()  -> Select elements
// map()     -> Transform elements
// flatMap() -> Flatten nested structures
// sorted()  -> Arrange elements
// distinct()-> Remove duplicates
// peek()    -> Debugging/logging
// limit()   -> Restrict stream size
// skip()    -> Ignore first n elements