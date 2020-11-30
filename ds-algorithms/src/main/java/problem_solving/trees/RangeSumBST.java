package problem_solving.trees;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        int leftValue = rangeSumBST(root.left, L, R);
        int rightValue = rangeSumBST(root.right, L, R);
        int rootValue = 0;
        if (root.val >= L && root.val <= R)
            rootValue = root.val;
        return leftValue + rightValue + rootValue;
        // although this works, this is inefficient, don't have to recurse to children if node is not
        // in range as it is a BST
        // can recurse separately for root value > L and separately for < R
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(18);
        System.out.println(new RangeSumBST().rangeSumBST(treeNode, 7, 15));
    }
}
