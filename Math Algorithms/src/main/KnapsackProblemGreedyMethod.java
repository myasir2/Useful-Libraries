package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KnapsackProblemGreedyMethod {

    public static void main(String[] args) {
        double[] profits = new double[] {10, 5, 15, 7, 6, 18, 3};
        double[] weights = new double[] {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Double> itemsToTake = new ArrayList<>(profits.length);

        for(int i = 0; i < profits.length; i++) {
            double profitsByWeight = profits[i] / weights[i];

            maxHeap.add(profitsByWeight);
        }

        while(capacity >= 0) {
            double valuableItem = maxHeap.poll();
            itemsToTake.add(valuableItem);

            capacity -= valuableItem;
        }

        System.out.println(itemsToTake);
    }
}
