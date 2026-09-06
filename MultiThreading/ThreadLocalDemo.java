package MultiThreading;

public class ThreadLocalDemo {

    /*
     * ThreadLocal
     *
     * Provides thread-specific storage.
     *
     * Every thread gets its own copy
     * of the variable.
     *
     * Changes made by one thread
     * are not visible to other threads.
     *
     * Useful when we want data to be
     * local to a thread without using
     * synchronization.
     */

    private static final ThreadLocal<String> user =
            new ThreadLocal<>();


    /*
     * withInitial()
     *
     * Creates ThreadLocal with
     * default initial value.
     */

    private static final ThreadLocal<Integer> counter =
            ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new Thread(() -> {

            /* ---------- set() ---------- */

            user.set("Prakhar");

            /*
             * get()
             *
             * Returns current thread's value.
             */

            System.out.println(
                    Thread.currentThread().getName()
                            + " User = "
                            + user.get()
            );

            System.out.println(
                    Thread.currentThread().getName()
                            + " Counter = "
                            + counter.get()
            );

            /*
             * Update thread-specific value
             */

            counter.set(counter.get() + 1);

            System.out.println(
                    Thread.currentThread().getName()
                            + " Updated Counter = "
                            + counter.get()
            );

            /*
             * remove()
             *
             * Removes current thread's value.
             *
             * Helps avoid memory leaks,
             * especially in thread pools.
             */

            user.remove();
            counter.remove();
        });

        Thread t2 = new Thread(() -> {

            user.set("Rahul");

            System.out.println(
                    Thread.currentThread().getName()
                            + " User = "
                            + user.get()
            );

            System.out.println(
                    Thread.currentThread().getName()
                            + " Counter = "
                            + counter.get()
            );

            counter.set(counter.get() + 10);

            System.out.println(
                    Thread.currentThread().getName()
                            + " Updated Counter = "
                            + counter.get()
            );

            user.remove();
            counter.remove();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

/*
 * =====================================================
 * THREADLOCAL
 * =====================================================
 *
 * Provides thread-specific variables.
 *
 * Every thread gets its own copy
 * of the value.
 *
 * No synchronization required.
 *
 *
 * =====================================================
 * IMPORTANT METHODS
 * =====================================================
 *
 * set(value)
 * ----------
 * Sets value for current thread.
 *
 *
 * get()
 * -----
 * Returns value associated with
 * current thread.
 *
 *
 * remove()
 * --------
 * Removes value associated with
 * current thread.
 *
 * Important in thread pools to
 * prevent memory leaks.
 *
 *
 * withInitial()
 * -------------
 * Creates ThreadLocal with a
 * default value.
 *
 * Example:
 *
 * ThreadLocal<Integer> count =
 *      ThreadLocal.withInitial(() -> 0);
 *
 *
 * =====================================================
 * WHY THREADLOCAL?
 * =====================================================
 *
 * Without ThreadLocal:
 *
 * Shared Variable
 *      ↓
 * Multiple Threads
 *      ↓
 * Synchronization Needed
 *
 *
 * With ThreadLocal:
 *
 * Thread 1 → Own Copy
 * Thread 2 → Own Copy
 * Thread 3 → Own Copy
 *
 * No synchronization required.
 *
 *
 * =====================================================
 * COMMON USE CASES
 * =====================================================
 *
 * - User Context
 * - Request Context
 * - Database Connections
 * - Transaction Information
 * - DateFormat Objects
 *
 *
 * =====================================================
 * INTERVIEW QUESTION
 * =====================================================
 *
 * Q. Does ThreadLocal make an object
 * thread-safe?
 *
 * NO.
 *
 * It gives each thread its own copy.
 *
 *
 * Q. Why call remove()?
 *
 * To prevent memory leaks when threads
 * are reused by thread pools.
 */