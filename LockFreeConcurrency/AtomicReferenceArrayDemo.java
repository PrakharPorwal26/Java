package LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayDemo {

    public static void main(String[] args) {

        /*
         * AtomicReferenceArray
         *
         * Atomic operations on array elements.
         */

        AtomicReferenceArray<String> array =
                new AtomicReferenceArray<>(3);

        array.set(0, "Java");
        array.set(1, "Spring");
        array.set(2, "Kafka");

        System.out.println(
                array.get(0)
        );

        /*
         * compareAndSet()
         */

        boolean success =
                array.compareAndSet(
                        1,
                        "Spring",
                        "Spring Boot"
                );

        System.out.println(success);

        System.out.println(
                array.get(1)
        );
    }
}

/*
 * AtomicReferenceArray
 *
 * Atomic operations on individual
 * array elements.
 *
 * Methods:
 * get(index)
 * set(index,value)
 * compareAndSet(index,expected,newValue)
 */