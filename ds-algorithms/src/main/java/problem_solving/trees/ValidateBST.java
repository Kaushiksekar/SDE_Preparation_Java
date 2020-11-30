package problem_solving.trees;

// problem number - 98 - https://leetcode.com/problems/validate-binary-search-tree/

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        ValidateBST object = new ValidateBST();
        System.out.println(object.isValidBST(root));
//
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(object.isValidBST(root));

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        object = new ValidateBST();
        System.out.println(object.isValidBST(root));
//        object.printInorder(root);

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        object = new ValidateBST();
        System.out.println(object.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        boolean result = isValidBST(root, true, "", null, null);
        return result;
    }

    private boolean isValidBST(TreeNode root, boolean result, String type,
                               Integer lowerLimit, Integer upperLimit){
        if (root == null) return result;
        if (!result) return false;

        if (upperLimit != null || lowerLimit != null){
            if (lowerLimit == null){
                result = root.val < upperLimit;
            }
            else if(upperLimit == null){
                result = root.val > lowerLimit;
            }
            else{
                result = root.val < upperLimit;
                if (!result) return false;
                result = root.val > lowerLimit;
            }
        }
        result = isValidBST(root.left, result, "left", lowerLimit, root.val);
        result = isValidBST(root.right, result, "right", root.val, upperLimit);

        return result;
    }

    public void printInorder(TreeNode root){
        if (root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }
}
