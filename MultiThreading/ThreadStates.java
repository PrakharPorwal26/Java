package MultiThreading;

public class ThreadStates {

    public static void main(String[] args)
            throws InterruptedException {

        Thread t = new Thread(() -> {

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        /*
         * NEW
         * Thread object created but not started.
         */
        System.out.println("State: " + t.getState());

        t.start();

        /*
         * RUNNABLE
         * Ready to run or currently running.
         */
        System.out.println("State: " + t.getState());

        Thread.sleep(100);

        /*
         * TIMED_WAITING
         * Sleeping for a specified duration.
         */
        System.out.println("State: " + t.getState());

        t.join();

        /*
         * TERMINATED
         * Execution completed.
         */
        System.out.println("State: " + t.getState());
    }
}

/*
 * Thread States
 *
 * NEW
 * RUNNABLE
 * BLOCKED
 * WAITING
 * TIMED_WAITING
 * TERMINATED
 */