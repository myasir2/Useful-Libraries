package main;

import resource.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class IndexToRemoveForPalindrome {

    public IndexToRemoveForPalindrome() {
    }

    public static void main(String[] args) {
        String string = "abcdeba";

        IndexToRemoveForPalindrome indexToRemoveForPalindrome = new IndexToRemoveForPalindrome();

        System.out.println(indexToRemoveForPalindrome.indicesToRemove(string));
    }

    private int indexToRemove(String string) {
        if (Algorithm.isPalindromeIterative(string)) {
            return -1;
        }

        int lowIndex = 0;
        int highIndex = string.length() - 1;

        while (lowIndex <= highIndex) {
            if (string.charAt(lowIndex) == string.charAt(highIndex)) {
                lowIndex++;
                highIndex--;
            }
            else {
                if (Algorithm.isPalindromeIterative(string.substring(lowIndex + 1, highIndex))) {
                    return lowIndex;
                }
                else if (Algorithm.isPalindromeIterative(string.substring(lowIndex, highIndex - 1))) {
                    return highIndex;
                }
            }
        }

        return -1;
    }

    private List<Integer> indicesToRemove(String string) {
        List<Integer> indices = new ArrayList<>();

        if (Algorithm.isPalindromeIterative(string)) {
            return indices;
        }

        int lowIndex = 0;
        int highIndex = string.length() - 1;

        while (lowIndex <= highIndex) {
            if (string.charAt(lowIndex) != string.charAt(highIndex)) {
                if (Algorithm.isPalindromeIterative(string.substring(lowIndex + 1, highIndex))) {
                    indices.add(lowIndex);
                }

                if (Algorithm.isPalindromeIterative(string.substring(lowIndex, highIndex - 1))) {
                    indices.add(highIndex);
                }
            }

            lowIndex++;
            highIndex--;
        }

        return indices;
    }
}