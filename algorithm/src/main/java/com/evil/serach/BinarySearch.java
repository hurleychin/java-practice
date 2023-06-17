package com.evil.serach;


/**
 * @author qinhulin on 2020-09-24
 */
public class BinarySearch {
    private int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            //无符号右移 >>>
            //   0111   2^2+2+1=7
            // + 0011   2^1+1=3
            // ----------------
            //   1010   2^3+2=10
            //>>>0101   2^2+1=5
            int mid=(left+right)>>>1; // =right-(right-left)/2;
            if(nums[mid]>=target) return mid;
            if(nums[mid]>target){
                right=mid-1;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}

