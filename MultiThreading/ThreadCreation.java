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

class MyThread extends Thread {

    /*
     * run()
     * -----
     * Contains the task that will be executed by the new thread.
     *
     * Thread class internally calls run() when start() is invoked.
     */

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    "Thread Class: " + i
            );
        }
    }
}

class MyRunnable implements Runnable {

    /*
     * Runnable is a Functional Interface.
     *
     * It contains only one abstract method:
     *
     *      void run()
     *
     * The task to be executed by the thread is written
     * inside this method.
     */

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    "Runnable Interface: " + i
            );
        }
    }
}

public class ThreadCreation {

    public static void main(String[] args) {

        /* =====================================================
           1. CREATING THREAD USING THREAD CLASS
           ===================================================== */

        MyThread t1 = new MyThread();

        /*
         * start()
         * -------
         * Creates a new thread and then calls run().
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
         * Runnable only defines the task.
         *
         * To execute it, we must pass the Runnable
         * object to a Thread object.
         */

        Thread t2 = new Thread(task);

        t2.start();


        /* =====================================================
           USING LAMBDA EXPRESSION
           =====================================================
         */

        Thread t3 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        "Lambda Thread: " + i
                );
            }

        });

        t3.start();
    }
}

/*
 * =====================================================
 * DIFFERENCE BETWEEN THREAD CLASS & RUNNABLE INTERFACE
 * =====================================================
 *
 * Thread Class
 * ------------
 * class MyThread extends Thread
 *
 * Pros:
 * - Simple to understand.
 *
 * Cons:
 * - Consumes the only inheritance opportunity.
 * - Tight coupling between task and thread.
 *
 *
 * Runnable Interface
 * ------------------
 * class MyRunnable implements Runnable
 *
 * Pros:
 * - Preferred approach.
 * - Supports inheritance from another class.
 * - Separates task from thread.
 * - Better design and reusability.
 *
 * Cons:
 * - Slightly more code.
 *
 *
 * Interview Question:
 * Which is better?
 *
 * Runnable Interface is generally preferred because
 * it promotes better object-oriented design and
 * avoids the limitation of single inheritance.
 */