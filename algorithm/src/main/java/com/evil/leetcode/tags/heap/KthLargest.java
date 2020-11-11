package com.evil.leetcode.tags.heap;

import java.util.PriorityQueue;

/**
 * @author qinhulin on 2020-10-26
 */
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        this.k = k;
       this.q=new PriorityQueue<>(k);
       for(int n:nums){
           add(n);
       }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.add(val);
        } else if (val > q.peek()) {
            q.poll();
            q.add(val);
        }

        return q.peek();

    }

    public static void main(String[] args) {
        int[] nums={4,5,8,2};
        KthLargest kthLargest=new KthLargest(3,nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }

}
