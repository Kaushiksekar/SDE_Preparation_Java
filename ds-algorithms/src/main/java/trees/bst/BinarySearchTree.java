package trees.bst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BinarySearchTree {

    @Setter
    @Getter
    @NoArgsConstructor
    private class Node{
        private Integer data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    public void insert(Integer value){
        root = insert(null, root, value);
    }

    public void delete(Integer value) throws NoSuchFieldException {
        Node deleteNode = search(root, value);
        delete(deleteNode, value);
    }

    public void getInOrderDisplay(){
        System.out.println("In order expression : ");
        if (root == null){
            System.out.println("BST is empty");
            return;
        }
        getInOrderDisplay(root);
        System.out.println();
    }

    public Integer search(Integer value) throws NoSuchFieldException {
        return search(root, value).getData();
    }

    public Integer getNextValue(Integer value) throws NoSuchFieldException {
        Node valueNode = search(root, value);
        if (valueNode.getRight() != null){
            return getLeftMostNode(valueNode.getRight()).getData();
        }
        return getBiggestParentNode(valueNode, value).getData();
    }

    private void delete(Node deleteNode, Integer value) throws NoSuchFieldException {
        if (deleteNode.getLeft() == null && deleteNode.getRight() == null){ // no children
            if (deleteNode.getParent() == null){
                root = null;
            }
            else if (deleteNode.getParent().getData() > deleteNode.getData()){
                deleteNode.getParent().setLeft(null);
            }
            else{
                deleteNode.getParent().setRight(null);
            }
        }
        else if (deleteNode.getLeft() != null && deleteNode.getRight() != null){ // two children
            Node inOrderSuccessor = search(root, getNextValue(value));
            deleteNode.setData(inOrderSuccessor.getData());
//            Node newNode = new Node(inOrderSuccessor.getData());
//            if (deleteNode.getParent() != null && deleteNode.getParent().getData() > deleteNode.getData()){
//                deleteNode.getParent().setLeft(newNode);
//            }
//            else if (deleteNode.getParent() != null){
//                deleteNode.getParent().setRight(newNode);
//            }
//            if (deleteNode.getRight().getData() == deleteNode.getData())
//            deleteNode.getRight().setParent(newNode);
//            deleteNode.getLeft().setParent(newNode);
//            newNode.setLeft(deleteNode.getLeft());
//            newNode.setRight(deleteNode.getRight());
            delete(inOrderSuccessor, inOrderSuccessor.getData());
        }
        else{ // 1 child
            if (deleteNode.getParent() == null){
                if (deleteNode.getLeft() != null) {
                    root = deleteNode.getLeft();
                }
                else{
                    root = deleteNode.getRight();
                }
                root.setParent(null);
            }
            else if (deleteNode.getParent().getData() > deleteNode.getData()){
                if (deleteNode.getLeft() != null){
                    deleteNode.getParent().setLeft(deleteNode.getLeft());
                    deleteNode.getLeft().setParent(deleteNode.getParent());
                }
                else{
                    deleteNode.getParent().setLeft(deleteNode.getRight());
                    deleteNode.getRight().setParent(deleteNode.getParent());
                }
            }
            else if (deleteNode.getParent().getData() < deleteNode.getData()){
                if (deleteNode.getLeft() != null){
                    deleteNode.getParent().setRight(deleteNode.getLeft());
                    deleteNode.getLeft().setParent(deleteNode.getParent());
                }
                else{
                    deleteNode.getParent().setRight(deleteNode.getRight());
                    deleteNode.getRight().setParent(deleteNode.getParent());
                }
            }
            else{
                // successive equal nodes condition to be handled. In this case, it happens while deleting 1
                if (deleteNode.getParent().getData() == deleteNode.getData()){
                    if (deleteNode.getParent().getLeft().getData() == deleteNode.getData()){
                        deleteNode.getParent().setLeft(deleteNode.getRight()); // delete node will only have right
                        // if had left, that would have been chosen as successor and this equality of successive nodes
                        // would not have com into picture
                    }
                    else if(deleteNode.getParent().getRight().getData() == deleteNode.getData()){
                        deleteNode.getParent().setRight(deleteNode.getRight());
                    }
                    deleteNode.getRight().setParent(deleteNode.getParent());
                }
            }
        }
    }

    private Node getLeftMostNode(Node node){
        if (node.getLeft() == null){
            return node;
        }
        else{
            return getLeftMostNode(node.getLeft());
        }
    }

    private Node getBiggestParentNode(Node node, Integer value) throws NoSuchFieldException {
        if (node.getData() > value) {
            return node;
        }
        else{
            if (node.getParent() == null){
                throw new NoSuchFieldException("Next Value is not present for value : " + value);
            }
            return getBiggestParentNode(node.getParent(), value);
        }
    }

    private void getInOrderDisplay(Node node){
        if (node == null){
            return;
        }
        else{
            getInOrderDisplay(node.getLeft());
            System.out.print(node.getData() + " ");
            getInOrderDisplay(node.getRight());
        }
    }

    private Node search(Node node, Integer value) throws NoSuchFieldException {
        if (node == null){
            throw new NoSuchFieldException("Value " + value + " is not present in the BST");
        }
        else if (node.getData() == value){
            return node;
        }
        else{
            if (value < node.getData()){
//                System.out.println("Going left");
                return search(node.getLeft(), value);
            }
            else if (value > node.getData()){
//                System.out.println("Going right");
                return search(node.getRight(), value);
            }
            else{
                throw new NoSuchFieldException("Value " + value + " is not present in the BST");
            }
        }
    }

    private Node insert(Node prevNode, Node currentNode, Integer value){
        if (currentNode == null){
            currentNode = new Node(value);
            currentNode.setParent(prevNode);
            System.out.println("Inserted with value : " + value);
        }
        else{
            if (value < currentNode.getData()){
//                System.out.println("Moving to left for inserting " + value);
                currentNode.setLeft(insert(currentNode, currentNode.getLeft(), value));
            }
            else if (value > currentNode.getData()){
//                System.out.println("Moving to right for inserting " + value);
                currentNode.setRight(insert(currentNode, currentNode.getRight(), value));
            }
            else{
                throw new UnsupportedOperationException("Duplicates are not allowed");
            }
        }
        return currentNode;
    }

}
