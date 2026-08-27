package MultiThreading;

public class ThreadProperties {

    public static void main(String[] args) {

        Thread t =
                Thread.currentThread();

        /* =====================================================
           THREAD PRIORITY
           ===================================================== */

        /*
         * Priority range:
         *
         * MIN_PRIORITY  = 1
         * NORM_PRIORITY = 5
         * MAX_PRIORITY  = 10
         */

        System.out.println(
                "Default Priority: "
                        + t.getPriority()
        );

        /*
         * setPriority()
         *
         * Requests scheduler to give
         * higher/lower preference.
         *
         * Not guaranteed.
         */

        t.setPriority(Thread.MAX_PRIORITY);

        System.out.println(
                "Updated Priority: "
                        + t.getPriority()
        );

        System.out.println(
                "MIN_PRIORITY = "
                        + Thread.MIN_PRIORITY
        );

        System.out.println(
                "NORM_PRIORITY = "
                        + Thread.NORM_PRIORITY
        );

        System.out.println(
                "MAX_PRIORITY = "
                        + Thread.MAX_PRIORITY
        );


        /* =====================================================
           DAEMON THREAD
           ===================================================== */

        Thread daemonThread =
                new Thread(() -> {

                    while (true) {

                        System.out.println(
                                "Background Task..."
                        );

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                });

        /*
         * setDaemon(true)
         *
         * Must be called before start().
         */

        daemonThread.setDaemon(true);

        daemonThread.start();

        System.out.println(
                "Main thread completed."
        );
    }
}

/*
 * =====================================================
 * USER THREAD vs DAEMON THREAD
 * =====================================================
 *
 * User Thread
 * -----------
 * Performs actual application work.
 *
 * JVM waits for user threads to finish.
 *
 *
 * Daemon Thread
 * -------------
 * Background support thread.
 *
 * JVM does NOT wait for daemon threads.
 *
 *
 * Examples:
 * - Garbage Collector
 * - Monitoring Threads
 * - Background Cleanup
 *
 *
 * Why Daemon Threads?
 * -------------------
 * To perform background services
 * that should automatically stop
 * when the application exits.
 *
 *
 * Important:
 * ----------
 * If all user threads terminate,
 * JVM shuts down even if daemon
 * threads are still running.
 */