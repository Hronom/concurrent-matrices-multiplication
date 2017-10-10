package com.github.hronom.concurrentmatricesmultiplication.matrix;

public final class MatrixPrinter {
    private MatrixPrinter() {

    }

    public static void print(Matrix matrix) {
        for (int i = 0; i < matrix.getRowLength(); i++) {
            for (int j = 0; j < matrix.getColumnLength(); j++) {
                System.out.print(matrix.getCell(i, j) + " ");
            }
            System.out.println();
        }
    }
}
