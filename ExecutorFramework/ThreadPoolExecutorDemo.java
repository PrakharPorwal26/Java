package ExecutorFramework;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        try (ExecutorService executor =
                     new ThreadPoolExecutor(
                             2,                      // corePoolSize
                             4,                      // maximumPoolSize
                             10,                     // keepAliveTime
                             TimeUnit.SECONDS,
                             new ArrayBlockingQueue<>(10)
                     )) {

            for (int i = 1; i <= 8; i++) {

                int taskId = i;

                executor.submit(() -> {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " executing Task "
                                    + taskId
                    );

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}