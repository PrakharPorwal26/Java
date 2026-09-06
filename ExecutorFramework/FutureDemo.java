package ExecutorFramework;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<Integer> future =
                executor.submit(() -> {

                    Thread.sleep(3000);

                    return 100;
                });

        /* =====================================================
           isDone()
           ===================================================== */

        System.out.println(
                future.isDone()
        );

        /* =====================================================
           get()
           ===================================================== */

        /*
         * Blocks until result available.
         */

        Integer result =
                future.get();

        System.out.println(result);

        /* =====================================================
           get(timeout)
           ===================================================== */

        Future<Integer> future2 =
                executor.submit(() -> {

                    Thread.sleep(2000);

                    return 500;
                });

        Integer value =
                future2.get(
                        5,
                        TimeUnit.SECONDS
                );

        System.out.println(value);

        /* =====================================================
           cancel()
           ===================================================== */

        Future<Integer> future3 =
                executor.submit(() -> {

                    Thread.sleep(10000);

                    return 1000;
                });

        future3.cancel(true);

        /* =====================================================
           isCancelled()
           ===================================================== */

        System.out.println(
                future3.isCancelled()
        );

        executor.shutdown();
    }
}

/*
 * =====================================================
 * FUTURE
 * =====================================================
 *
 * Represents result of a task
 * that may complete in future.
 *
 *
 * get()
 * -----
 * Waits and returns result.
 *
 *
 * get(timeout)
 * -------------
 * Waits for limited duration.
 *
 *
 * isDone()
 * --------
 * Checks completion status.
 *
 *
 * cancel()
 * --------
 * Attempts task cancellation.
 *
 *
 * isCancelled()
 * --------------
 * Checks cancellation status.
 */