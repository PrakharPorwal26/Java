package LockInterface;

import java.util.concurrent.Semaphore;

/*
 * Semaphore
 *
 * A synchronization utility used to control
 * access to a limited number of resources.
 *
 * Instead of allowing only one thread at a time
 * (like a lock), Semaphore allows a fixed number
 * of threads to access a resource concurrently.
 *
 * Internally, Semaphore maintains a count called
 * permits.
 */

public class SemaphoreDemo {

    /*
     * Counting Semaphore
     *
     * 3 permits available.
     *
     * At most 3 threads can enter the
     * critical section simultaneously.
     */

    private static final Semaphore semaphore =
            new Semaphore(3);

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            int id = i;

            Thread t = new Thread(() -> {

                try {

                    /*
                     * acquire()
                     *
                     * Acquires one permit.
                     *
                     * If permit is available:
                     *      Thread proceeds.
                     *
                     * Otherwise:
                     *      Thread waits.
                     */

                    semaphore.acquire();

                    System.out.println(
                            "Thread-" + id
                                    + " acquired permit"
                    );

                    /*
                     * availablePermits()
                     *
                     * Returns number of permits
                     * currently available.
                     */

                    System.out.println(
                            "Available Permits: "
                                    + semaphore.availablePermits()
                    );

                    Thread.sleep(3000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                } finally {

                    /*
                     * release()
                     *
                     * Returns permit back
                     * to semaphore.
                     */

                    semaphore.release();

                    System.out.println(
                            "Thread-" + id
                                    + " released permit"
                    );
                }

            });

            t.start();
        }
    }
}

/*
 * =====================================================
 * SEMAPHORE
 * =====================================================
 *
 * Controls access to limited resources.
 *
 * Maintains a count called permits.
 *
 *
 * acquire()
 * ----------
 * Takes one permit.
 *
 * If permit unavailable:
 * thread waits.
 *
 *
 * release()
 * ----------
 * Returns permit.
 *
 *
 * availablePermits()
 * -------------------
 * Returns remaining permits.
 *
 *
 * =====================================================
 * COUNTING SEMAPHORE
 * =====================================================
 *
 * More than one permit.
 *
 * Example:
 *
 * Semaphore semaphore =
 *      new Semaphore(3);
 *
 * Maximum 3 threads can access
 * resource simultaneously.
 *
 *
 * Use Cases:
 * - Database connection pool
 * - Printer pool
 * - Thread pool throttling
 *
 *
 * =====================================================
 * BINARY SEMAPHORE
 * =====================================================
 *
 * Only one permit.
 *
 * Example:
 *
 * Semaphore semaphore =
 *      new Semaphore(1);
 *
 * Behaves similar to a lock.
 *
 * Only one thread allowed
 * at a time.
 *
 *
 * =====================================================
 * BINARY vs COUNTING SEMAPHORE
 * =====================================================
 *
 * Binary Semaphore
 * ----------------
 * Permits = 1
 *
 * Example:
 * new Semaphore(1)
 *
 *
 * Counting Semaphore
 * ------------------
 * Permits > 1
 *
 * Example:
 * new Semaphore(5)
 *
 *
 * =====================================================
 * INTERVIEW QUESTIONS
 * =====================================================
 *
 * Q. Difference between Semaphore
 *    and ReentrantLock?
 *
 * ReentrantLock:
 *      Only 1 thread allowed.
 *
 * Semaphore:
 *      Multiple threads may be allowed
 *      depending on permit count.
 *
 *
 * Q. What is a permit?
 *
 * A permit represents one unit of
 * resource access.
 *
 *
 * Q. Can Semaphore be fair?
 *
 * Yes.
 *
 * Semaphore semaphore =
 *      new Semaphore(3, true);
 *
 * true -> FIFO ordering.
 */