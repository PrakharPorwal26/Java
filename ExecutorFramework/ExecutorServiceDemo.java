package ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String[] args)
            throws Exception {

        /*
         * ExecutorService
         *
         * Manages a pool of worker threads.
         *
         * Instead of creating threads manually,
         * tasks are submitted to ExecutorService.
         */

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        /* =====================================================
           execute()
           ===================================================== */

        /*
         * execute(Runnable)
         *
         * Executes a Runnable task.
         *
         * No return value.
         */

        executor.execute(() ->
                System.out.println(
                        "execute() Task"
                ));

        /* =====================================================
           submit()
           ===================================================== */

        /*
         * submit()
         *
         * Returns a Future object.
         */

        Future<Integer> future =
                executor.submit(() -> 100);

        System.out.println(
                "submit(): " + future.get()
        );

        /* =====================================================
           invokeAll()
           ===================================================== */

        /*
         * Executes all tasks.
         *
         * Returns List<Future>.
         */

        List<Callable<Integer>> tasks =
                Arrays.asList(
                        () -> 10,
                        () -> 20,
                        () -> 30
                );

        List<Future<Integer>> results =
                executor.invokeAll(tasks);

        for (Future<Integer> f : results) {

            System.out.println(
                    f.get()
            );
        }

        /* =====================================================
           invokeAny()
           ===================================================== */

        /*
         * Returns result of first
         * successfully completed task.
         */

        Integer answer =
                executor.invokeAny(tasks);

        System.out.println(
                "invokeAny(): " + answer
        );

        /* =====================================================
           shutdown()
           ===================================================== */

        /*
         * Stops accepting new tasks.
         *
         * Existing tasks continue.
         */

        executor.shutdown();

        /*
         * shutdownNow()
         *
         * Attempts immediate shutdown.
         *
         * Tries to interrupt running tasks.
         */

        // executor.shutdownNow();
    }
}

/*
 * =====================================================
 * EXECUTORSERVICE METHODS
 * =====================================================
 *
 * execute()
 * ----------
 * Executes Runnable.
 *
 *
 * submit()
 * --------
 * Executes task and returns Future.
 *
 *
 * invokeAll()
 * -----------
 * Executes all tasks.
 * Returns List<Future>.
 *
 *
 * invokeAny()
 * -----------
 * Returns result of first
 * successful task.
 *
 *
 * shutdown()
 * ----------
 * Graceful shutdown.
 *
 *
 * shutdownNow()
 * -------------
 * Forceful shutdown.
 */