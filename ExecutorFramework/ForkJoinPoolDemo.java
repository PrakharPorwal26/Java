package ExecutorFramework;

import java.util.concurrent.*;

/* =====================================================
   RecursiveTask
   ===================================================== */

/*
 * RecursiveTask<V>
 *
 * Used when task returns a result.
 */

class SumTask extends RecursiveTask<Integer> {

    private final int start;
    private final int end;

    public SumTask(int start, int end) {

        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        /*
         * Base Condition
         */

        if ((end - start) <= 5) {

            int sum = 0;

            for (int i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }

        /*
         * Divide Task
         */

        int mid =
                (start + end) / 2;

        SumTask left =
                new SumTask(start, mid);

        SumTask right =
                new SumTask(mid + 1, end);

        /*
         * fork()
         *
         * Submit subtask asynchronously.
         */

        left.fork();

        /*
         * Current thread computes right.
         */

        int rightResult =
                right.compute();

        /*
         * join()
         *
         * Wait for forked task result.
         */

        int leftResult =
                left.join();

        return leftResult + rightResult;
    }
}

/* =====================================================
   RecursiveAction
   ===================================================== */

/*
 * RecursiveAction
 *
 * Used when task does NOT return result.
 */

class PrintTask extends RecursiveAction {

    private final int start;
    private final int end;

    public PrintTask(int start, int end) {

        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if ((end - start) <= 3) {

            for (int i = start; i <= end; i++) {

                System.out.println(i);
            }

            return;
        }

        int mid =
                (start + end) / 2;

        invokeAll(
                new PrintTask(start, mid),
                new PrintTask(mid + 1, end)
        );
    }
}

public class ForkJoinPoolDemo {

    public static void main(String[] args) {

    /*
     * ForkJoinPool
     *
     * Implements Divide and Conquer.
     */

    try (ForkJoinPool pool =
                 new ForkJoinPool()) {

        /* ---------- RecursiveTask ---------- */

        SumTask task =
                new SumTask(1, 100);

        Integer result =
                pool.invoke(task);

        System.out.println(
                "Sum = " + result
        );

        /* ---------- RecursiveAction ---------- */

        PrintTask printTask =
                new PrintTask(1, 10);

        pool.invoke(printTask);
    }
}
}

/*
 * =====================================================
 * FORK JOIN POOL
 * =====================================================
 *
 * Designed for:
 * Divide and Conquer Algorithms
 *
 *
 * Working:
 *
 * Big Task
 *     ↓
 * Divide into Smaller Tasks
 *     ↓
 * Execute in Parallel
 *     ↓
 * Combine Results
 *
 *
 * RecursiveTask<V>
 * ----------------
 * Returns result.
 *
 * compute()
 * fork()
 * join()
 *
 *
 * RecursiveAction
 * ---------------
 * No return value.
 *
 *
 * fork()
 * ------
 * Submit subtask asynchronously.
 *
 *
 * join()
 * ------
 * Wait for result.
 *
 *
 * invoke()
 * --------
 * Start execution.
 *
 *
 * Common Use Cases:
 * -----------------
 * - Parallel Merge Sort
 * - Parallel Search
 * - Parallel Sum
 * - Divide and Conquer Problems
 */