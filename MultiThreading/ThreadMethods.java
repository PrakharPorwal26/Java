package MultiThreading;

class Worker extends Thread {

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        getName() + " : " + i
                );

                /*
                 * sleep(milliseconds)
                 *
                 * Causes the current thread to pause
                 * execution for the specified duration.
                 */

                Thread.sleep(500);
            }

        } catch (InterruptedException e) {

            System.out.println(
                    getName() + " was interrupted."
            );
        }
    }
}

public class ThreadMethods {

    public static void main(String[] args)
            throws InterruptedException {

        /*
         * currentThread()
         *
         * Returns the currently executing thread.
         */

        Thread mainThread =
                Thread.currentThread();

        System.out.println(
                "Current Thread: "
                        + mainThread.getName()
        );

        /*
         * setName()
         *
         * Changes thread name.
         */

        mainThread.setName("Main-Thread");

        /*
         * getName()
         *
         * Returns thread name.
         */

        System.out.println(
                "Updated Name: "
                        + mainThread.getName()
        );

        Worker t1 = new Worker();
        t1.setName("Worker-1");

        /*
         * isAlive()
         *
         * Returns true if thread has started
         * and has not yet terminated.
         */

        System.out.println(
                "Before start: "
                        + t1.isAlive()
        );

        t1.start();

        System.out.println(
                "After start: "
                        + t1.isAlive()
        );

        /*
         * yield()
         *
         * Suggests to the scheduler that
         * current thread is willing to
         * give other threads a chance.
         *
         * Not guaranteed.
         */

        Thread.yield();

        /*
         * join()
         *
         * Causes current thread to wait
         * until t1 finishes execution.
         */

        t1.join();

        System.out.println(
                "Worker completed."
        );

        System.out.println(
                "After completion: "
                        + t1.isAlive()
        );


        /* ---------- interrupt() ---------- */

        Worker t2 = new Worker();
        t2.setName("Worker-2");

        t2.start();

        Thread.sleep(1000);

        /*
         * interrupt()
         *
         * Sets interrupt flag.
         *
         * If thread is sleeping, waiting,
         * or blocked, InterruptedException
         * may be thrown.
         */

        t2.interrupt();
    }
}

/*
 * =====================================================
 * isInterrupted() vs interrupted()
 * =====================================================
 *
 * isInterrupted()
 * ----------------
 * Instance Method
 *
 * Checks interrupt status of a thread.
 *
 * Does NOT clear interrupt flag.
 *
 * Example:
 * t1.isInterrupted()
 *
 *
 * interrupted()
 * -------------
 * Static Method
 *
 * Checks interrupt status of the
 * CURRENT thread.
 *
 * Clears interrupt flag after checking.
 *
 * Example:
 * Thread.interrupted()
 *
 *
 * Why is interruption important?
 *
 * Java does not provide stop() anymore
 * because it is unsafe.
 *
 * interrupt() is the cooperative way
 * to request a thread to stop.
 */