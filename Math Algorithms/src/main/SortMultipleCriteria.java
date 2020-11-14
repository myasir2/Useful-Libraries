package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortMultipleCriteria {

    private static final List<String> LIST = Arrays.asList("Watermelon", "Apple", "Coconut", "Banana", "Berry");

    public static void main(String[] args) {
        LIST.sort(new LexicographicComparator());

        System.out.println(LIST);
    }

    public static class LexicographicComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int comparisonResult = o1.compareToIgnoreCase(o2);

            if(o1.length() > o2.length()) {
                return -1;
            }
            else if(o1.length() < o2.length()) {
                return 1;
            }
            else {
                return comparisonResult;
            }
        }
    }
}
