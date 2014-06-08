package ua.artcode.week1.day1.bin_tree;

/**
 * Created by amakogon on 07.06.2014.
 */
public class BTreeImpl<E extends Comparable> implements IBTree<E> {

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
        if (root == null) {
            root = new Node(elem, null, null, null);
        } else {
            for (Node start = root; start != null; ) {
                if (start.item.compareTo(elem) > 0) {
                    if (start.left != null) {
                        start = start.left;
                    } else {
                        start.left = new Node(elem, start, null, null);
                        break;
                    }
                } else if (start.item.compareTo(elem) < 0) {
                    if (start.right != null) {
                        start = start.right;
                    } else {
                        start.right = new Node(elem, start, null, null);
                    }
                } else {
                    break;
                }

            }
        }
    }

    @Override
    public boolean contains(E elem) {
        for (Node start = root; start != null; ){
            if(start.item.equals(elem)) {
                return true;
            } else if(start.item.compareTo(elem) > 0) {
                start = start.left;
            } else if (start.item.compareTo(elem) < 0){
                start = start.right;
            }
        }
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
