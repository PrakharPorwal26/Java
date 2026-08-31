package LockInterface;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Condition Interface
 *
 * Condition works with Lock interface
 * similar to how wait(), notify() and
 * notifyAll() work with synchronized.
 *
 * Relationship:
 *
 * synchronized  <-> wait(), notify(), notifyAll()
 *
 * ReentrantLock <-> Condition
 *
 *
 * Important Methods:
 * ------------------
 * await()
 * signal()
 * signalAll()
 */

class SharedBuffer {

    private int data;

    private boolean hasValue = false;

    /*
     * Custom Lock
     */

    private final Lock lock =
            new ReentrantLock();

    /*
     * Condition Object
     *
     * Created using lock.newCondition()
     */

    private final Condition condition =
            lock.newCondition();

    /* =====================================================
       PRODUCER
       ===================================================== */

    public void produce(int value)
            throws InterruptedException {

        lock.lock();

        try {

            /*
             * If buffer already contains data,
             * producer must wait.
             */

            while (hasValue) {

                /*
                 * await()
                 *
                 * Similar to wait().
                 *
                 * Releases lock and moves
                 * thread to waiting state.
                 */

                condition.await();
            }

            data = value;

            hasValue = true;

            System.out.println(
                    "Produced: " + value
            );

            /*
             * signal()
             *
             * Similar to notify().
             *
             * Wakes up one waiting thread.
             */

            condition.signal();

        } finally {

            lock.unlock();
        }
    }

    /* =====================================================
       CONSUMER
       ===================================================== */

    public void consume()
            throws InterruptedException {

        lock.lock();

        try {

            /*
             * If buffer empty,
             * consumer waits.
             */

            while (!hasValue) {

                condition.await();
            }

            System.out.println(
                    "Consumed: " + data
            );

            hasValue = false;

            condition.signal();

        } finally {

            lock.unlock();
        }
    }
}

public class ConditionInterfaceDemo {

    public static void main(String[] args) {

        SharedBuffer buffer =
                new SharedBuffer();

        Thread producer =
                new Thread(() -> {

                    try {

                        for (int i = 1; i <= 5; i++) {

                            buffer.produce(i);

                            Thread.sleep(1000);
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                });

        Thread consumer =
                new Thread(() -> {

                    try {

                        for (int i = 1; i <= 5; i++) {

                            buffer.consume();
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                });

        producer.start();
        consumer.start();
    }
}

/*
 * =====================================================
 * CONDITION INTERFACE
 * =====================================================
 *
 * Package:
 * java.util.concurrent.locks
 *
 * Works with Lock implementations.
 *
 *
 * Creating Condition
 * ------------------
 *
 * Lock lock =
 *      new ReentrantLock();
 *
 * Condition condition =
 *      lock.newCondition();
 *
 *
 * =====================================================
 * await()
 * =====================================================
 *
 * Similar to wait().
 *
 * Releases lock.
 *
 * Thread enters waiting state.
 *
 * Must be called while holding lock.
 *
 *
 * =====================================================
 * signal()
 * =====================================================
 *
 * Similar to notify().
 *
 * Wakes up one waiting thread.
 *
 *
 * =====================================================
 * signalAll()
 * =====================================================
 *
 * Similar to notifyAll().
 *
 * Wakes up all waiting threads.
 *
 *
 * =====================================================
 * wait/notify vs Condition
 * =====================================================
 *
 * wait()
 * notify()
 * notifyAll()
 *      ↓
 * synchronized
 *
 *
 * await()
 * signal()
 * signalAll()
 *      ↓
 * ReentrantLock
 *
 *
 * =====================================================
 * ADVANTAGE OF CONDITION
 * =====================================================
 *
 * Multiple Condition objects can be
 * created for the same lock.
 *
 * More flexible than wait()/notify().
 */