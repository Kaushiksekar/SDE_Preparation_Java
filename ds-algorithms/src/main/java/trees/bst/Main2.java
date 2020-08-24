package trees.bst;

public class Main2 {

    public static void main(String[] args) throws NoSuchFieldException {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(39);
        bst.insert(43);
        bst.insert(42);
        bst.insert(44);
        bst.insert(41);
        System.out.println("After inserting");
        bst.getInOrderDisplay();
        bst.delete(43);
        System.out.println("After deleting 43");
        bst.getInOrderDisplay();
    }
}
