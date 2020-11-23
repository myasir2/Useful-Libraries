package main;

public class FindMaximumAverageSubtree {

    private TreeNode<Integer> maxAverageNode = null;
    private double maxAverage = Double.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(20);

        TreeNode<Integer> c1 = new TreeNode<>(12);
        TreeNode<Integer> c2 = new TreeNode<>(18);

        TreeNode<Integer> c3 = new TreeNode<>(11);
        TreeNode<Integer> c4 = new TreeNode<>(2);
        TreeNode<Integer> c5 = new TreeNode<>(3);
        TreeNode<Integer> c6 = new TreeNode<>(15);
        TreeNode<Integer> c7 = new TreeNode<>(8);

        c1.addChild(c3);
        c1.addChild(c4);
        c1.addChild(c5);

        c2.addChild(c6);
        c2.addChild(c7);

        root.addChild(c1);
        root.addChild(c2);

        FindMaximumAverageSubtree maximumAverageSubtree = new FindMaximumAverageSubtree();
        maximumAverageSubtree.findMaxAverageNode(root);

        System.out.println("Max node contains value: " + maximumAverageSubtree.maxAverageNode.getData());
    }

    private double[] findMaxAverageNode(TreeNode<Integer> currentNode) {
        if(currentNode == null) {
            return new double[]{0.0, 0.0};
        }

        double values = currentNode.getData();
        double totalNodes = 1;

        for(TreeNode<Integer> child : currentNode.getChildren()) {
            double[] childResults = findMaxAverageNode(child);

            values += childResults[0];
            totalNodes += childResults[1];
        }

        double average = values / totalNodes;

        if(totalNodes > 1 && average > maxAverage) {
            maxAverage = average;
            maxAverageNode = currentNode;
        }

        return new double[] {values, totalNodes};
    }
}
