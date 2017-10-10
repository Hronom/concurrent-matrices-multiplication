package com.github.hronom.concurrentmatricesmultiplication;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadedMatrixMultiplier implements AutoCloseable {
    private final ExecutorService executorService;

    public ThreadedMatrixMultiplier(int amountThreads) {
        executorService = Executors.newFixedThreadPool(amountThreads);
    }

    @Override
    public void close() throws Exception {
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }

    public IntMatrix mul(IntMatrix a, IntMatrix b)
        throws MatricesMulException {
        try {
            int size = a.getRowLength();
            Integer[][] resultMatrixData = new Integer[size][size];

            LinkedList<Future> taskFutures = new LinkedList<>();
            for (int rowResult = 0; rowResult < a.getRowLength(); rowResult++) {
                final int finalRowResult = rowResult;
                for (int columnResult = 0; columnResult < a.getRowLength(); columnResult++) {
                    final int finalColumnResult = columnResult;
                    resultMatrixData[finalRowResult][finalColumnResult] = 0;
                    taskFutures.add(executorService.submit(() -> {
                        for (int i = 0; i < a.getRowLength(); i++) {
                            resultMatrixData[finalRowResult][finalColumnResult] +=
                                a.getCell(finalRowResult, i) * b.getCell(i, finalColumnResult);
                        }
                    }));
                }
            }

            // Wait for all tasks to complete
            for (Future taskFuture : taskFutures) {
                taskFuture.get();
            }

            return MatrixBuilder.createIntegerSquareMatrix(resultMatrixData);
        } catch (Exception e){
            throw new MatricesMulException(e);
        }
    }
}
