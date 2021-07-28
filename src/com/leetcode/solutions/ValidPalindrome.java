package com.leetcode.solutions;

import com.leetcode.common.entity.SolutionImpl;
import com.leetcode.common.entity.SolutionInterface;

import java.nio.charset.StandardCharsets;

/**
 * https://leetcode.com/problems/valid-palindrome
 */
public class ValidPalindrome extends SolutionImpl {

    public boolean isPalindrome(String s) {
        for (byte c : s.getBytes(StandardCharsets.UTF_8)) {
            System.out.println(c);
        }
        return true;
    }

    @Override
    protected void test() {
        isPalindrome("A man, a plan, a canal: Panama");
    }
}
