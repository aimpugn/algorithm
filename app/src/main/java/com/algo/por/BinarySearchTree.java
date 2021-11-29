package com.algo.por;

import com.algo.common.entity.TreeNode;

public class BinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        else {
            return searchBST(root.left, val);
        }
    }




}
