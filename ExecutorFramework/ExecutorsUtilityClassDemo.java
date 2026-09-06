package ExecutorFramework;

import java.util.concurrent.*;

public class ExecutorsUtilityClassDemo {

    public static void main(String[] args)
            throws InterruptedException {

        /* =====================================================
           1. newFixedThreadPool()
           ===================================================== */

        /*
         * Creates a thread pool with a fixed
         * number of threads.
         *
         * If all threads are busy,
         * tasks wait in queue.
         */

        ExecutorService fixedPool =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            fixedPool.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " FixedPool Task "
                                + taskId
                );
            });
        }

        fixedPool.shutdown();



        /* =====================================================
           2. newCachedThreadPool()
           ===================================================== */

        /*
         * Creates threads as needed.
         *
         * Reuses idle threads.
         *
         * No fixed upper limit.
         *
         * Best for many short-lived tasks.
         */

        ExecutorService cachedPool =
                Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            cachedPool.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " CachedPool Task "
                                + taskId
                );
            });
        }

        cachedPool.shutdown();



        /* =====================================================
           3. newSingleThreadExecutor()
           ===================================================== */

        /*
         * Creates exactly one worker thread.
         *
         * Tasks execute sequentially
         * in submission order.
         */

        ExecutorService singleThreadExecutor =
                Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            singleThreadExecutor.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " SingleThread Task "
                                + taskId
                );
            });
        }

        singleThreadExecutor.shutdown();



        /* =====================================================
           4. newScheduledThreadPool()
           ===================================================== */

        /*
         * Used for delayed and periodic tasks.
         */

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(2);

        /*
         * schedule()
         *
         * Executes task after delay.
         */

        scheduler.schedule(
                () -> System.out.println(
                        "Executed after 3 seconds"
                ),
                3,
                TimeUnit.SECONDS
        );

        /*
         * scheduleAtFixedRate()
         *
         * Executes task repeatedly
         * after fixed interval.
         */

        ScheduledFuture<?> future =
                scheduler.scheduleAtFixedRate(
                        () -> System.out.println(
                                "Periodic Task Running"
                        ),
                        1,  // initial delay
                        2,  // interval
                        TimeUnit.SECONDS
                );

        /*
         * Let periodic task run for a while.
         */

        Thread.sleep(7000);

        /*
         * Stop periodic execution.
         */

        future.cancel(true);

        scheduler.shutdown();
    }
}

/*
 * =====================================================
 * EXECUTORS UTILITY CLASS
 * =====================================================
 *
 * Factory methods for creating
 * commonly used thread pools.
 *
 *
 * =====================================================
 * newFixedThreadPool(n)
 * =====================================================
 *
 * Fixed number of threads.
 *
 * Extra tasks wait in queue.
 *
 * Example:
 * Executors.newFixedThreadPool(5)
 *
 *
 * Use Cases:
 * - Web servers
 * - Database operations
 * - Controlled concurrency
 *
 *
 * =====================================================
 * newCachedThreadPool()
 * =====================================================
 *
 * Creates threads as needed.
 *
 * Reuses idle threads.
 *
 * Potentially unlimited threads.
 *
 *
 * Use Cases:
 * - Many short-lived tasks
 * - Burst workloads
 *
 *
 * =====================================================
 * newSingleThreadExecutor()
 * =====================================================
 *
 * Only one worker thread.
 *
 * Tasks execute one by one.
 *
 * Preserves task order.
 *
 *
 * Use Cases:
 * - Logging
 * - Sequential processing
 *
 *
 * =====================================================
 * newScheduledThreadPool(n)
 * =====================================================
 *
 * Executes delayed and periodic tasks.
 *
 *
 * Important Methods:
 *
 * schedule()
 * scheduleAtFixedRate()
 * scheduleWithFixedDelay()
 *
 *
 * Use Cases:
 * - Reminders
 * - Polling services
 * - Health checks
 * - Scheduled jobs
 *
 *
 * =====================================================
 * INTERVIEW QUESTION
 * =====================================================
 *
 * Fixed Thread Pool
 * -----------------
 * Fixed number of threads.
 *
 *
 * Cached Thread Pool
 * ------------------
 * Dynamic number of threads.
 *
 *
 * Single Thread Executor
 * ----------------------
 * Exactly one thread.
 *
 *
 * Scheduled Thread Pool
 * ---------------------
 * Delayed and periodic tasks.
 */