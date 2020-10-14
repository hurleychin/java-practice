package com.evil.serach;


/**
 * @author qinhulin on 2020-09-24
 */
public class BinarySearch {
    public static void main(String[] args) {

        int nums[]={1,4,16,24,31,40,50,63,100};

        System.out.println( search(nums,4));
        System.out.println( search(nums,1));
        System.out.println( search(nums,100));
        System.out.println( search(nums,40));
        System.out.println( search(nums,9));
    }

    private static int search(int[] nums, int target) {
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

