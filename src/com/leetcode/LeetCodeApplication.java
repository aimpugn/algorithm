package com.leetcode;


import com.leetcode.common.entity.SolutionInterface;
import com.leetcode.solutions.ReverseString;
import com.leetcode.solutions.ValidPalindrome;

public class LeetCodeApplication {

    public static void main(String[] args) {
        SolutionInterface solutionInterface = new ReverseString();
        solutionInterface.doTest();
    }
}
