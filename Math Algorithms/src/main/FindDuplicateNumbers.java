package main;

import java.util.ArrayList;

public class FindDuplicateNumbers {

    public static void main(String[] args) {
        int[] numbers = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        ArrayList<Integer> duplicates = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            int index = Math.abs(numbers[i]) - 1;

            if(numbers[index] < 0) {
                duplicates.add(index + 1);
            }

            numbers[index] = -numbers[index];
        }

        System.out.println(duplicates);
    }
}
