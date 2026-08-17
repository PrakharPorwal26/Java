package FunctionalComposition;

import java.util.function.*;

public class FunctionalComposition {

    public static void main(String[] args) {

        /* ==========================================================
           FUNCTION CHAINING
           ==========================================================

           Function chaining allows us to combine multiple Function
           objects into a single pipeline.

           Suppose we want to calculate:
               (x + 2) * 3

           Instead of writing everything inside one lambda, we can
           break the logic into smaller reusable functions.
        */

        Function<Integer, Integer> add2 = x -> x + 2;
        Function<Integer, Integer> multiplyBy3 = x -> x * 3;

        // Traditional approach
        int intermediateResult = add2.apply(2);
        int finalResult = multiplyBy3.apply(intermediateResult);

        System.out.println("Traditional Result: " + finalResult);

        /*
         * andThen()
         *
         * First executes the current function and then passes
         * the result to the next function.
         *
         * add2.andThen(multiplyBy3)
         *
         * Equivalent to:
         * multiplyBy3(add2(x))
         *
         * G(F(x))
         */

        int chainedResult = add2.andThen(multiplyBy3).apply(2);
        System.out.println("Using andThen(): " + chainedResult);

        /*
         * compose()
         *
         * Executes the supplied function first and then
         * executes the current function.
         *
         * multiplyBy3.compose(add2)
         *
         * Equivalent to:
         * multiplyBy3(add2(x))
         *
         * G(F(x))
         */

        int composeResult = multiplyBy3.compose(add2).apply(2);
        System.out.println("Using compose(): " + composeResult);


        /* ==========================================================
           PREDICATE CHAINING
           ==========================================================

           Predicate represents a condition that returns true or false.

           Method:
               boolean test(T t)
        */

        Predicate<Integer> isGreaterThan100 = x -> x > 100;
        Predicate<Integer> isEven = x -> x % 2 == 0;

        /*
         * and()
         *
         * Equivalent to logical &&
         *
         * Both predicates must return true.
         */

        Predicate<Integer> greaterAndEven =
                isGreaterThan100.and(isEven);

        System.out.println(
                "200 is greater than 100 and even: "
                        + greaterAndEven.test(200));

        /*
         * or()
         *
         * Equivalent to logical ||
         *
         * At least one predicate must return true.
         */

        Predicate<Integer> greaterOrEven =
                isGreaterThan100.or(isEven);

        System.out.println(
                "50 is greater than 100 or even: "
                        + greaterOrEven.test(50));

        /*
         * negate()
         *
         * Equivalent to logical !
         *
         * Reverses the result of the predicate.
         */

        Predicate<Integer> isOdd = isEven.negate();

        System.out.println(
                "15 is odd: "
                        + isOdd.test(15));


        /* ==========================================================
           CONSUMER CHAINING
           ==========================================================

           Consumer accepts a value and performs an operation.

           Method:
               void accept(T t)

           Consumer does not return anything.
        */

        Consumer<String> printName =
                System.out::println;

        Consumer<String> printUpperCase =
                str -> System.out.println(str.toUpperCase());

        /*
         * andThen()
         *
         * Executes the first Consumer and then
         * executes the second Consumer.
         */

        Consumer<String> pipeline =
                printName.andThen(printUpperCase);

        System.out.println("\nConsumer Chaining:");
        pipeline.accept("Prakhar");
    }
}