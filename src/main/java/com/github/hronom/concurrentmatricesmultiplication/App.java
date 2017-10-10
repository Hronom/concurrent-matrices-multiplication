package com.github.hronom.concurrentmatricesmultiplication;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // Generate initial data for matrices
        int matrixSize = 5000;
        Integer[] elements = new Integer[(matrixSize * matrixSize) * 2];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }

        // Create matrix a
        IntMatrix intMatrixA =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                Arrays.copyOfRange(elements, 0, matrixSize * matrixSize),
                matrixSize
            );

        System.out.println("Matrix A");
        MatrixPrinter.print(intMatrixA);
        System.out.println();

        // Create matrix b
        IntMatrix intMatrixB =
            MatrixBuilder.createIntegerSquareMatrixFromArray(
                Arrays.copyOfRange(elements, matrixSize * matrixSize, elements.length),
                matrixSize
            );

        System.out.println("Matrix B");
        MatrixPrinter.print(intMatrixB);
        System.out.println();

        // Create threaded multiplier
        ThreadedMatrixMultiplier threadedMatrixMultiplier =
            new ThreadedMatrixMultiplier(Runtime.getRuntime().availableProcessors());

        // Multiply
        IntMatrix result = threadedMatrixMultiplier.mul(intMatrixA, intMatrixB);
        System.out.println("Result");
        MatrixPrinter.print(result);

        // Close threaded multiplier
        threadedMatrixMultiplier.close();
    }
}
