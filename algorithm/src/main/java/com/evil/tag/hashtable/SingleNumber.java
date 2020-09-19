package com.evil.tag.hashtable;

import java.util.*;

/**
 * @author qinhulin on 2020-09-16
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1={4,1,2,1,2};
        int[] nums2={2,2,1};

        SingleNumber singleNumber=new SingleNumber();

        System.out.printf("%d,%d%n",singleNumber.listOperation(nums1),singleNumber.listOperation(nums2));
        System.out.printf("%d,%d%n",singleNumber.hashtable(nums1),singleNumber.hashtable(nums2));
        System.out.printf("%d,%d%n",singleNumber.math(nums1),singleNumber.math(nums2));
        System.out.printf("%d,%d%n",singleNumber.bitManipulation(nums1),singleNumber.math(nums2));
    }

    /**
     * * Time complexity : *O(n^2)*. We iterate through nums , taking *O(n)* time. We search the whole list to find whether there is duplicate number, taking *O(n)* time. Because search is in the `for` loop, so we have to multiply both time complexities which is *O(n^2)*.
     * * Space complexity : *O(n)*.  We need a list of size *n* to contain elements in nums .
     */

    public int listOperation(int[] nums) {
        List<Integer> noDuplicateList= new ArrayList<>();
        for(int i=0;i<nums.length;i++){

            if(noDuplicateList.contains(nums[i])){
               noDuplicateList.remove(new Integer(nums[i])) ;
            }else {
               noDuplicateList.add(nums[i]) ;
            }
        }
        return noDuplicateList.get(0);

    }

    /**
     *
     * Time complexity : Time complexity of for loop is O(n).
     * Space complexity : O(n)  The space required by hashtable  is equal to the number of elements in nums  .
     */

    public int hashtable(int[] nums){

        Map<Integer,Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (int i:nums){
            if(map.get(i).equals(1)){
                return i;
            }
        }

        return 0;
    }

    /**
     *  2*(a+b+c)-(a+a+b+b+c)=c
     *Time complexity : O(n + n) = O(n). sum will call next to iterate through textnums  . We can see it as sum(list(i, for i in nums)) which means the time complexity is O(n) because of the number of elements(n) in textnums  .
     *Space complexity : O(n + n) = O(n). set needs space for the elements in nums
     */
    public int math(int[] nums){
        int sumOfSet=0,sumOfNums=0;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(!set.contains(i)){
               set.add(i) ;
               sumOfSet+=i;
            }
            sumOfNums+=i;
        }

        return 2*sumOfSet-sumOfNums;

    }

    /**
     * a^0=a
     * a^a=0
     * a^b^a=a^a^b=0^b=b
     *Time complexity : O(n). We only iterate through textnums  , so the time complexity is the number of elements in textnums  .
     *Space complexity : O(1).*
     */
    public int bitManipulation(int[] nums){

        int num=0;
        for(int i:nums){
           num^=i;
        }
        return num;

    }
}
