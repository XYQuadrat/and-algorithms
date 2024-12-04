public class BinarySearchTree {
    private Node root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        System.out.println(bst.root.value);
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            Node parent = root;

            while (current != null) {
                parent = current;
                if (current.value > value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            current = new Node(value);
            if (parent.value > value) {
                parent.left = current;
            } else {
                parent.right = current;
            }
        }
    }

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}