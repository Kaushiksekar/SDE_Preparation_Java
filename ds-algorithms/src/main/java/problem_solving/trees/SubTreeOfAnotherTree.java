package problem_solving.trees;

// Problem - 572
// https://leetcode.com/problems/subtree-of-another-tree/

public class SubTreeOfAnotherTree {

    public boolean findTargetRootNode(TreeNode s, TreeNode t, int rootValue){
        if (s == null && t != null)
            return false;
        if (s == null && t == null)
            return true;
        if (s != null && t == null)
            return false;

        if (s.val == rootValue){
            boolean flag = isSameSubTree(s, t);
            if (flag) return true;
        }
        boolean leftFlag = findTargetRootNode(s.left, t, rootValue);
        boolean rightFlag = findTargetRootNode(s.right, t, rootValue);
        return leftFlag && rightFlag;
    }

    public boolean isSameSubTree(TreeNode sNew, TreeNode t){
        if (sNew == null && t == null)
            return true;
        if (sNew != null && t == null)
            return false;
        if (sNew == null && t != null)
            return false;
        if (sNew.val == t.val){
            boolean leftFlag = isSameSubTree(sNew.left, t.left);
            boolean rightFlag = isSameSubTree(sNew.right, t.right);
            return leftFlag && rightFlag;
        }
        else{
            return false;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findTargetRootNode(s, t, t.val);
//        System.out.println(commonRoot.val);
//        return isSameSubTree(commonRoot, t);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new SubTreeOfAnotherTree().isSubtree(s, t));

        s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new SubTreeOfAnotherTree().isSubtree(s, t));
    }
}
