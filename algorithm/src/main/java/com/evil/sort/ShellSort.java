package com.evil.sort;

import java.util.Arrays;

/**
 * @author qinhulin
 * @date 2020-09-28
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums={6,5,3,9,8,7,2,4,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sort(int[] arr){
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
