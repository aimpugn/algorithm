package com.algo.learn.java;

import com.algo.common.util.Print;

import java.util.Comparator;

public class LearnIncrementDecrement {
    public void increment() {
        int i = 0;
        String message = "";
        message = i++ == 0 ? "i++ == 0에서 i++는 if 통과 후 증가" : "i++ == 0에서 i++는 if 체크 전 증가";
        Print.byFormat( "i: {0}, {1}", i, message);
        message = ++i == 1 ? "++i == 1에서 ++i는 if 통과 후 증가" : "++i == 1에서 ++i는 if 체크 전 증가";
        Print.byFormat( "i: {0}, {1}", i, message);

        for (int j1 = 0; j1 < 1; j1++) {
            Print.byFormat( "j1: {0}, {1}", j1, "for (int j1 = 0; j1 < 1; j1++)에서 j++는 반복 실행 후 증가");
        }
        for (int j2 = 0; j2 < 1; ++j2) {
            Print.byFormat( "j2: {0}, {1}", j2, "for (int j2 = 0; j2 < 1; ++j2)에서 ++j는 반복 실행 후 증가");
        }

        LearnComparator lc = new LearnComparator();
        int[] tmp1Arr = new int[]{1, 2, 3};
        int idx = 0;
        Print.asArray(tmp1Arr);
        if (lc.compare(tmp1Arr[idx++], tmp1Arr[1]) < 0) {
            Print.byFormat(
                    "lc.compare(tmp1Arr[idx++={0}], tmp1Arr[1]): {1}, {2}",
                    --idx,
                    lc.compare(tmp1Arr[idx], tmp1Arr[1]),
                    "lc.compare(tmp1Arr[idx++], tmp1Arr[1])에서 idx++는 if 체크 후 증가"
            );
            idx++;
        }
        if (lc.compare(tmp1Arr[++idx], tmp1Arr[1]) > 0) {
            Print.byFormat(
                    "lc.compare(tmp1Arr[++idx={0}], tmp1Arr[1]): {1}, {2}",
                    idx,
                    lc.compare(tmp1Arr[idx], tmp1Arr[1]),
                    "lc.compare(tmp1Arr[idx++], tmp1Arr[1])에서 ++idx는 if 체크 전 증가"
            );
        }
    }
}
