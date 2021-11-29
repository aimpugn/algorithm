package com.algo.learn.java;

import com.algo.common.util.Print;
import org.junit.jupiter.api.Test;

public class TestLearnComparator {

    @Test
    void testCompareComparableObject() {
        LearnComparator lc = new LearnComparator();
        Print.byFormat("lc.compare(1, 2): {0}", lc.compare(1, 2)); // -1
        Print.byFormat("lc.compare(2, 2): {0}", lc.compare(2, 2)); // 0
        Print.byFormat("lc.compare(10, 2): {0}", lc.compare(10, 2)); // 1
    }
}
