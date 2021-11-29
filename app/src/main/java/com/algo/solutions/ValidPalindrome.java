package com.algo.solutions;

import com.algo.common.entity.SolutionImpl;

import java.nio.charset.StandardCharsets;

/**
 * 125
 * https://leetcode.com/problems/valid-palindrome
 */
public class ValidPalindrome extends SolutionImpl {
    /**
     * Runtime: 2 ms, faster than 98.43% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39.2 MB, less than 63.01% of Java online submissions for Valid Palindrome.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        /*
        ASCII Table: https://www.ascii-code.com/
        0(48) ~ 9(57)
        A(65) ~ Z(90)
        a(97) ~ z(122)
         */
        int sLength = s.length(); // O(1), 필드에 길이를 저장해둔다. https://stackoverflow.com/a/254730
        byte[] filtered = new byte[sLength];
        int idx = 0;
        for (byte c : s.getBytes(StandardCharsets.UTF_8)) {
            if (48 <= c && c <= 57) { // 숫자는 그대로
                filtered[idx++] = c;
            } else if (65 <= c && c <= 90) {
                // -128 < byte <= 127
                filtered[idx++] = (byte) (c + 32); //  소문자로 만들어야 하므로 + 32
            } else if (97 <= c && c <= 122) {
                filtered[idx++] = c;
            }
        }
        idx--; // 끝날 때도 +1이 되므로 보정
        for (int i = 0; i <= idx; i++) {
            if (filtered[i] != filtered[idx - i]) {
                return false;
            }
            if (i == idx / 2) {
                return true;
            }
        }

        return true;
    }

    @Override
    protected void test() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama") ? "true" : "false");
        System.out.println(isPalindrome("race a car") ? "true" : "false");
    }
}
