package JavaStreams;

import java.util.*;
import java.util.stream.*;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<String> names =
                List.of("Prakhar", "Rahul", "Aman", "Rahul", "Rohit");

        /* =====================================================
           COLLECTOR INTERFACE & COLLECTORS CLASS
           =====================================================

           Collector Interface:
           - Defines how stream elements should be accumulated
             into a final result.
           - Used internally by collect().

           Collectors Class:
           - Utility class containing factory methods that
             return Collector objects.

           Syntax:
           stream.collect(Collectors.someCollector())
        */


        /* =====================================================
           toList()
           ===================================================== */

        // Collect stream elements into a List

        List<String> list =
                names.stream()
                     .collect(Collectors.toList());

        System.out.println("toList(): " + list);


        /* =====================================================
           toSet()
           ===================================================== */

        // Collect stream elements into a Set
        // Duplicate elements are automatically removed

        Set<String> set =
                names.stream()
                     .collect(Collectors.toSet());

        System.out.println("toSet(): " + set);


        /* =====================================================
           toMap()
           ===================================================== */

        // Convert stream elements into a Map

        Map<String, Integer> map =
                names.stream()
                     .distinct()
                     .collect(Collectors.toMap(
                             name -> name,          // Key
                             name -> name.length()  // Value
                     ));

        System.out.println("toMap(): " + map);


        /* =====================================================
           joining()
           ===================================================== */

        // Combine all String elements into a single String

        String joined =
                names.stream()
                     .collect(Collectors.joining(", "));

        System.out.println("joining(): " + joined);


        /* =====================================================
           groupingBy()
           ===================================================== */

        // Group elements based on a classifier function

        Map<Integer, List<String>> groupedByLength =
                names.stream()
                     .collect(Collectors.groupingBy(
                             String::length
                     ));

        System.out.println("groupingBy():");
        System.out.println(groupedByLength);

        /*
         * Example Output:
         *
         * {
         *   5=[Rahul, Rahul, Rohit],
         *   4=[Aman],
         *   7=[Prakhar]
         * }
         */


        /* =====================================================
           partitioningBy()
           ===================================================== */

        // Split elements into two groups:
        // true and false

        List<Integer> numbers =
                List.of(10, 15, 20, 25, 30);

        Map<Boolean, List<Integer>> partitioned =
                numbers.stream()
                       .collect(Collectors.partitioningBy(
                               x -> x % 2 == 0
                       ));

        System.out.println("partitioningBy():");
        System.out.println(partitioned);

        /*
         * Example Output:
         *
         * {
         *   true=[10,20,30],
         *   false=[15,25]
         * }
         */


        /* =====================================================
           SUMMARY
           =====================================================

           Collectors.toList()
           -> Collect into List

           Collectors.toSet()
           -> Collect into Set

           Collectors.toMap()
           -> Collect into Map

           Collectors.joining()
           -> Merge Strings into one String

           Collectors.groupingBy()
           -> Group elements by a condition/classifier

           Collectors.partitioningBy()
           -> Split elements into true/false groups
        */
    }
}