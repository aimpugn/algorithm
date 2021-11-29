package com.algo.sort;

import com.algo.common.sort.TimSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * com/algo/common/sort/TimSort.java 테스트
 */
public class TestTimSort {

    @Test
    void testTimSortSort() {
        TimSort.sort(new int[]{5, 4, 2, 3});
    }

}
