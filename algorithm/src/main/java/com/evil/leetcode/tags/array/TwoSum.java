package com.evil.leetcode.tags.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 16818 👎 608

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        int[] nums = {2, 4, 5, 9, 11};
        int target = 20;
        Arrays.stream(twoSum.onePassHashTable(nums, target)).forEach(System.out::println);
    }


    /**
     *  One-pass Hash Table
     *
     * Time complexity : O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
    public int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        /*for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }*/
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[]{map.get(k),i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
