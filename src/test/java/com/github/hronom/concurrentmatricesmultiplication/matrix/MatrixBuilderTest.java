package com.github.hronom.concurrentmatricesmultiplication.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixBuilderTest {
    @Test
    public void createIntegerSquareMatrixFromArray1() throws Exception {
        IntMatrix intMatrix =
            MatrixBuilder
                .createIntegerSquareMatrixFromArray(new Integer[] {3}, 1);
        assertEquals(3, (int) intMatrix.getCell(0, 0));
    }

    @Test
    public void createIntegerSquareMatrixFromArray2() throws Exception {
        IntMatrix intMatrix =
            MatrixBuilder
                .createIntegerSquareMatrixFromArray(new Integer[] {1, 2, 3, 4}, 2);
        assertEquals(1, (int) intMatrix.getCell(0, 0));
        assertEquals(2, (int) intMatrix.getCell(0, 1));
        assertEquals(3, (int) intMatrix.getCell(1, 0));
        assertEquals(4, (int) intMatrix.getCell(1, 1));
    }

    @Test(expected = MatrixDataEmptyException.class)
    public void createIntegerSquareMatrix1() throws Exception {
        MatrixBuilder.createIntegerSquareMatrix(new Integer[0][]);
    }

    @Test(expected = MatrixDataEmptyException.class)
    public void createIntegerSquareMatrix2() throws Exception {
        MatrixBuilder.createIntegerSquareMatrix(new Integer[1][0]);
    }

    @Test
    public void createIntegerSquareMatrix3() throws Exception {
        MatrixBuilder.createIntegerSquareMatrix(new Integer[1][1]);
    }
}