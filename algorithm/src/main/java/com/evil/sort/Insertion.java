package com.evil.sort;

import java.util.Arrays;

/**
 * @author qinhulin
 * @date 2020-09-20
 */
public class Insertion {

    public static void main(String[] args) {

        int[] nums = {8, 9, 5, 4, 3, 7, 6, 2, 1};

        Arrays.stream(sort(nums)).forEach(System.out::println);

    }

    public static int[] sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int j=i;
            int key = nums[j];

            while (j>0&&key <nums[j-1]){
                nums[j]=nums[j-1];
                j--;
            }
            nums[j]=key;
        }
        return nums;
    }
}
