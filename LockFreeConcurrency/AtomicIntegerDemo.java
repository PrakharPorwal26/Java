package LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) {

        /*
         * AtomicInteger
         *
         * Provides atomic operations on int.
         *
         * Internally uses CAS
         * (Compare And Set).
         */

        AtomicInteger counter =
                new AtomicInteger(10);

        System.out.println(counter.get());

        counter.set(20);

        System.out.println(counter.get());

        /*
         * incrementAndGet()
         *
         * Increment first.
         * Return updated value.
         */

        System.out.println(
                counter.incrementAndGet()
        );

        /*
         * getAndIncrement()
         *
         * Return current value.
         * Then increment.
         */

        System.out.println(
                counter.getAndIncrement()
        );

        /*
         * decrementAndGet()
         */

        System.out.println(
                counter.decrementAndGet()
        );

        /*
         * addAndGet()
         */

        System.out.println(
                counter.addAndGet(5)
        );

        /* ---------- CAS ---------- */

        /*
         * compareAndSet(expected, update)
         *
         * If current value equals expected:
         *      update value
         *      return true
         *
         * Else:
         *      return false
         */

        boolean result =
                counter.compareAndSet(
                        25,
                        100
                );

        System.out.println(result);

        System.out.println(counter.get());
    }
}

/*
 * CAS (Compare And Set)
 * ---------------------
 *
 * Read current value
 *      ↓
 * Compare with expected
 *      ↓
 * If equal:
 *      Update
 *
 * If not equal:
 *      Fail
 *
 *
 * Example:
 *
 * Current = 25
 *
 * compareAndSet(25,100)
 *
 * Result:
 * Current = 100
 *
 *
 * Why CAS?
 * --------
 *
 * Lock-Free Synchronization
 *
 * No synchronized
 * No ReentrantLock
 */