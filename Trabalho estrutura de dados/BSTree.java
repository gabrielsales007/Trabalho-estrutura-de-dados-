public class BSTree {

    private class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    private Node root;

    public void insert(int v) {
        root = insertRec(root, v);
    }

    private Node insertRec(Node n, int v) {
        if (n == null) return new Node(v);
        if (v < n.val) n.left = insertRec(n.left, v);
        else n.right = insertRec(n.right, v);
        return n;
    }

    public boolean search(int v) {
        return searchRec(root, v);
    }

    private boolean searchRec(Node n, int v) {
        if (n == null) return false;
        if (n.val == v) return true;
        if (v < n.val) return searchRec(n.left, v);
        return searchRec(n.right, v);
    }
}
