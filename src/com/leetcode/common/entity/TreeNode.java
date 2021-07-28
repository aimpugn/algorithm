package com.leetcode.common.entity;

import com.leetcode.por.BinarySearchTree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void test(String[] args) {
        TreeNode test1 = new TreeNode(4);
        test1.right = new TreeNode(7);
        test1.left = new TreeNode(2);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(3);

        BinarySearchTree main = new BinarySearchTree();
        TreeNode result = main.searchBST(test1, 2);
        System.out.println(result);
    }
}
