package problem_solving.trees;

import com.sun.source.tree.Tree;

public class TreeTraversal {

    public static void printTreeInOrder(TreeNode tree){

        if (tree == null)
            return;

        printTreeInOrder(tree.left);
        System.out.println(tree.val);
        printTreeInOrder(tree.right);
    }

    public static void printTreePreOrder(TreeNode tree){

        if (tree == null)
            return;

        System.out.println(tree.val);
        printTreePreOrder(tree.left);
        printTreePreOrder(tree.right);

    }

    public static void printTreePostOrder(TreeNode tree){

        if (tree == null)
            return;

        printTreePostOrder(tree.left);
        printTreePostOrder(tree.right);
        System.out.println(tree.val);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(7);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(8);

        System.out.println("Printing In Order");
        TreeTraversal.printTreeInOrder(tree);
        System.out.println("------------------------");

        System.out.println("Printing Pre Order");
        TreeTraversal.printTreePreOrder(tree);
        System.out.println("------------------------");

        System.out.println("Printing Post Order");
        TreeTraversal.printTreePostOrder(tree);
        System.out.println("------------------------");
    }
}
