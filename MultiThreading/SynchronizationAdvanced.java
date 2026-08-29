package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {

    private int balance = 1000;

    /*
     * Custom Lock
     *
     * More flexible than synchronized.
     */

    private final Lock lock =
            new ReentrantLock();

    public void withdraw(int amount) {

        lock.lock();

        try {

            if (balance >= amount) {

                balance -= amount;

                System.out.println(
                        Thread.currentThread().getName()
                                + " Withdrawn: "
                                + amount
                );
            }

        } finally {

            lock.unlock();
        }
    }
}

class Printer {

    /*
     * Static Synchronization
     *
     * Lock acquired on Class object.
     *
     * Printer.class monitor lock.
     */

    public static synchronized void print() {

        System.out.println(
                Thread.currentThread().getName()
        );
    }
}

public class SynchronizationAdvanced {

    private final Object lock =
            new Object();

    public void criticalSection() {

        /*
         * Synchronized Block
         *
         * Lock only the critical section
         * instead of entire method.
         */

        synchronized (lock) {

            System.out.println(
                    "Critical Section"
            );
        }

        /*
         * Non-critical code executes
         * without locking.
         */
    }

    public static void main(String[] args) {

        Account account = new Account();

        Thread t1 =
                new Thread(
                        () -> account.withdraw(500),
                        "T1"
                );

        Thread t2 =
                new Thread(
                        () -> account.withdraw(500),
                        "T2"
                );

        t1.start();
        t2.start();

        Printer.print();
    }
}

/*
 * synchronized method
 * -------------------
 * Locks entire method.
 *
 *
 * synchronized block
 * ------------------
 * Locks only required code.
 *
 *
 * static synchronized
 * -------------------
 * Lock = Class Object
 *
 * Example:
 * Printer.class
 *
 *
 * ReentrantLock
 * -------------
 * Custom lock implementation.
 *
 * Advantages:
 * - tryLock()
 * - fairness policy
 * - explicit unlock()
 * - more control than synchronized
 */