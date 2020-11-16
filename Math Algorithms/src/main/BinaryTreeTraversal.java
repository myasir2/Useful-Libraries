package main;

import java.util.LinkedList;

public class BinaryTreeTraversal {

    public Node root;

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
        tree.root.left.right.right.right = new Node(7);
        tree.root.left.right .right.right.right= new Node(8);

        tree.printDfsPreOrder(tree.root);
        System.out.println();

        tree.printDfsInOrder(tree.root);
        System.out.println();

        tree.printDfsPostOrder(tree.root);
        System.out.println();

        System.out.println(tree.getHeight(tree.root));
    }

    private void printBfs(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();

            System.out.print(currentNode.data + " ");

            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    private void printDfsPreOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.print(node.data + " ");

        printDfsPreOrder(node.left);
        printDfsPreOrder(node.right);
    }

    private void printDfsInOrder(Node node) {
        if(node == null) {
            return;
        }

        printDfsPreOrder(node.left);

        System.out.print(node.data + " ");

        printDfsPreOrder(node.right);
    }

    private void printDfsPostOrder(Node node) {
        if(node == null) {
            return;
        }

        printDfsPreOrder(node.left);
        printDfsPreOrder(node.right);

        System.out.print(node.data + " ");
    }

    private int getHeight(Node node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if(leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        else {
            return rightHeight + 1;
        }
    }

    public static class Node {

        public final int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
