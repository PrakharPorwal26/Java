package MultiThreading;

class SharedData {

    /*
     * volatile
     *
     * Ensures visibility of changes
     * across threads.
     */

    volatile boolean running = true;
}

public class VolatileKeyword {

    public static void main(String[] args)
            throws InterruptedException {

        SharedData data = new SharedData();

        Thread worker = new Thread(() -> {

            while (data.running) {

                // Keep running
            }

            System.out.println("Worker Stopped");
        });

        worker.start();

        Thread.sleep(2000);

        data.running = false;

        System.out.println("Main Thread Updated Flag");
    }
}

/*
 * Visibility Problem
 *
 * Thread may cache variable value locally.
 *
 * One thread updates variable but
 * another thread may not immediately
 * see the updated value.
 *
 * volatile forces reads from main memory.
 *
 * volatile solves:
 * - Visibility Problem
 *
 * volatile DOES NOT solve:
 * - Race Condition
 * - Atomicity Problem
 */