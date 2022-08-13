package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val && isSameTree(node1.left, node2.left) &&
                isSameTree(node1.right, node2.right);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {

        List<Integer> result = new ArrayList<>();

        if(node != null) {

            result.addAll(inorderTraversal(node.left));
            result.add(node.val);

            result.addAll(inorderTraversal(node.right));

        }

        return result;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {

        if (node == null) {
            return true;
        }

        return check(node.left, node.right);
    }

    private boolean check(TreeNode right, TreeNode left) {

        if (right == null && left == null)
            return true;

        if (right == null || left == null || right.val != left.val)
            return false;

        return check(right.left, left.right) && check(right.right, left.left);
    }

    @Override
    public int maxDepth(TreeNode node) {

        if(node == null){
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left,right) + 1;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {

        if(node == null){
            return false;
        }

        if(node.right == null && node.left == null && targetSum - node.val == 0){
            return true;
        }

        return hasPathSum(node.right, targetSum - node.val) ||
                hasPathSum(node.left, targetSum - node.val);
    }

    @Override
    public TreeNode invertTree(TreeNode node) {

        if(node == null){
            return node;
        }

        TreeNode temp = node.left;

        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {

        int leaves = 0;

        if (node.left == null);
        else if (node.left.left != null || node.left.right != null){
            leaves += sumOfLeftLeaves(node.left);
        }
        else {
            leaves += node.left.val;
        }

        if (node.right == null);
        else if (node.right.left != null || node.right.right != null){
            leaves += sumOfLeftLeaves(node.right);
        }


        return leaves;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {

        if(node1 == null && node2 == null) {
            return null;
        }

        if(node1 == null) {
            return node2;
        }

        if(node2 == null) {
            return node1;
        }

        node1.val += node2.val;

        node1.left = mergeTrees(node1.left , node2.left);
        node1.right = mergeTrees(node1.right , node2.right);

        return node1;
    }
}
