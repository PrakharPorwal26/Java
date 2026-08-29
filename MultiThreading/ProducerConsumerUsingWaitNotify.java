package MultiThreading;

class SharedBuffer {

    private int data;

    private boolean hasValue = false;

    public synchronized void produce(int value)
            throws InterruptedException {

        /*
         * If buffer already contains data,
         * producer should wait.
         */

        while (hasValue) {

            /*
             * wait()
             *
             * Releases monitor lock.
             * Moves thread to WAITING state.
             */

            wait();
        }

        data = value;
        hasValue = true;

        System.out.println(
                "Produced: " + value
        );

        /*
         * notify()
         *
         * Wakes up one waiting thread.
         */

        notify();
    }

    public synchronized void consume()
            throws InterruptedException {

        /*
         * If buffer is empty,
         * consumer should wait.
         */

        while (!hasValue) {

            wait();
        }

        System.out.println(
                "Consumed: " + data
        );

        hasValue = false;

        notify();
    }
}

public class ProducerConsumerUsingWaitNotify {

    public static void main(String[] args) {

        SharedBuffer buffer =
                new SharedBuffer();

        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {

                    buffer.produce(i);

                    Thread.sleep(1000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {

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