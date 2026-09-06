package LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {

    public static void main(String[] args) {

        AtomicLong count =
                new AtomicLong(100);

        System.out.println(count.get());

        count.incrementAndGet();

        count.addAndGet(500);

        System.out.println(count.get());

        /*
         * compareAndSet()
         */

        count.compareAndSet(
                601,
                1000
        );

        System.out.println(count.get());
    }
}

/*
 * AtomicLong
 *
 * Same API as AtomicInteger.
 *
 * Difference:
 * Uses long instead of int.
 */