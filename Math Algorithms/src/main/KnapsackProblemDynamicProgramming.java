package main;

import java.util.Arrays;

public class KnapsackProblemDynamicProgramming {

    public static void main(String[] args) {
        int[] profits = new int[] { 1, 2, 5, 6 };
        int[] weights = new int[] { 2, 3, 4, 5 };
        int capacity = 8;

        System.out.println("Maximum profit: " + getMaximumProfit(profits, weights, capacity));
    }

    private static int getMaximumProfit(int[] profits, int[] weights, int capacity) {
        int[][] table = new int[profits.length + 1][capacity + 1];

        for(int column = 0; column <= weights.length; column++) {
            table[0][column] = 0;
        }

        for(int i = 1; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                if(weights[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                }
                else {
                    table[i][j] = Math.max(
                            table[i - 1][j],
                            table[i - 1][j - weights[i - 1]] + profits[i - 1]
                    );
                }
            }
        }

        System.out.println(Arrays.deepToString(table));

        return table[profits.length][capacity];
    }
}
