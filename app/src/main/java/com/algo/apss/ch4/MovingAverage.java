package com.algo.apss.ch4;

import com.algo.common.entity.SolutionImpl;

import java.util.Arrays;

public class MovingAverage extends SolutionImpl {
    /**
     * 이동 평균선 구하기
     * - 이동 평균이란? 시간에 따라 변화하는 값들의 평균
     * - M-이동 평균? 마지막 M개의 평균.
     * */
    public double[] first(double[] A, int M) {
        int N = A.length;
        double[] answer = new double[N];

        /* A[i]까지의 이동 평균 구하기 */
        for (int i = M - 1; i < N; i++) {
            double partialSum = 0;
            /* 각 위치(i)에서 지난 M개의 평균 구하기. 현재 기준으로 M-1만큼 돌아간다. */
            for (int j = 0; j < M; j++) {
                partialSum += A[i - j]; // 현재(=i), 현재(i)-1, 현재(i)-2, ..., 현재(i)-(M-1)
            }
            answer[i] = partialSum / M;
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }


    public double[] second(double[] A, int M) {
        int N = A.length;
        double[] answer = new double[N];
        double partialSum = 0;
        /* 미리 중복되는 M-2까지의 합을 구해 둔다 */
        for (int i = 0; i < M - 1; i++) { // M-1 인덱스가 현재(i)며, 현재는 아래 반복문에서 더한다
            partialSum += A[i]; // M=3? A[0], A[1]
        }

        for (int i = M - 1; i < N; i++) {
            partialSum += A[i]; // 현재를 더한다
            answer[i] = partialSum / M;
            partialSum -= A[i - (M - 1)]; // 다음을 위해 현재(i)의 이동 평균선 구하는 첫 시작 부분을 제거한다
        }

        return answer;
    }

    @Override
    protected void test() {
        double[] testCase1 = new double[]{
                70, 65, 60, 55, 60, 65, 63, 58, 57, 56
        };
        first(testCase1, 3);
        double[] testCase2 = new double[]{
                3.5, 3.5, 3.5, 3.6, 3.5, 10, 10.3, 15, 80.2, 80.1, 80.3
        };
        first(testCase2, 3);
        second(testCase2, 3);
    }
}
