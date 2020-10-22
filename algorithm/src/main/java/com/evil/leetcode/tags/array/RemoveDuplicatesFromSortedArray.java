package com.evil.leetcode.tags.array;

/**
 * @author qinhulin on 2020-09-28
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len1=removeDuplicates(nums1);
        int len2=removeDuplicates(nums2);

        printRemovedNums(nums1,len1);
        printRemovedNums(nums2,len2);


    }

    public static int removeDuplicates(int nums[]) {

        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private static void printRemovedNums(int nums[], int len){
       for(int i=0;i<len;i++){
           System.out.print(nums[i]+ ((i==len-1)?"":","));
        }
        System.out.println();
    }
}
