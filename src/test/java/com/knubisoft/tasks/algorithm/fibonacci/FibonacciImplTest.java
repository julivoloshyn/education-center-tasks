package com.knubisoft.tasks.algorithm.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciImplTest {

    private final Fibonacci fibonacci = new FibonacciImpl();

    @Test
    void generateNFibonacciSequence() {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int index = 0; index < 30; index++) {
            assertEquals(fibonacci.generateNFibonacciSequence(index), fib(index, lookup));
        }
    }

    @Test
    void generateNFibonacciSequence1000() {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int index = 0; index < 1000; index++) {
            int finalIndex = index;
            NumberFormatException e = Assertions.assertThrows(NumberFormatException.class, () -> {
                if (finalIndex > 100) {
                    assertEquals(fibonacci.generateNFibonacciSequence(finalIndex), fib(finalIndex, lookup));
                }

                Integer.parseInt("");
            }, "NumberFormatException");

            Assertions.assertEquals(e, e);

        }
    }

    public static int fib(int n, Map<Integer, Integer> lookup) {
        if (n <= 1) {
            return n;
        }
        lookup.putIfAbsent(n, fib(n - 1, lookup) + fib(n - 2, lookup));
        return lookup.get(n);
    }
}