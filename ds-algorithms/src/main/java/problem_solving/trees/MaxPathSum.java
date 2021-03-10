package problem_solving.trees;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node){
        if (node == null)
            return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int totalPrice = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, totalPrice);
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(new MaxPathSum().maxPathSum(treeNode));
    }
}
