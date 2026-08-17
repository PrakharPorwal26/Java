package JavaStreams;
import java.util.stream.*;
import java.util.*;

public class Streams_01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(5, 12, 15, 20, 50));

        // Create a stream from the list
        Stream<Integer> s = list.stream();

        // Keep only elements greater than 10
        s = s.filter(x -> x > 10);

        // Transform each element to its square
        s = s.map(x -> x * x);

        // Terminal operation: collect the stream elements into a List
        List<Integer> result = s.toList();

        // Print the collected elements
        for (Integer i : result) {
            System.out.println(i);
        }

        /* -------- Method Chaining -------- */

        // Since filter() and map() return a Stream,
        // we can chain multiple operations together

        list.stream()
            .filter(x -> x > 10)
            .map(x -> x * x)
            .forEach(System.out::println); // Terminal operation
    }
}