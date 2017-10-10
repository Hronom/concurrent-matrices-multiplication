package com.github.hronom.concurrentmatricesmultiplication.matrix;

public class MatricesMulException extends Exception {
    public MatricesMulException(Throwable cause) {
        super("Matrices mul error", cause);
    }
}
