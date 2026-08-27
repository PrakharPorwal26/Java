package MultiThreading;

/*
 * There are two traditional ways to create a thread in Java:
 *
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 *
 * Runnable is generally preferred because Java supports
 * single inheritance. If a class already extends another
 * class, it cannot extend Thread.
 */

/* =====================================================
   USING THREAD CLASS
   ===================================================== */

class MyThread extends Thread {

    @Override
    public void run() {

        /*
         * Thread.currentThread()
         * ----------------------
         * Static method of Thread class.
         *
         * Returns the thread that is currently executing.
         */

        Thread current = Thread.currentThread();

        /*
         * getName()
         * ---------
         * Returns the name of the current thread.
         */

        System.out.println(
                "Currently Executing Thread: "
                        + current.getName()
        );

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    current.getName() + " : " + i
            );
        }
    }
}

/* =====================================================
   USING RUNNABLE INTERFACE
   ===================================================== */

class MyRunnable implements Runnable {

    /*
     * Runnable is a Functional Interface.
     *
     * It contains only one abstract method:
     *
     *      void run()
     */

    @Override
    public void run() {

        System.out.println(
                "Currently Executing Thread: "
                        + Thread.currentThread().getName()
        );

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + i
            );
        }
    }
}

public class ThreadCreation {

    public static void main(String[] args) {

        /* =====================================================
           MAIN THREAD
           ===================================================== */

        /*
         * Every Java program starts with a thread
         * called the "main" thread.
         */

        System.out.println(
                "Main Thread: "
                        + Thread.currentThread().getName()
        );


        /* =====================================================
           1. CREATING THREAD USING THREAD CLASS
           ===================================================== */

        MyThread t1 = new MyThread();

        /*
         * setName()
         * ---------
         * Changes the thread name.
         *
         * Useful for debugging and logging.
         */

        t1.setName("Thread-Class");

        /*
         * start()
         * -------
         * Creates a new thread.
         *
         * JVM internally invokes run().
         *
         * Never call run() directly if you want
         * concurrent execution.
         */

        t1.start();


        /* =====================================================
           2. CREATING THREAD USING RUNNABLE INTERFACE
           ===================================================== */

        MyRunnable task = new MyRunnable();

        /*
         * Runnable only contains the task.
         *
         * To execute it, we pass the Runnable
         * object to a Thread object.
         */

        Thread t2 = new Thread(task);

        t2.setName("Runnable-Thread");

        t2.start();


        /* =====================================================
           3. USING LAMBDA EXPRESSION
           =====================================================
         */

        Thread t3 = new Thread(() -> {

            System.out.println(
                    "Currently Executing Thread: "
                            + Thread.currentThread().getName()
            );

            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        Thread.currentThread().getName()
                                + " : " + i
                );
            }
        });

        t3.setName("Lambda-Thread");

        t3.start();
    }
}

/*
 * =====================================================
 * QUICK NOTES
 * =====================================================
 *
 * Ways to Create Thread:
 *
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 3. Lambda Expression (Runnable)
 *
 *
 * Thread.currentThread()
 * ----------------------
 * Returns the currently executing thread.
 *
 * Example:
 * Thread.currentThread()
 *
 *
 * getName()
 * ---------
 * Returns the thread name.
 *
 * Example:
 * t1.getName()
 *
 *
 * setName()
 * ---------
 * Changes the thread name.
 *
 * Example:
 * t1.setName("Worker-1")
 *
 *
 * start()
 * -------
 * Creates a new thread and invokes run().
 *
 *
 * run()
 * -----
 * Contains the task executed by the thread.
 *
 *
 * start() vs run()
 * ----------------
 *
 * t.start()
 * -> Creates a NEW thread.
 * -> Executes run() on that new thread.
 *
 * t.run()
 * -> No new thread is created.
 * -> Executes like a normal method call
 *    on the current thread.
 *
 *
 * Which is better?
 * ----------------
 * Runnable Interface is generally preferred because:
 *
 * - Supports inheritance from another class.
 * - Separates task from thread.
 * - Better design and reusability.
 */