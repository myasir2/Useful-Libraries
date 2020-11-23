package main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {

    public static void main(String[] args) {
        int[][] points = new int[][] {
            {1, 3},
            {-2, -2}
        };
        int k = 1;

        KClosestPoints kClosestPoints = new KClosestPoints();

        System.out.println(Arrays.deepToString(kClosestPoints.kClosest(points, k)));
    }

    private int[][] kClosest(int[][] points, int k) {
        int[][] closestPoints = new int[k][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((point1, point2) -> {
            double point1Hypotenuse = Math.pow(point1[0], 2) + Math.pow(point1[1], 2);
            point1Hypotenuse = Math.sqrt(point1Hypotenuse);

            double point2Hypotenuse = Math.pow(point2[0], 2) + Math.pow(point2[1], 2);
            point2Hypotenuse = Math.sqrt(point2Hypotenuse);

            return Double.compare(point1Hypotenuse, point2Hypotenuse);
        });

        minHeap.addAll(Arrays.asList(points));

        for(int i = 0; i < closestPoints.length; i++) {
            int[] minPoint = minHeap.remove();

            closestPoints[i][0] = minPoint[0];
            closestPoints[i][1] = minPoint[1];
        }

        return closestPoints;
    }
}
