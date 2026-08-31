package LockInterface;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    /*
     * ReentrantLock
     *
     * Implementation of the Lock interface.
     *
     * Provides more control and flexibility
     * than the synchronized keyword.
     *
     * Features:
     * - Explicit locking and unlocking
     * - tryLock()
     * - Fairness policy
     * - Lock interruptibility
     * - Multiple lock acquisitions by same thread
     */

    /*
     * Constructor 1:
     * Creates a non-fair lock (default)
     */

    // private static ReentrantLock lock = new ReentrantLock();

    /*
     * Constructor 2:
     * ReentrantLock(boolean fair)
     *
     * fair = true
     * -> Lock granted in FIFO order as much as possible.
     *
     * fair = false
     * -> No ordering guarantee (better throughput).
     */

    private static ReentrantLock lock =
            new ReentrantLock(true);

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new Thread(() -> {

            /*
             * lock()
             *
             * Acquires the lock.
             *
             * If lock is unavailable,
             * thread waits until it becomes available.
             */

            lock.lock();

            try {

                System.out.println(
                        Thread.currentThread().getName()
                                + " acquired lock"
                );

                /*
                 * isLocked()
                 *
                 * Returns true if lock is currently held
                 * by any thread.
                 */

                System.out.println(
                        "isLocked(): "
                                + lock.isLocked()
                );

                /*
                 * isHeldByCurrentThread()
                 *
                 * Returns true if current thread
                 * owns the lock.
                 */

                System.out.println(
                        "isHeldByCurrentThread(): "
                                + lock.isHeldByCurrentThread()
                );

                /*
                 * getHoldCount()
                 *
                 * Number of times current thread
                 * has acquired the lock.
                 */

                System.out.println(
                        "Hold Count: "
                                + lock.getHoldCount()
                );

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            } finally {

                /*
                 * unlock()
                 *
                 * Releases the lock.
                 *
                 * Always place inside finally block
                 * to avoid lock leaks.
                 */

                lock.unlock();

                System.out.println(
                        Thread.currentThread().getName()
                                + " released lock"
                );
            }

        }, "Thread-1");


        Thread t2 = new Thread(() -> {

            try {

                /*
                 * tryLock()
                 *
                 * Attempts to acquire lock immediately.
                 *
                 * Returns:
                 * true  -> lock acquired
                 * false -> lock unavailable
                 */

                if (lock.tryLock()) {

                    try {

                        System.out.println(
                                Thread.currentThread().getName()
                                        + " acquired lock using tryLock()"
                        );

                    } finally {

                        lock.unlock();
                    }

                } else {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " could not acquire lock"
                    );
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        }, "Thread-2");



        Thread t3 = new Thread(() -> {

            try {

                /*
                 * tryLock(timeout, TimeUnit)
                 *
                 * Waits for specified duration
                 * to acquire lock.
                 *
                 * Returns:
                 * true  -> lock acquired
                 * false -> timeout occurred
                 */

                if (lock.tryLock(
                        5,
                        TimeUnit.SECONDS
                )) {

                    try {

                        System.out.println(
                                Thread.currentThread().getName()
                                        + " acquired lock after waiting"
                        );

                    } finally {

                        lock.unlock();
                    }

                } else {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " timeout occurred"
                    );
                }

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }, "Thread-3");


        t1.start();

        Thread.sleep(100);

        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();



        /* =====================================================
           REENTRANT BEHAVIOR
           ===================================================== */

        lock.lock();

        try {

            System.out.println(
                    "\nHold Count: "
                            + lock.getHoldCount()
            );

            /*
             * Same thread can acquire
             * the lock multiple times.
             */

            lock.lock();

            try {

                System.out.println(
                        "Hold Count after re-locking: "
                                + lock.getHoldCount()
                );

            } finally {

                lock.unlock();
            }

        } finally {

            lock.unlock();
        }



        /*
         * isFair()
         *
         * Returns true if lock
         * follows fairness policy.
         */

        System.out.println(
                "\nIs Fair Lock: "
                        + lock.isFair()
        );
    }
}

/*
 * =====================================================
 * QUICK NOTES
 * =====================================================
 *
 * Lock Interface
 * --------------
 * Provides explicit lock management.
 *
 * Main Implementation:
 * ReentrantLock
 *
 *
 * ReentrantLock
 * -------------
 * Same thread can acquire the lock
 * multiple times.
 *
 *
 * lock()
 * -------
 * Acquires lock.
 *
 *
 * unlock()
 * --------
 * Releases lock.
 *
 *
 * tryLock()
 * ---------
 * Attempts immediate lock acquisition.
 *
 *
 * tryLock(timeout, TimeUnit)
 * --------------------------
 * Waits for specified duration.
 *
 *
 * isLocked()
 * ----------
 * Checks if lock is held by any thread.
 *
 *
 * isHeldByCurrentThread()
 * -----------------------
 * Checks if current thread owns lock.
 *
 *
 * getHoldCount()
 * --------------
 * Number of times current thread
 * acquired the lock.
 *
 *
 * isFair()
 * --------
 * Checks whether lock follows
 * fairness policy.
 *
 *
 * Fair Lock
 * ---------
 * Threads get lock roughly in
 * request order (FIFO).
 *
 *
 * Non-Fair Lock
 * -------------
 * No ordering guarantee.
 * Better performance.
 *
 *
 * Why ReentrantLock over synchronized?
 * ------------------------------------
 * - tryLock()
 * - Timed lock acquisition
 * - Fairness support
 * - Better lock control
 * - Explicit locking/unlocking
 */