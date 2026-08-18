package JavaStreams;

import java.util.*;
import java.util.stream.*;

public class TerminalOperations {

    public static void main(String[] args) {

        List<Integer> list = List.of(10, 20, 30, 40, 50);

        /* =====================================================
           1. COLLECTING RESULTS
           ===================================================== */

        // toList() -> Collect stream elements into a List
        List<Integer> doubled =
                list.stream()
                    .map(x -> x * 2)
                    .toList();

        System.out.println("toList(): " + doubled);

        // collect() -> Collect elements into a desired collection/result
        List<Integer> collected =
                list.stream()
                    .filter(x -> x > 20)
                    .collect(Collectors.toList());

        System.out.println("collect(): " + collected);


        /* =====================================================
           2. REDUCING OPERATIONS
           ===================================================== */

        // reduce() -> Combine all elements into a single result

        Integer sumUsingReduce =
                list.stream()
                    .reduce(0, (a, b) -> a + b);

        System.out.println("reduce(sum): " + sumUsingReduce);

        // sum()
        int sum =
                list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

        System.out.println("sum(): " + sum);

        // max()
        OptionalInt max =
                list.stream()
                    .mapToInt(Integer::intValue)
                    .max();

        System.out.println("max(): " + max.getAsInt());

        // min()
        OptionalInt min =
                list.stream()
                    .mapToInt(Integer::intValue)
                    .min();

        System.out.println("min(): " + min.getAsInt());

        // average()
        OptionalDouble average =
                list.stream()
                    .mapToInt(Integer::intValue)
                    .average();

        System.out.println("average(): " + average.getAsDouble());

        // count()
        long count =
                list.stream()
                    .count();

        System.out.println("count(): " + count);


        /* =====================================================
           3. SEARCH / MATCH OPERATIONS
           ===================================================== */

        // findFirst() -> Returns first element
        Optional<Integer> first =
                list.stream()
                    .findFirst();

        System.out.println("findFirst(): " + first.get());

        // findAny() -> Returns any element (useful in parallel streams)
        Optional<Integer> any =
                list.stream()
                    .findAny();

        System.out.println("findAny(): " + any.get());

        // anyMatch() -> Returns true if at least one element matches
        boolean anyMatch =
                list.stream()
                    .anyMatch(x -> x > 40);

        System.out.println("anyMatch(): " + anyMatch);

        // allMatch() -> Returns true if all elements match
        boolean allMatch =
                list.stream()
                    .allMatch(x -> x > 5);

        System.out.println("allMatch(): " + allMatch);

        // noneMatch() -> Returns true if no element matches
        boolean noneMatch =
                list.stream()
                    .noneMatch(x -> x < 0);

        System.out.println("noneMatch(): " + noneMatch);


        /* =====================================================
           4. ITERATION OPERATIONS
           ===================================================== */

        // forEach() -> Perform action on each element
        list.stream()
            .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // forEachOrdered() -> Preserves encounter order
        list.parallelStream()
            .forEachOrdered(x -> System.out.print(x + " "));
        System.out.println();


        /* =====================================================
           QUICK NOTES
           =====================================================

           Collecting:
           - toList()
           - collect()

           Reducing:
           - reduce()
           - sum() - works with primitive streams
           - max() - works with primitive streams
           - min() - works with primitive streams
           - average() - works with primitive streams
           - count()

           Search/Match:
           - findFirst()
           - findAny()
           - anyMatch()
           - allMatch()
           - noneMatch()

           Iteration:
           - forEach()
           - forEachOrdered()

           All terminal operations consume the stream.
           After a terminal operation, the stream cannot be reused.
        */
    }
}