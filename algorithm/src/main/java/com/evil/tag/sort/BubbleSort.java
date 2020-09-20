package com.evil.tag.sort;

import java.util.Arrays;

/**
 * @author qinhulin
 * @date 2020-09-19
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] nums = {8, 9, 5, 4, 1, 7, 6, 2, 3};

        Arrays.stream(sort(nums)).forEach(System.out::println);
    }


    public static int[] sort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] ^= nums[j + 1];
                    nums[j + 1] ^= nums[j];
                    nums[j] ^= nums[j + 1];
                }
            }
        }
        return nums;
    }
}
