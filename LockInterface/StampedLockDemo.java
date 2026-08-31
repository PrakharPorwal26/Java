package LockInterface;

import java.util.concurrent.locks.StampedLock;

/*
 * StampedLock
 *
 * Introduced in Java 8.
 *
 * Provides three locking modes:
 *
 * 1. Read Lock
 * 2. Write Lock
 * 3. Optimistic Read
 *
 * Unlike ReentrantLock and ReadWriteLock,
 * StampedLock returns a stamp (long value)
 * when a lock is acquired.
 *
 * This stamp is required while unlocking.
 */

class SharedResource {

    private int value = 100;

    private final StampedLock lock =
            new StampedLock();

    /* =====================================================
       PESSIMISTIC READ LOCK
       ===================================================== */

    public void read() {

        /*
         * readLock()
         *
         * Acquires a read lock.
         * Multiple readers allowed.
         */

        long stamp = lock.readLock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Reading Value = "
                            + value
            );

        } finally {

            /*
             * Unlock using stamp.
             */

            lock.unlockRead(stamp);
        }
    }

    /* =====================================================
       WRITE LOCK
       ===================================================== */

    public void write(int newValue) {

        /*
         * writeLock()
         *
         * Exclusive access.
         */

        long stamp = lock.writeLock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Updating Value"
            );

            value = newValue;

        } finally {

            lock.unlockWrite(stamp);
        }
    }

    /* =====================================================
       OPTIMISTIC READ
       ===================================================== */

    public void optimisticRead() {

        /*
         * tryOptimisticRead()
         *
         * Does NOT acquire an actual lock.
         *
         * Returns a stamp representing
         * current state.
         */

        long stamp =
                lock.tryOptimisticRead();

        int currentValue = value;

        /*
         * validate()
         *
         * Checks whether a write occurred
         * after obtaining the stamp.
         */

        if (!lock.validate(stamp)) {

            /*
             * Data changed.
             *
             * Fallback to proper read lock.
             */

            stamp = lock.readLock();

            try {

                currentValue = value;

            } finally {

                lock.unlockRead(stamp);
            }
        }

        System.out.println(
                Thread.currentThread().getName()
                        + " Read Value = "
                        + currentValue
        );
    }
}

public class StampedLockDemo {

    public static void main(String[] args) {

        SharedResource resource =
                new SharedResource();

        Thread reader =
                new Thread(
                        resource::read,
                        "Reader"
                );

        Thread optimisticReader =
                new Thread(
                        resource::optimisticRead,
                        "OptimisticReader"
                );

        Thread writer =
                new Thread(
                        () -> resource.write(500),
                        "Writer"
                );

        reader.start();
        optimisticReader.start();
        writer.start();
    }
}

/*
 * =====================================================
 * STAMPED LOCK
 * =====================================================
 *
 * Lock Types:
 *
 * 1. Read Lock
 * 2. Write Lock
 * 3. Optimistic Read
 *
 *
 * Important Methods
 * -----------------
 *
 * readLock()
 * writeLock()
 * tryOptimisticRead()
 * validate()
 *
 *
 * =====================================================
 * PESSIMISTIC LOCKING
 * =====================================================
 *
 * Assumption:
 * Conflict WILL happen.
 *
 * Therefore acquire lock first.
 *
 * Example:
 * - synchronized
 * - ReentrantLock
 * - ReadWriteLock
 * - StampedLock Read Lock
 * - StampedLock Write Lock
 *
 *
 * Flow:
 *
 * Acquire Lock
 *      ↓
 * Access Data
 *      ↓
 * Release Lock
 *
 *
 * Advantages:
 * - Safe
 * - No inconsistency
 *
 * Disadvantages:
 * - More blocking
 * - Less concurrency
 *
 *
 * =====================================================
 * OPTIMISTIC LOCKING
 * =====================================================
 *
 * Assumption:
 * Conflict is RARE.
 *
 * Read data WITHOUT locking.
 *
 * Later verify whether data changed.
 *
 *
 * Flow:
 *
 * Read Data
 *      ↓
 * Validate
 *      ↓
 * If invalid -> Retry with lock
 *
 *
 * Advantages:
 * - Better performance
 * - Less blocking
 * - High concurrency
 *
 * Disadvantages:
 * - Retry may be required
 *
 *
 * =====================================================
 * STAMPED LOCK OPTIMISTIC READ
 * =====================================================
 *
 * tryOptimisticRead()
 *      ↓
 * Read Data
 *      ↓
 * validate(stamp)
 *
 * true
 *      ↓
 * Use Data
 *
 * false
 *      ↓
 * Acquire Read Lock
 *      ↓
 * Read Again
 *
 *
 * =====================================================
 * INTERVIEW QUESTIONS
 * =====================================================
 *
 * Q. Difference between ReadWriteLock
 *    and StampedLock?
 *
 * ReadWriteLock:
 * - Read Lock
 * - Write Lock
 *
 * StampedLock:
 * - Read Lock
 * - Write Lock
 * - Optimistic Read
 *
 *
 * Q. Why is StampedLock faster?
 *
 * Because optimistic reads can
 * avoid acquiring actual locks.
 *
 *
 * Q. Is StampedLock reentrant?
 *
 * NO
 *
 * ReentrantLock and
 * ReentrantReadWriteLock are reentrant.
 *
 * StampedLock is NOT reentrant.
 */