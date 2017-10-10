package com.github.hronom.concurrentmatricesmultiplication;

public class MatricesMulException extends Exception {
    public MatricesMulException(Throwable cause) {
        super("Matrices mul error", cause);
    }
}
