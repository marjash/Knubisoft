package com.knubisoft.base.trees;

import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        return node1.equals(node2);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node, List<Integer> arr) {
        if (node != null) {
            inorderTraversal(node.left, arr);
            if (node.left != null) {
                if (arr.contains(node.left.val)) {
                    arr.add(node.val);
                }
            }
            else {
                arr.add(node.val);
            }
            inorderTraversal(node.right, arr);
        }
        return arr;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {
        if (node.left != null && node.right != null){
            if (node.left.val == node.right.val) {
                isSymmetric(node.left);
                isSymmetric(node.right);
                return true;
            }
        }
        return false;
    }

    @Override
    public int maxDepth(TreeNode node) {
        if (node != null) {
            int left = maxDepth(node.left);
            int right = maxDepth(node.right);
            if (left > right)
                return left + 1;
            else
                return right + 1;
        }
        return 0;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        return false;
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        return null;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        return -1;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        return null;
    }
}
