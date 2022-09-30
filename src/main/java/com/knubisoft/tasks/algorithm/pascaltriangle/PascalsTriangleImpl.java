package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<Integer> calculateLineOfPascalsTriangle(int lineNumber) {
        int[][] C;
        C = new int[lineNumber + 1][lineNumber + 1];

        for (int n = 0; n <= lineNumber; n++) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; k++) {
                C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int k = 0; k < lineNumber; k++) {
            result.add(C[lineNumber - 1][k]);
        }
        return result;
    }
}
