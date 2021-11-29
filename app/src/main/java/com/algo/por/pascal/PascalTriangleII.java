package com.algo.por.pascal;

import com.algo.common.time.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    /**
     * 0th: 0 + 1
     * (0,0)
     * [1]
     * <p>
     * 1st: 0 + 1, 1 + 0
     * (1,0) (1,1)
     * [1,1]
     * <p>
     * 2nd: 1, 1 + 1, 1
     * (2,0) | (2,1) | (2,2)
     * (1,0) | (1,0) + (1,1) | (1,1)
     * 0 + 1, (0 + 1) + (1 + 0), 1 + 0
     * [1,2,1]
     * <p>
     * 3rd: 1, 1 + 2, 2 + 1, 1
     * (3,0) | (3,1) | (3,2) | (3,3)
     * (1,0) | (2,0) + (2,1) | (2,1) + (2,2) | (2,2)
     * (1,0) | (1,0) + (1,0) + (1,1) | (1,1) + (1,0) + (1,1) | (1,1)
     * 0 + 1, 0 + 1 + (1 + 1), (1 + 1) + 1 + 0, 1 + 0
     * 0 + 1, 0 + 1 + ((0 + 1) + (1 + 0)), ((0 + 1) + (1 + 0)) + 1 + 0, 1 + 0
     * [1,3,3,1]
     * <p>
     * 4th: 1, 1 + 3, 3 + 3, 3 + 1, 1
     * (4,0) (4,1) (4,2) (4,3), (4,4)
     * 0 + 1, 0 + 1 + (1 + (1 + 1)), (1 + (1 + 1)) + ((1 + 1) + 1), ((1 + 1) + 1) + 1 + 0, 1 + 0
     * [1, 4, 6, 4, 1]
     * <p>
     * 5th: 1, 1 + 4, 4 + 6, 6 + 4, 4 + 1, 1
     * 0 + 1, 0 + 1 + (1 + (1 + (1 + 1))), (1 + (1 + (1 + 1)) + ((1 + (1 + 1)) + ((1 + 1) + 1)), ...
     * [1, 5, 10, 10, 5, 1]
     *
     * 단순 계산이 아닌 좌표 체계로 보자
     */
    private int[][] tmp;
    public List<Integer> getRow(int rowIndex) {
        /**
         * https://www.java67.com/2014/10/how-to-create-and-initialize-two-dimensional-array-java-example.html
         * 다차원 배열 생성
         */
        this.tmp = new int[rowIndex][rowIndex+1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0);
        }
        int fromEnd = rowIndex;
        for (int i = 0; i <= rowIndex / 2; i++) {
            int value = getRowHelper(rowIndex, i);
            list.set(i, value);
            if (i != fromEnd) {
                list.set(fromEnd, value);
            }
            fromEnd--;
        }

        return list;
    }

    private int getRowHelper(int y, int x) {
        if (x == 0 || y == x) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (this.tmp[y - 1][x - 1] > 0) {
            left = this.tmp[y - 1][x - 1];
        }
        else {
            left = getRowHelper(y - 1, x - 1);
            this.tmp[y - 1][x - 1] = left;
        }
        if (this.tmp[y - 1][x] > 0) {
            right = this.tmp[y - 1][x];
        }
        else {
            right = getRowHelper(y - 1, x);
            this.tmp[y - 1][x] = right;
        }

        return left + right;
    }

    public static void test() {
        PascalTriangleII main = new PascalTriangleII();
        TimeUtil.start();
        main.getRow(30);
        TimeUtil.elapsedTime(true);
    }

}
