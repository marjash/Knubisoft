package com.knubisoft.tasks.algorithm.fibonacci;

public class FibonacciImpl implements Fibonacci {
    @Override
    public int generateNFibonacciSequence(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n >= 40)
            return -1;
        return generateNFibonacciSequence(n - 1) + generateNFibonacciSequence(n - 2);
    }
}
