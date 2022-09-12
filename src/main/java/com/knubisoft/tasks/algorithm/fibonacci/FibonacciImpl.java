package com.knubisoft.tasks.algorithm.fibonacci;

public class FibonacciImpl implements Fibonacci {

    @Override
    public int generateNFibonacciSequence(int n) {

        if(n > 100){
            throw new NumberFormatException();
        } else {

            int first = 0;
            int second = 1;
            int result = n;

            for (int i = 1; i < n; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            return result;
        }
    }
}
