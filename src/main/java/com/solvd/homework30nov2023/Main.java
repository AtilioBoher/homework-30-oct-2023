package com.solvd.homework30nov2023;

import com.solvd.homework30nov2023.model.threads.ConnectionPool;
import com.solvd.homework30nov2023.model.threads.ConnectionThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        homework2023dic7();

    }

    private static void homework2023dic7() {
        ConnectionPool connectionPool = ConnectionPool.create();

        // ----------------------IMPORTANT NOTE-----------------------------------
        // Both Classes do the same thing, the only differences is that
        // ConcurrentThread is defined implementing the Runnable interface and
        // ConcurrentThread2 is defined extending the Thread Class.

        ConnectionThread thread = new ConnectionThread(connectionPool);
//        ConnectionThread2 thread = new ConnectionThread2(connectionPool);

        // ----------------------------------------------------------------------

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        for (int i = 0; i < 7; i++)
            executorService.execute(thread);
        executorService.shutdown();
        boolean terminatedCorrectly;
        try {
            terminatedCorrectly = executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (terminatedCorrectly) {
            LOGGER.info("-------Lets read the values collected in our CopyOnWriteArrayList------- ");
            String[] values = thread.readValues();
            for (String value : values) {
                LOGGER.info(value);
            }
        } else {
            LOGGER.info("Threads didn't execute correctly");
        }

    }
}
