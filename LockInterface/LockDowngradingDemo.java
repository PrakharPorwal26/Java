package LockInterface;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Lock Downgrading
 *
 * Definition:
 * Converting a Write Lock into a Read Lock
 * without completely releasing access to
 * the shared resource.
 *
 * Steps:
 * 1. Acquire Write Lock
 * 2. Perform update
 * 3. Acquire Read Lock
 * 4. Release Write Lock
 *
 * After downgrading:
 * - Thread continues reading safely.
 * - Other readers may enter.
 * - Writers must still wait.
 */

class SharedData {

    private int value = 0;

    private final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();

    public void updateAndRead() {

        /*
         * Acquire Write Lock
         */

        lock.writeLock().lock();

        try {

            value++;

            System.out.println(
                    Thread.currentThread().getName()
                            + " Updated Value = "
                            + value
            );

            /*
             * Lock Downgrading
             *
             * Acquire Read Lock while still
             * holding Write Lock.
             */

            lock.readLock().lock();

        } finally {

            /*
             * Release Write Lock
             *
             * Thread still holds Read Lock.
             */

            lock.writeLock().unlock();
        }

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Reading Value = "
                            + value
            );

        } finally {

            lock.readLock().unlock();
        }
    }
}

public class LockDowngradingDemo {

    public static void main(String[] args) {

        SharedData data =
                new SharedData();

        Thread t1 = new Thread(
                data::updateAndRead,
                "Thread-1"
        );

        Thread t2 = new Thread(
                data::updateAndRead,
                "Thread-2"
        );

        t1.start();
        t2.start();
    }
}

/*
 * =====================================================
 * LOCK DOWNGRADING
 * =====================================================
 *
 * Write Lock
 *      ↓
 * Read Lock
 *
 * Supported by ReentrantReadWriteLock.
 *
 *
 * Why do we need it?
 * ------------------
 *
 * Common Scenario:
 *
 * 1. Thread updates data.
 * 2. Immediately needs to read
 *    the updated data.
 *
 * Instead of:
 *
 * write unlock
 *      ↓
 * read lock
 *
 * Another writer may modify data
 * in between.
 *
 *
 * Lock Downgrading prevents this.
 *
 *
 * Correct Sequence
 * ----------------
 *
 * Acquire Write Lock
 *      ↓
 * Update Data
 *      ↓
 * Acquire Read Lock
 *      ↓
 * Release Write Lock
 *      ↓
 * Read Data
 *
 *
 * Advantages
 * ----------
 * - Maintains consistency
 * - Avoids race conditions
 * - Allows other readers to enter
 * - Writers still remain blocked
 *
 *
 * Interview Question
 * ------------------
 * Is Lock Downgrading allowed?
 *
 * YES
 *
 *
 * Is Lock Upgrading allowed?
 *
 * Read Lock -> Write Lock
 *
 * NO (can lead to deadlock)
 */