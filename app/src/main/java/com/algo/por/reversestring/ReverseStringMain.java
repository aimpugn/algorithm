package com.algo.por.reversestring;

import com.algo.common.time.ExecutorHelper;
import com.algo.common.time.TimeUtil;

/**
 * por stands for Principle of Recursion
 */
public class ReverseStringMain {
    public void reverseString(char[] s) {
        TimeUtil.start();
        int start = 0;
        int last = s.length - 1;
        char tmp;
        while (start < last) {
            tmp = s[start];
            s[start] = s[last];
            s[last] = tmp;
            start++;
            last--;
        }
        System.out.println(s);
        TimeUtil.elapsedTime(false);
    }

    public void reverseString2(char[] s) {
        TimeUtil.start();
        if (s != null || s.length > 0) {
            /**
             * # 길이 절반
             * - length = 6, 6/2 = 3.
             * - length = 5, 5/2 = 2. 홀수인 경우 중앙 무시
             */
            int size = s.length;
            char tmp;
            int i = 0;
            int maxLoopCnt = size / 2;
            int lineCnt = 0;
            for (int j = size - 1; i < maxLoopCnt; j--) {
                lineCnt++;
                // System.out.println("[" + lineCnt + "] s[" + i + "]=" + s[i] + ", s[" + j + "]" + s[j]);
                tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
            }
            System.out.println(s);
        }
        TimeUtil.elapsedTime(false);
    }

    public static void test() throws InterruptedException {
        ReverseStringMain rs = new ReverseStringMain();
        /**
         * # 배열 선언 방법
         * - 원시 타입인 경우
         * int[] myIntArray = new int[3];
         * int[] myIntArray = {1, 2, 3};
         * int[] myIntArray = new int[]{1, 2, 3};
         *
         * - 클래스 타입인 경우
         * String[] myStringArray = new String[3];
         * String[] myStringArray = {"a", "b", "c"};
         * String[] myStringArray = new String[]{"a", "b", "c"}
         *
         * - 변수 선언하고 나중에 할당하는 경우
         * String[] myStringArray;
         * myStringArray = new String[]{"a", "b", "c"};
         */
        char[] testCase = {'a', 'b', 'c', 'd'};
        char[] testCase2 = {'h','e','l','l','o'};

        ExecutorHelper eh = new ExecutorHelper();

        eh.setTargetList(
                () -> {
                    char[] testCase3 = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
                    ReverseStringMain rs1 = new ReverseStringMain();
                    rs1.reverseString(testCase3);  // 160800
                },
                () -> {
                    char[] testCase4 = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
                    ReverseStringMain rs1 = new ReverseStringMain();
                    rs1.reverseString2(testCase4);  // 160800
                }
        );
        eh.start();
    }
}
