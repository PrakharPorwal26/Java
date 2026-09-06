package LockFreeConcurrency;

import java.util.concurrent.atomic.AtomicReference;

class User {

    String name;

    User(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args) {

        User user1 =
                new User("Prakhar");

        User user2 =
                new User("Rahul");

        /*
         * AtomicReference
         *
         * Atomic operations on objects.
         */

        AtomicReference<User> ref =
                new AtomicReference<>(user1);

        System.out.println(ref.get());

        ref.set(user2);

        System.out.println(ref.get());

        /*
         * compareAndSet()
         */

        boolean success =
                ref.compareAndSet(
                        user2,
                        user1
                );

        System.out.println(success);

        System.out.println(ref.get());
    }
}

/*
 * AtomicReference
 *
 * Atomic operations on references.
 *
 * Useful when multiple threads
 * update object references.
 */