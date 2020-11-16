package main;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 4};
        int[] output = new int[numbers.length];
        output[0] = 1;

        for(int i = 1; i < numbers.length; i++) {
            output[i] = numbers[i - 1] * output[i - 1];
        }

        System.out.println(Arrays.toString(output));

        int rightProduct = 1;
        for(int i = numbers.length - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= numbers[i];
        }

        System.out.println(Arrays.toString(output));
    }
}
