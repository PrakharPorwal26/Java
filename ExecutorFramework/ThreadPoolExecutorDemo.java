package ExecutorFramework;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        /*
         * ThreadPoolExecutor
         *
         * Most configurable thread pool.
         */

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(

                        /* corePoolSize */
                        2,

                        /* maximumPoolSize */
                        4,

                        /* keepAliveTime */
                        10,

                        /* TimeUnit */
                        TimeUnit.SECONDS,

                        /* Work Queue */
                        new ArrayBlockingQueue<>(2)
                );

        for (int i = 1; i <= 8; i++) {

            int taskId = i;

            executor.submit(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                                + " executing Task "
                                + taskId
                );

                try {

                    Thread.sleep(3000);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}

/*
 * =====================================================
 * THREADPOOLEXECUTOR
 * =====================================================
 *
 * Constructor:
 *
 * ThreadPoolExecutor(
 *      corePoolSize,
 *      maximumPoolSize,
 *      keepAliveTime,
 *      unit,
 *      workQueue
 * )
 *
 *
 * corePoolSize
 * ------------
 * Minimum threads kept alive.
 *
 *
 * maximumPoolSize
 * ----------------
 * Maximum threads allowed.
 *
 *
 * workQueue
 * ----------
 * Stores waiting tasks.
 *
 *
 * keepAliveTime
 * -------------
 * Extra threads beyond core size
 * remain alive for this duration.
 *
 *
 * Execution Flow
 * --------------
 *
 * 1. Create threads up to corePoolSize
 *
 * 2. Fill workQueue
 *
 * 3. Create extra threads until
 *    maximumPoolSize reached
 *
 * 4. Reject task if queue full
 *    and max threads reached
 */