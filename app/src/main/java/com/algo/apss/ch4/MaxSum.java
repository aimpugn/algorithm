package com.algo.apss.ch4;

import com.algo.common.entity.SolutionImpl;
import com.algo.common.time.TimeUtil;

import java.util.Arrays;

/**
 * 연속된 부분 구간 중 그 합이 최대인 구간을 찾는 문제
 * INPUT: [-7, 4, -3, 6, 3, -8, 3, 4]
 * OUTPUT: [4, -3, 6, 3]
 */
public class MaxSum extends SolutionImpl {
    private static final int MIN = Integer.MIN_VALUE; /* -2^31 = -2147483648 */
    /**
     * 주어진 배열의 모든 부분 구간을 순회하며 그 합을 계산
     * - O(N^3) 복잡도
     */
    public int inefficientMaxSum(int[] A) {
        int N = A.length;
        int answer = MIN;
        for (int i = 0; i < N; i++) { /* 전체 배열 순회 */
            for (int j = i; j < N; j++) { /* 배열의 일부 구간을 순회 */
                /* A[i..j] 구간의 합을 구한다*/
                int sum = 0;
                for (int k = i; k <= j; k++) { // 모든 경우의 순열을 더해본다
                    sum += A[k];
                }
                answer = Math.max(sum, answer);
            }
        }

        return answer;
    }

    /**
     * 일정 범위의 계산된 값 재사용하는 이동평균선 개선 방식 적용
     * @param A 숫자 구간을 담고있는 배열
     * @return
     */
    public int betterMaxSum(int[] A) {
        int N = A.length;
        int answer = MIN;
        for (int i = 0; i < N; i++) { /* 전체 배열 순회 */
            int sum = 0;
            for (int j = i; j < N; j++) { /* 배열의 일부 구간을 순회 */
                /* 그냥 모두 더해가면서 최대값이 되는 값을 반환한다 */
                sum += A[j]; // 실제 구간의 범위는 신경쓸 필요가 없다. 최대값이 되면 어떤 A[i..j]의 max 값이 answer 변수에 담겨있을 것이기 때문
                answer = Math.max(sum, answer);
            }
        }

        return answer;
    }

    /**
     * 분할 정복 기법
     * - O(N lg N)
     * @param A
     * @param lo
     * @param hi
     * @return
     */
    public int fastMaxSum(int[] A, int lo, int hi) {
        /* 기저 사례: 구간의 길이가 1일 경우 */
        if (lo == hi) return A[lo];
        /* (lo + hi)에서 오버플로 발생 가능하므로 `가장 작은 값 + 절반`으로 중앙값을 구한다 */
        int mid = lo + (hi - lo) / 2;
        int left = MIN;
        int sum = 0;
        /* 중앙을 기점으로 해서 좌/우로 퍼져나가며 max값을 구해 나간다. 그럼 좌/우 각각의 최대값을 구할 수 있고 */
        for (int i = mid; i >= lo; i--) {
            sum += A[i];
            left = Math.max(left, sum);
        }
        int right = MIN;
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += A[j];
            right = Math.max(right, sum);
        }

        /* 다시 중앙을 기점으로 좌/우 배열을 나눠서 더 작은 단위의 배열에서 검증한다 */
        int leftSideMaxSum = fastMaxSum(A, lo, mid);
        int rightSideMaxSum = fastMaxSum(A, mid + 1, hi);
        int comparedLeftAndRightSideMaxSum = Math.max(leftSideMaxSum, rightSideMaxSum);

        /* 앞서 `좌/우로 퍼져나가는 것` vs `좌/우 배열을 더 작은 단위로 나눈 것` 두 가지를 비교해서 더 큰 값을 반환한다 */
        return Math.max(left + right, comparedLeftAndRightSideMaxSum);
    }


    /**
     * 동적 계획법
     * A[i]를 우측 끝으로 갖는 구간의 최대합 반환 함수 = maxAt(i)
     * 1. A[i] 단일
     * 2. ... + A[i-2] + A[i-1] = 최대합. 여기에 A[i]를 더한다
     * => maxAt(i) = max(0, maxAt(i - 1)) + A[i]
     * 좌측 0에서부터 우측으로 이동하면서 A[i]를 더해가며 가장 큰 값을 찾는다
     * @param A
     * @return
     */
    public int fastestMaxSum(int[] A) {
        int N = A.length;
        int answer = MIN;
        int partialSum = 0;
        for (int i = 0; i < N; i++) {
            partialSum = Math.max(partialSum, 0) + A[i];
            answer = Math.max(answer, partialSum);
        }

        return answer;
    }



    @Override
    protected void test() {
        int[] tc1 = new int[]{
                -7, 4, -3, 6, 3, -8, 3, 4
        };
        int[] tc2 = new int[]{
                -7, 10, 4, 33, 3, -10, -3, 4, 7, -3,  6, -1, -20, 3, -8, 3, 4, 40, 6, -3, -2, -9, -22, 60, -2, 80, 30, 100, -89, -32, -111, 90
        };
        int[][] testCases = new int[][]{
                tc1, tc2
        };
        for (int[] tc : testCases) {
            System.out.println(Arrays.toString(tc));
            TimeUtil.start();
            System.out.printf("inefficientMaxSum: %d\n", inefficientMaxSum(tc));
            TimeUtil.elapsedTime(false);
            TimeUtil.start();
            System.out.printf("betterMaxSum: %d\n", betterMaxSum(tc));
            TimeUtil.elapsedTime(false);
            TimeUtil.start();
            System.out.printf("fastMaxSum: %d\n", fastMaxSum(tc, 0, tc.length - 1));
            TimeUtil.elapsedTime(false);
            TimeUtil.start();
            System.out.printf("fastestMaxSum: %d\n", fastestMaxSum(tc));
            TimeUtil.elapsedTime(false);
        }
    }
}
