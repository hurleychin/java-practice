package com.evil.leetcode.tags.array;

/**
 * @author qinhulin on 2020-09-28
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1= {3,2,2,3};
        int[] nums2={0,1,2,2,3,0,4,2};

        int len1=remove(nums1,3);
        int len2=remove(nums2,2);

        printRemovedNums(nums1,len1);
        printRemovedNums(nums2,len2);

    }

    public static int remove(int nums[], int val) {


        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    private static void printRemovedNums(int nums[], int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ((i == len - 1) ? "" : ","));
        }
        System.out.println();

    }
}
