package com.evil.sort;

/**
 * @author qinhulin
 * @date 2020-09-19
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void sort(int[] nums) {

        /* 思想：将最大的“冒泡”到最后
         * nums[0]>nums[1]?交换:不交换
         * nums[1]>nums[2]?交换:不交换
         * nums[2]>nums[3]?交换：不交换
         * ...
         * nums[len-1-1]>nums[len-1]
         */
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }


    }
}
