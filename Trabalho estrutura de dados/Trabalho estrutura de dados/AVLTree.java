public class AVLTree {

    private class Node {
        int val, height;
        Node left, right;

        Node(int v) {
            val = v;
            height = 1;
        }
    }

    private Node root;

    public void insert(int v) {
        root = insertRec(root, v);
    }

    private Node insertRec(Node n, int v) {
        if (n == null) return new Node(v);

        if (v < n.val) n.left = insertRec(n.left, v);
        else n.right = insertRec(n.right, v);

        n.height = 1 + Math.max(height(n.left), height(n.right));

        int balance = getBalance(n);

        if (balance > 1 && v < n.left.val) return rotateRight(n);
        if (balance < -1 && v > n.right.val) return rotateLeft(n);
        if (balance > 1 && v > n.left.val) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (balance < -1 && v < n.right.val) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

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

    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}
   