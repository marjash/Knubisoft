package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        return node1.equals(node2);
    }


    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> arr = new ArrayList<>();
        if (node != null) {
            arr = inorderTraversal(node.left);
            if (node.left != null) {
                if (arr.contains(node.left.val)) {
                    arr.add(node.val);
                }
            }
            else {
                arr.add(node.val);
            }
            List<Integer> arr2 = inorderTraversal(node.right);
            arr.addAll(arr2);
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
        boolean res = false;
            int sum = targetSum - node.val;
            if (sum == 0 && node.left == null && node.right == null) {
                res = true;
                return res;
            }
            if (node.left != null) {
                res = res || hasPathSum(node.left, sum);
            }
            if (node.right != null) {
                res = res || hasPathSum(node.right, sum);
            }
        return res;
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
