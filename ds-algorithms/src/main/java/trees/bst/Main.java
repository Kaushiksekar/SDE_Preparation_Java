package trees.bst;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
        System.out.println();
        bst.insert(4);
        bst.insert(5);
        bst.insert(-5);
        bst.insert(-3);
        bst.insert(10);
        bst.insert(6);
        bst.insert(8);
        bst.insert(7);
        bst.insert(40);
        bst.insert(35);
        bst.insert(33);
        bst.insert(34);
        bst.insert(32);
        bst.insert(31);
        bst.insert(30);
        bst.insert(29);
        System.out.println("After insertion");
        bst.getInOrderDisplay();

        List<Integer> deleteList = new ArrayList<>() {{
            add(1); add(4); add(5); add(-5); add(-3); add(10);
            add(6); add(8); add(7); add(40); add(35); add(33);
            add(34); add(32); add(31); add(30); add(29);
        }};

        for(Integer value: deleteList){
            bst.delete(value);
            System.out.println("After deleting " + value);
            bst.getInOrderDisplay();
        }
//        Integer foundValue = bst.search(7);
//        System.out.println("Found " + foundValue);
//        Integer nextValue = bst.getNextValue(8);
//        System.out.println("Next value : " + nextValue);
    }
}
