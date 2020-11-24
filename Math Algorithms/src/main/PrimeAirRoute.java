package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class PrimeAirRoute {

    public static void main(String[] args) {
        List<int[]> a = new ArrayList<>(
            Arrays.asList(new int[] {1, 3},
                new int[] {2, 5},
                new int[] {3, 7},
                new int[] {4, 10}
            )
        );
        List<int[]> b = new ArrayList<>(
            Arrays.asList(new int[] {1, 2},
                new int[] {2, 3},
                new int[] {3, 4},
                new int[] {4, 5}
            )
        );
        int target = 10;

        PrimeAirRoute primeAirRoute = new PrimeAirRoute();
        List<int[]> optimalPairs = primeAirRoute.findOptimalPairs(a, b, target);

        for(int[] optimalPair : optimalPairs) {
            System.out.println(Arrays.toString(optimalPair));
        }
    }

    private List<int[]> findOptimalPairs(List<int[]> a, List<int[]> b, int target) {
        TreeMap<Integer, List<int[]>> sumsToIds = new TreeMap<>();

        for(int[] aRecord : a) {
            for(int[] bRecord : b) {
                int sum = aRecord[1] + bRecord[1];

                List<int[]> ids = sumsToIds.getOrDefault(sum, new ArrayList<>());
                ids.add(new int[] {aRecord[0], bRecord[0]});

                sumsToIds.put(sum, ids);
            }
        }

        return sumsToIds.floorEntry(target).getValue();
    }
}
