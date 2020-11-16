package main;

public class FloydsAlgorithm {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};

        int harePointer = 0;
        int tortoisePointer = 0;

        while (true) {
            harePointer = numbers[harePointer];
            tortoisePointer = numbers[numbers[tortoisePointer]];

            if(harePointer == tortoisePointer) {
                System.out.println("Found duplicate number: " + harePointer);
                break;
            }
        }
    }
}
