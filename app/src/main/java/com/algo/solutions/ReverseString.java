package com.algo.solutions;

import com.algo.common.entity.SolutionImpl;
import com.algo.common.util.Print;

/**
 * 344
 * https://leetcode.com/problems/reverse-string/
 * Write a function that reverses a string. The input string is given as an array of characters `s`.
 *
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString extends SolutionImpl {
    /**
     * Runtime: 1 ms, faster than 95.65% of Java online submissions for Reverse String.
     * Memory Usage: 45.3 MB, less than 94.72% of Java online submissions for Reverse String.
     * @param s
     */
    public void reverseString(char[] s) {
        // [h, e, l, l, o]
        char tmp;
        for (int i = 0; i < s.length / 2; i++) { // 절반만 바꿔야 한다. 안그러면 바꾼 걸 또 바꾸게 된다
            tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }

    @Override
    protected void test() {
        char[] tc1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        // call by reference
        Print.asArray(tc1);
        reverseString(tc1);
        Print.asArray(tc1);
        char[] tc2 = new char[]{'h','a','n','n','a','H'};
        Print.asArray(tc2);
        reverseString(tc2);
        Print.asArray(tc2);
    }
}
