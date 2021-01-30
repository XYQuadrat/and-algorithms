/**
 * BST
 */
public class BST {
    Node root;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        System.out.println(bst.root.getValue());
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            Node parent = root;

            while (current != null) {
                parent = current;
                if (current.getValue() > value) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }

            current = new Node(value);
            if (parent.getValue() > value) {
                parent.setLeft(current);
            } else {
                parent.setRight(current);
            }
        }
    }
}