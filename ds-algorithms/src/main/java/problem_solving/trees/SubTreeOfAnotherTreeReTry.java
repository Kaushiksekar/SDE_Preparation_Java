package problem_solving.trees;

// this is the solution that works for problem 572

public class SubTreeOfAnotherTreeReTry {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findRootAndCheck(s, t);
    }

    private boolean findRootAndCheck(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        if (s.val == t.val){
            boolean flag = isSameSubTree(s, t);
            if (flag)
                return true;
        }
        return findRootAndCheck(s.left, t) || findRootAndCheck(s.right, t);
    }

    private boolean isSameSubTree(TreeNode sNew, TreeNode t) {
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

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new SubTreeOfAnotherTreeReTry().isSubtree(s, t));

        s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new SubTreeOfAnotherTreeReTry().isSubtree(s, t));
    }
}
