package com.github.hronom.concurrentmatricesmultiplication.matrix;

public abstract class Matrix<T> {
    private final T[][] data;

    Matrix(T[][] data) {
        this.data = data;
    }

    public int getRowLength() {
        return data.length;
    }

    public int getColumnLength() {
        return data[0].length;
    }

    public T[] getRow(int row) {
        return data[row];
    }

    public T getCell(int r, int c) {
        return data[r][c];
    }
}
