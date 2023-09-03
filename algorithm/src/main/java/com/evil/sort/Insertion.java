package com.evil.sort;

/**
 * @author qinhulin
 * @date 2020-09-20
 */
public class Insertion {

    /**
     * 从第一个元素开始，将其视为已排序部分。
     * 取出下一个元素，在已排序部分从后向前扫描。
     * 如果已排序部分的当前元素大于取出的元素，将当前元素移到下一个位置。
     * 重复步骤 3，直到找到已排序部分的当前元素小于或等于取出的元素的位置。
     * 将取出的元素插入到该位置。
     * 重复步骤 2~5，直到未排序部分的元素全部插入到已排序部分。
     * @param arr
     */
    public  void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int k=arr[i];
            int j=i-1;

            while (j>=0&&k<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=k;


        }

    }
}
