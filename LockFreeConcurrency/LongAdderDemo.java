package LockFreeConcurrency;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {

    public static void main(String[] args) {

        /*
         * LongAdder
         *
         * Better than AtomicLong
         * under high contention.
         */

        LongAdder adder =
                new LongAdder();

        adder.increment();

        adder.increment();

        adder.add(100);

        /*
         * sum()
         *
         * Returns total value.
         */

        System.out.println(
                adder.sum()
        );

        /*
         * reset()
         */

        adder.reset();

        System.out.println(
                adder.sum()
        );
    }
}

/*
 * AtomicLong vs LongAdder
 * -----------------------
 *
 * AtomicLong:
 * One CAS location.
 *
 * LongAdder:
 * Multiple internal counters.
 *
 * Better scalability.
 *
 * Preferred for:
 * High-frequency counters.
 */