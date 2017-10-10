package com.github.hronom.concurrentmatricesmultiplication.matrix;

public final class MatrixBuilder {
    private MatrixBuilder() {

    }

    public static IntMatrix createIntegerSquareMatrixFromArray(Integer[] data, int size)
        throws BadMatrixDataSizeException {
        if (data.length / size != size) {
            throw new BadMatrixDataSizeException();
        }

        Integer[][] matrixData = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    matrixData[i][j] = data[(i * size) + j];
                } catch (Exception e){
                    System.out.println();
                }
            }
        }
        return new IntMatrix(matrixData);
    }

    public static IntMatrix createIntegerSquareMatrix(Integer[][] data)
        throws MatrixDataEmptyException {
        if (data.length == 0) {
            throw new MatrixDataEmptyException();
        }
        if (data[0].length == 0) {
            throw new MatrixDataEmptyException();
        }
        return new IntMatrix(data);
    }
}
