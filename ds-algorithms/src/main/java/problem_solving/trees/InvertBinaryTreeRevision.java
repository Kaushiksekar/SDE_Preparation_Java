package problem_solving.trees;

public class InvertBinaryTreeRevision {

    public void printInorder(TreeNode root){
        if (root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTreeRevision invertBinaryTree = new InvertBinaryTreeRevision();
        invertBinaryTree.printInorder(root);
        System.out.println("---------------");
        invertBinaryTree.invertTree(root);
        invertBinaryTree.printInorder(root);
    }
}
