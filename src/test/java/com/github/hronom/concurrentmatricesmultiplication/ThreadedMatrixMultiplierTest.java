package com.github.hronom.concurrentmatricesmultiplication;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ThreadedMatrixMultiplierTest {
    private ThreadedMatrixMultiplier threadedMatrixMultiplier;


    @Before
    public void setUp() throws Exception {
        threadedMatrixMultiplier = new ThreadedMatrixMultiplier(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void mul1() throws Exception {
        IntMatrix a =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {2},
                1
            );

        IntMatrix b =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {2},
                1
            );

        IntMatrix result = threadedMatrixMultiplier.mul(a, b);
        MatrixPrinter.print(result);
        assertEquals(4, (int) result.getCell(0, 0));
    }

    @Test
    public void mul2() throws Exception {
        IntMatrix a =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {1, 2, 3, 4},
                2
            );

        IntMatrix b =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {5, 6, 7, 8},
                2
            );

        IntMatrix result = threadedMatrixMultiplier.mul(a, b);
        MatrixPrinter.print(result);
        assertEquals(19, (int) result.getCell(0, 0));
        assertEquals(22, (int) result.getCell(0, 1));
        assertEquals(43, (int) result.getCell(1, 0));
        assertEquals(50, (int) result.getCell(1, 1));
    }

    @Test
    public void mul3() throws Exception {
        IntMatrix a =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9},
                3
            );

        IntMatrix b =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                new Integer[] {10, 11, 12, 13, 14, 15, 16, 17, 18},
                3
            );

        IntMatrix result = threadedMatrixMultiplier.mul(a, b);
        MatrixPrinter.print(result);
        assertEquals(84, (int) result.getCell(0, 0));
        assertEquals(90, (int) result.getCell(0, 1));
        assertEquals(96, (int) result.getCell(0, 2));
        assertEquals(201, (int) result.getCell(1, 0));
        assertEquals(216, (int) result.getCell(1, 1));
        assertEquals(231, (int) result.getCell(1, 2));
        assertEquals(318, (int) result.getCell(2, 0));
        assertEquals(342, (int) result.getCell(2, 1));
        assertEquals(366, (int) result.getCell(2, 2));
    }
}