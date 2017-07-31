package com;

/**
 * Created by PermyakovME on 31.07.2017.
 */
public class ForEach2 {
    public static void main(String[] args) {
        int sum = 0;
        int nums[][] = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = (i + 1)*(j + 1);
            }
        }

        for(int[] x : nums){
            for(int y : x){
                System.out.println("Value: " + y);
                sum += y;
            }
        }
        System.out.println("Sum: " + sum);
    }
}
