package com.github.hronom.concurrentmatricesmultiplication;

public class MatrixDataEmptyException extends Exception {
    public MatrixDataEmptyException() {
        super("Data for matrix is empty");
    }
}
