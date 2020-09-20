package com.evil.tag.sort;

import java.util.Arrays;

/**
 * @author qinhulin
 * @date 2020-09-20
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] nums = {8, 9, 5, 4, 3, 7, 6, 2, 1};

        Arrays.stream(sort(nums)).forEach(System.out::println);

    }


    public static int[] sort(int[] nums) {

        for(int i=0;i<nums.length-1;i++){
            int minIndex=i;
            //找出最小元素
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[minIndex]){
                   minIndex=j;
                }
            }
           //将最小元素和第一个元素交换
            if(minIndex!=i){
                nums[i]^=nums[minIndex];
                nums[minIndex]^=nums[i];
                nums[i]^=nums[minIndex];
            }
        }
        return nums;
    }
}
