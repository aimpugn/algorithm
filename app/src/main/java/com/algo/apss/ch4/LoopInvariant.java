package com.algo.apss.ch4;

import com.algo.common.entity.SolutionImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LoopInvariant extends SolutionImpl {
    /**
     * A[-1]은 음의 무한대, A[n]은 양의 무한대 가정
     * @param A 오름차순으로 정렬되어 있다
     * @param x 찾고자 하는 값
     * @return A[i-1] < x <= A[i]인 i를 반환
     */
    public int binarySearch(List<Integer> A, int x) {
        int low = 0, high = A.size();
        /* 1. 반복문 불변식: low < high */
        /* 2. 반복문 불변식: A[low] < x <= A[high] */
        while (low < high) { /* 3. 반복문 종료 시: low + 1 >= high && low < high -----> high <= low + 1 < high + 1 */
            int mid = low + (high - low) / 2;
            System.out.printf("mid: %d, (%d - %d) / 2: %d\n", mid, high, low, (high - low) / 2);
            if (A.get(mid) < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    public void insertionSort(List<Integer> A) {
        /* 1. 반복문 불변식: A[0..i-1]은 이미 정렬되어 있다. */
        for (int i = 0; i < A.size(); i++) {
            /* 그렇다면 A[0..i-1]에 A[i]를 끼워넣는다. */
            int j = i;
            /* 2. 반복문 불변식: A[j + 1..i]의 모든 원소는 A[j]보다 크다 */
            while (j > 0 && A.get(j - 1) > A.get(j)) { /* 불변식이 맞지 않는 데이터가 있다면? 맞게 바꾼다 */
                /* 3. 반복문 불변식: A[0..i] 구간은 A[j]를 제외하면 정렬되어 있다 */
                Collections.swap(A, j - 1, j);
                j--;
            }
        }
    }

    @Override
    protected void test() {
        List<Integer> tc1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tc1.add(i);
        }
        int x1 = 3;
        int ans1 = binarySearch(tc1, x1);
        System.out.printf("tc1 size: %d, x: %d, result: %d, from tc: %d\n", tc1.size(), x1, ans1, tc1.get(ans1));
        List<Integer> tc2 = new ArrayList<>();
        tc2.add(4);
        tc2.add(3);
        tc2.add(1);
        tc2.add(5);
        tc2.add(2);
        insertionSort(tc2);
        System.out.println(tc2);
    }
}
