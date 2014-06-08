package ua.artcode.week1.day1.bin_tree;

/**
 * Created by amakogon on 08.06.2014.
 */
public class BTreeRecursionImpl<E extends Comparable> implements IBTree<E> {

    private class Node {
        E item;
        Node parent;
        Node left;
        Node right;


        private Node(E item, Node parent, Node left, Node rigtht) {
            this.item = item;
            this.parent = parent;
            this.left = left;
            this.right = rigtht;
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }


    @Override
    public void add(E elem) {
        if(root == null){
            root = new Node(elem,null,null,null);
        } else{
            add(elem,root);
        }



    }

    private void add(E elem, Node root){
        if (root.item.compareTo(elem) > 0) {
            if (root.left != null) {
                add(elem,root.left);
            } else {
                root.left = new Node(elem, root, null, null);
            }
        } else if (root.item.compareTo(elem) < 0) {
            if (root.right != null) {
                add(elem,root.right);
            } else {
                root.right = new Node(elem, root, null, null);
            }
        }
    }

    @Override
    public boolean contains(E elem) {
        return false;
    }

    public void showTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.item.toString());
        showTree(node.left);
        showTree(node.right);
    }
}
