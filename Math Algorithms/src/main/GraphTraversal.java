package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversal {

    private static final HashMap<Integer, Node> idToNodeMap = new HashMap<>();

    public static void main(String[] args) {
        Node root = new Node(0);
        Node child1 = new Node(1);
        Node child2 = new Node(2);
        Node child3 = new Node(3);

        root.adjacentNodes.add(child2);
        root.adjacentNodes.add(child3);

        child1.adjacentNodes.add(root);
        child1.adjacentNodes.add(child2);
        child1.adjacentNodes.add(new Node(4));

        child2.adjacentNodes.add(child1);

        child3.adjacentNodes.add(child3);
        child3.adjacentNodes.add(new Node(6));
        child3.adjacentNodes.add(new Node(11));
        child3.adjacentNodes.add(new Node(10));

        idToNodeMap.put(0, root);
        idToNodeMap.put(1, child1);
        idToNodeMap.put(2, child2);
        idToNodeMap.put(3, child3);

        depthFirstSearch(root);
    }

    private static void breadthFirstSearch(Node source) {
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();

            System.out.print(currentNode.id + " ");

            visited.add(currentNode.id);

            for(Node adjacentNode : currentNode.adjacentNodes) {
                if (!visited.contains(adjacentNode.id)) {
                    visited.add(adjacentNode.id);
                    queue.add(adjacentNode);
                }
            }
        }
    }

    private static void depthFirstSearch(Node source) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(source);

        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if(!visited.contains(currentNode.id)) {
                System.out.print(currentNode.id + " ");
                visited.add(currentNode.id);
            }

            for(Node adjacentNode : currentNode.adjacentNodes) {
                if (!visited.contains(adjacentNode.id)) {
                    stack.push(adjacentNode);
                }
            }
        }
    }

    public static class Node {

        private int id = 0;
        private final LinkedList<Node> adjacentNodes = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }
    }
}
