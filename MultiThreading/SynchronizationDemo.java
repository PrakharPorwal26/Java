package MultiThreading;

class Counter {

    private int count = 0;

    /*
     * synchronized method
     *
     * Every Java object has an intrinsic
     * lock (Monitor Lock).
     *
     * Only one thread can execute any
     * synchronized method on the same
     * object at a time.
     */

    public synchronized void increment() {

        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizationDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }

        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}

/*
 * Monitor Lock Problem
 *
 * Entire method becomes locked.
 *
 * Even if only a small portion
 * requires synchronization,
 * other threads must still wait.
 *
 * This reduces concurrency.
 */