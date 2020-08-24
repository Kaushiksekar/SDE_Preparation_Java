package trees.bst;

public class OptimisedBST {

    class Node{
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    Node root;

    public Integer getNextValue(Integer value){
        return getNextValue(root, value).data;
    }

    public Node getNextValue(Node currentNode, Integer value){
        return null;
    }

}
