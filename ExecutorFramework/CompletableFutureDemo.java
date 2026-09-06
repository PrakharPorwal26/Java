package ExecutorFramework;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        /* =====================================================
           supplyAsync()
           ===================================================== */

        /*
         * supplyAsync()
         *
         * Executes task asynchronously.
         *
         * Used when task returns a value.
         *
         * Takes Supplier<T>.
         */

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {

                    System.out.println(
                            "Calculating..."
                    );

                    return 10;
                });

        System.out.println(
                future.join()
        );


        /* =====================================================
           runAsync()
           ===================================================== */

        /*
         * runAsync()
         *
         * Executes task asynchronously.
         *
         * Used when task returns nothing.
         *
         * Takes Runnable.
         */

        CompletableFuture<Void> task =
                CompletableFuture.runAsync(() -> {

                    System.out.println(
                            "Background Task Running"
                    );
                });

        task.join();


        /* =====================================================
           thenApply()
           ===================================================== */

        /*
         * Transforms result.
         *
         * Input -> Output
         */

        CompletableFuture<Integer> square =
                CompletableFuture
                        .supplyAsync(() -> 5)
                        .thenApply(x -> x * x);

        System.out.println(
                square.join()
        );


        /* =====================================================
           thenAccept()
           ===================================================== */

        /*
         * Consumes result.
         *
         * Returns CompletableFuture<Void>
         */

        CompletableFuture<Void> print =
                CompletableFuture
                        .supplyAsync(() -> "Java")
                        .thenAccept(System.out::println);

        print.join();


        /* =====================================================
           thenRun()
           ===================================================== */

        /*
         * Executes task after completion.
         *
         * Does not receive previous result.
         */

        CompletableFuture<Void> done =
                CompletableFuture
                        .supplyAsync(() -> "Completed")
                        .thenRun(() ->
                                System.out.println(
                                        "Task Finished"
                                ));

        done.join();


        /* =====================================================
           thenCombine()
           ===================================================== */

        /*
         * Combines results from
         * two independent futures.
         */

        CompletableFuture<Integer> future1 =
                CompletableFuture
                        .supplyAsync(() -> 10);

        CompletableFuture<Integer> future2 =
                CompletableFuture
                        .supplyAsync(() -> 20);

        CompletableFuture<Integer> combined =
                future1.thenCombine(
                        future2,
                        (a, b) -> a + b
                );

        System.out.println(
                combined.join()
        );
    }
}

/*
 * =====================================================
 * COMPLETABLE FUTURE
 * =====================================================
 *
 * Improved Future API.
 *
 * Supports:
 * - Async execution
 * - Chaining
 * - Combining tasks
 * - Non-blocking programming
 *
 *
 * supplyAsync()
 * -------------
 * Returns value.
 *
 *
 * runAsync()
 * ----------
 * No return value.
 *
 *
 * thenApply()
 * -----------
 * Transform result.
 *
 *
 * thenAccept()
 * ------------
 * Consume result.
 *
 *
 * thenRun()
 * ---------
 * Execute after completion.
 *
 *
 * thenCombine()
 * -------------
 * Combine multiple futures.
 *
 *
 * join()
 * ------
 * Similar to get().
 *
 * Does not throw checked exceptions.
 */