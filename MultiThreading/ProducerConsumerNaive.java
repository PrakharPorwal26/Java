package MultiThreading;

class Buffer {

    private int data;
    private boolean hasValue = false;

    public void produce(int value) {

        /*
         * Busy Waiting
         *
         * Continuously checking condition
         * inside a loop.
         */

        while (hasValue) {

            // Do nothing
        }

        data = value;
        hasValue = true;

        System.out.println(
                "Produced: " + value
        );
    }

    public int consume() {

        while (!hasValue) {

            // Do nothing
        }

        hasValue = false;

        System.out.println(
                "Consumed: " + data
        );

        return data;
    }
}

public class ProducerConsumerNaive {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }

        });

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                buffer.consume();
            }

        });

        producer.start();
        consumer.start();
    }
}

/*
 * Problem with Busy Waiting
 *
 * Thread keeps running even when
 * it cannot proceed.
 *
 * Wastes CPU cycles.
 *
 * Thread continuously checks condition:
 *
 * while(condition){
 * }
 *
 * This is called Busy Waiting.
 */