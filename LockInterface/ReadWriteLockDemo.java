package LockInterface;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Reader Writer Problem
 *
 * Scenario:
 * Multiple threads want to read data.
 * Some threads want to modify (write) data.
 *
 * Requirements:
 * 1. Multiple readers should be allowed simultaneously.
 * 2. Only one writer should be allowed at a time.
 * 3. While writing, no reader should access the data.
 *
 * Problem with synchronized:
 * Even readers block each other although
 * they are only reading data.
 *
 * ReadWriteLock solves this problem.
 */

class SharedResource {

    private int value = 100;

    /*
     * ReadWriteLock
     *
     * Provides:
     * 1. Read Lock
     * 2. Write Lock
     */

    private final ReadWriteLock lock =
            new ReentrantReadWriteLock();

    public void read() {

        /*
         * readLock()
         *
         * Multiple threads can acquire
         * read lock simultaneously.
         */

        lock.readLock().lock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Reading Value = "
                            + value
            );

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            lock.readLock().unlock();
        }
    }

    public void write(int newValue) {

        /*
         * writeLock()
         *
         * Exclusive lock.
         *
         * Only one writer allowed.
         * No readers allowed while writing.
         */

        lock.writeLock().lock();

        try {

            System.out.println(
                    Thread.currentThread().getName()
                            + " Writing Value = "
                            + newValue
            );

            Thread.sleep(2000);

            value = newValue;

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            lock.writeLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        SharedResource resource =
                new SharedResource();

        Thread reader1 = new Thread(
                resource::read,
                "Reader-1"
        );

        Thread reader2 = new Thread(
                resource::read,
                "Reader-2"
        );

        Thread reader3 = new Thread(
                resource::read,
                "Reader-3"
        );

        Thread writer = new Thread(
                () -> resource.write(500),
                "Writer-1"
        );

        /*
         * All readers can execute together.
         */

        reader1.start();
        reader2.start();
        reader3.start();

        /*
         * Writer will wait until all readers
         * release the read lock.
         */

        writer.start();
    }
}

/*
 * =====================================================
 * READWRITELOCK
 * =====================================================
 *
 * Interface:
 * ReadWriteLock
 *
 * Implementation:
 * ReentrantReadWriteLock
 *
 *
 * Provides Two Locks:
 *
 * 1. Read Lock
 * -------------
 * lock.readLock()
 *
 * Multiple readers allowed simultaneously.
 *
 *
 * 2. Write Lock
 * --------------
 * lock.writeLock()
 *
 * Exclusive lock.
 *
 * Only one writer allowed.
 *
 *
 * =====================================================
 * READER WRITER PROBLEM
 * =====================================================
 *
 * Multiple readers should be allowed.
 *
 * Writers require exclusive access.
 *
 * Readers should not block other readers.
 *
 * Writers should block readers and writers.
 *
 *
 * =====================================================
 * WHY NOT SYNCHRONIZED?
 * =====================================================
 *
 * synchronized allows only one thread
 * at a time.
 *
 * Even readers block each other.
 *
 * This reduces concurrency.
 *
 *
 * =====================================================
 * ADVANTAGE OF READWRITELOCK
 * =====================================================
 *
 * Better performance when:
 * - Reads are frequent
 * - Writes are infrequent
 *
 * Example:
 * Database
 * Cache
 * Configuration Store
 * Product Catalog
 *
 *
 * =====================================================
 * LOCK BEHAVIOR
 * =====================================================
 *
 * Read + Read
 *      Allowed
 *
 * Read + Write
 *      Not Allowed
 *
 * Write + Write
 *      Not Allowed
 *
 * Write + Read
 *      Not Allowed
 */