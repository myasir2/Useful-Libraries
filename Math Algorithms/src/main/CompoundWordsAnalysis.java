package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CompoundWordsAnalysis {

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(Arrays.asList("rain", "rainstorm", "rainbow", "bow", "sun"));
        ArrayList<String> compoundWords = new ArrayList<>();

        for(String word : words) {
            String tempString = "";

            for(char character : word.toCharArray()) {
                tempString += character;

                if(!tempString.equals(word) && words.contains(tempString)) {
                    compoundWords.add(word);
                }
            }
        }

        System.out.println(compoundWords);
    }
}
