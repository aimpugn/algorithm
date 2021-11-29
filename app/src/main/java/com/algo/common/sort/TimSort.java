package com.algo.common.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java.util.TimSort.java 공부
 * @param <T>
 */
public class TimSort<T> {
    /**
     * 배열이 분할되는 `run`의 크기. 이보다 배열 크기가 작으면 병합 스킵. 2의 거듭제곱.
     */
    static int MIN_MERGE = 32;

    /**
     *
     * @param array 정렬할 대상 배열
     * @param low 첫번째 요소의 인덱스. inclusive
     * @param high 마지막 요소의 인덱스. exclusive
     * @param <T>
     */
    public static <T> void sort(T[] array, int low, int high, Comparator<? super T> c) {
        // 남은 요소의 개수
        int remaining = high - low;
        if (remaining < 2) // 0, 1 크기의 배열은 언제나 정렬되어 있다고 본다
            return;

        // 최소 병합 크기보다 작다면, 병합 없는 `mini-TimSort` 실행
        if (remaining < MIN_MERGE) {
            int initRunLen = countRunAndMakeAscending(array, low, high, c);
        }

    }

    public static void sort(int[] array) {
        // https://www.baeldung.com/java-primitive-array-to-object-array#streams
        TimSort.sort(
                Arrays.stream(array).boxed().toArray(Integer[]::new),
                0,
                array.length,
                /*
                 * new Comparator() {
                 *      @Override
                 *      public int compare(Object o1, Object o2) {
                 *          // compareTo를 쓰기 위해 Comparable<Object>로 캐스팅
                 *          return ((Comparable<Object>) o1).compareTo(o2);
                 *      }
                 * }
                 */
                (Comparator<Object>) (o1, o2) -> { // lambda 식. compare(Object o1, Object o2) 메서드와 같다
                    /*
                    1. o1 > o2: 양수 반환
                    2. o1 == o2: 0 반환
                    3. o1 < o2: 음수 반환
                     */
                    // compareTo를 쓰기 위해 Comparable<Object>로 캐스팅
                    return ((Comparable<Object>) o1).compareTo(o2);
                }
        );
    }

    /**
     * <pre>
     * 특정 위치에서 시작하는 `run`의 길이 반환하고, 내림차순이면 오름차순으로 바꾼다
     * `run`은
     * 1. 가장 긴 오름차순 시퀀스: array[low] <= array[low + 1] <= array[low + 2] <= ...
     * 2. 가장 긴 내림차순 시퀀스: array[low] > array[low + 1] > array[low + 2] > ...
     * stable 병합 정렬에서 사용될 것이므로, 내림차순을 엄격하게 정의할 필요가 있고,
     * 그에 따라 `stability`를 해치지 않고 내림차순 시퀀스를 안전하게 오름차순으로 바꿀 수 있다
     * </pre>
     * @param array
     * @param low
     * @param high
     * @param c
     * @param <T>
     * @return
     */
    public static <T> int countRunAndMakeAscending(T[] array, int low, int high, Comparator<? super T> c) {
        assert low < high;
        int runHigh = low + 1;

        if (runHigh == high) // low와 high의 차이가 1인 경우
            return 1;

        /*
        왜 내림차순 여부를 한번만 체크할까?
         */
        if(c.compare(array[runHigh++], array[low]) < 0) {
            // Descending, 내림차순이 끝나는 인덱스를 찾는다
            while(runHigh < high && c.compare(array[runHigh], array[runHigh - 1]) < 0)
                runHigh++;
            reverseRange(array, low, runHigh);
        } else {
            // Ascending, 오름차순
            while (runHigh < high && c.compare(array[runHigh], array[runHigh - 1]) >= 0)
                runHigh++;
        }


        return runHigh - low;
    }

    /**
     * 배열의 특정 범위를 뒤집는다
     * @param array
     * @param low
     * @param high
     */
    private static void reverseRange(Object[] array, int low, int high) {
        // 5, 4, 2, 3에서 내림차순이 끝난다고 판단된 인덱스가 array[3]이므로,
        // 3--로 오름차순 시작하는 지점을 high로 잡는다
        high--;
        while (low < high) {
            Object t = array[low];
            array[low++] = array[high];
            array[high--] = t;
        }
        // 2, 4, 5, 3
    }

    /**
     *
     * @param n 대상 배열의 크기
     * @return
     */
    public static int minRunLength(int n) {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }


}
