package ua.artcode.week1.day1.bin_tree;

/**
 * Created by amakogon on 07.06.2014.
 */
public class TestBtree {
    public static void main(String[] args) {
        BTreeImpl<Integer> tree = new BTreeImpl<Integer>();
        tree.add(10);
        tree.add(15);
        tree.add(1);
        tree.add(6);
        tree.add(8);
        tree.showTree(tree.getRoot());
        System.out.println(tree.contains(8));

        BTreeRecursionImpl<Integer> treeRec = new BTreeRecursionImpl<Integer>();
        treeRec.add(10);
        treeRec.add(15);
        treeRec.add(1);
        treeRec.add(6);
        treeRec.add(8);
        treeRec.showTree(treeRec.getRoot());
        System.out.println(treeRec.contains(8));


    }
}
