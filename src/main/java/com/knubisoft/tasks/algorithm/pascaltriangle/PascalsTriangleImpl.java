package com.knubisoft.tasks.algorithm.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleImpl implements PascalsTriangle {

    @Override
    public List<Integer> calculateLineOfPascalsTriangle(int lineNumber) {
        List<Integer> triangle = new ArrayList<>();
        if (lineNumber <= 0)
            return triangle;
        for (int i = 1; i <= lineNumber; i++) {
            int n = 1;
            for (int j = 1; j <= i; j++) {
                if (i == lineNumber)
                    triangle.add(n);
                n = n * (i - j) / j;
            }
        }
        return triangle;
    }
}
