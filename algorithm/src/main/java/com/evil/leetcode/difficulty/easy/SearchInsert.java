package com.evil.leetcode.difficulty.easy;

/**
 * @author qinhulin on 2020-10-14
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,7));
        System.out.println(searchInsert(nums,0));

    }

    public static  int searchInsert(int[] nums, int target) {
        int ans=nums.length;
       int low=0;
       int high=nums.length-1;
       while (low<=high){
           int mid=(low+high)>>>1;
           if(nums[mid]>=target){
               ans=mid;
               high=mid-1;
//               return mid;
           }
           if(nums[mid]<target){
               low=mid+1;
           }
//           if(nums[mid]>target){
//               high=mid-1;
//           }
       }
       return ans;
    }
}
