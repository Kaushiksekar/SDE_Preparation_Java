package problem_solving.trees;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderAndPreOrder {

    int preOrderIndex = 0;
    int preOrder[];
    int inOrder[];
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        for (int i=0;i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return constructBinaryTreeFromInOrderAndPostOrder(0, inorder.length);
    }

    public TreeNode constructBinaryTreeFromInOrderAndPostOrder(int in_left, int in_right){
        if (in_left == in_right){
            return null;
        }
        int rootValue = preOrder[preOrderIndex];
        TreeNode root = new TreeNode(rootValue);
        preOrderIndex++;
        int index = map.get(rootValue);
        root.left = constructBinaryTreeFromInOrderAndPostOrder(in_left, index);
        root.right = constructBinaryTreeFromInOrderAndPostOrder(index+1, in_right);
        return root;

    }

    public void printInorder(TreeNode root){
        if (root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int inorder[] = {9,3,15,20,7};
        int preOrder[] = {3,9,20,15,7};
        ConstructBinaryTreeFromInOrderAndPreOrder treeDemo = new ConstructBinaryTreeFromInOrderAndPreOrder();
        TreeNode root = treeDemo.buildTree(preOrder, inorder);
        treeDemo.printInorder(root);
    }
}
