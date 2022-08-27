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
        TreeNode current = node;
        while (current != null) {
            arr.add(0, current.val);
//            if (current.left != null)
                current = current.left;
            if (current != null) {
                if (current.right != null) {
                    arr.add(0, current.right.val);
                }
            }
        }
//        arr.add(0, current.val);
//        if (node.right != null)
            current = node.right;
        int l = arr.size();

        while (current != null){
            if (current.right != null) {
                if (current.right.right != null){
                    arr.add(l, current.right.right.val);
                }
                    arr.add(l, current.right.val);
            }
            arr.add(l, current.val);
            if (current.left != null) {
                current = current.left;
            }
            else if (current.right != null)
                current = current.right;
            if(current.left == null && current.right == null)
                break;
        }
        arr.add(l, current.val);

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
        return -1;
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
