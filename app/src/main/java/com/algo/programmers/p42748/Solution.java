package com.algo.programmers.p42748;

import com.algo.common.sort.TimSort;

/* https://programmers.co.kr/learn/courses/30/lessons/42576 */
public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        TimSort.sort(array);

        return answer;
    }

    /**
     * TimSort
     * 1. `java`의 `Arrays.sort()`, `python`의 `sorted()`와 `sort()`
     * 2. 작은 단위를 `삽입 정렬`로 정렬, 작은 단위들을 `병합 정렬`로 병합
     * - https://www.geeksforgeeks.org/timsort/
     */
}