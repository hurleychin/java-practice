package com.evil.leetcode.tags.string;

/**
 * @author qinhulin on 2020-09-22
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

//        System.out.println(horizontalScanning(strs1));
//        System.out.println(horizontalScanning(strs2));

        System.out.println(binarySearch(strs1));

    }

    //
    // LCP(s1,s2,s3...sn)=LCP(LCP(LCP(s1,s2),s3),...sn)
    // Time complexity : O(S) =O(mn) , where S is the sum of all characters in all strings.
    // Space complexity : O(1). We only used constant extra space.
    public static String horizontalScanning(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; //如果已经是空，中断循环
            }
        }
        return prefix;


    }

    // Time complexity : O(S) =O(mn) , where S is the sum of all characters in all strings.
    // Space complexity : O(1). We only used constant extra space.
    public static String verticalScanning(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //Time complexity : O(S) = O(mn)
    //Space complexity : O(mlogn)

    public static String divideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return divideAndConquer(strs, 0, strs.length - 1);
    }
    private static String divideAndConquer(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }

        int mid = l+(r - l) / 2; //防止l+r溢出

        String lStr = divideAndConquer(strs, l, mid);
        String rStr = divideAndConquer(strs, mid + 1, r);

       return commonPrefix(lStr,rStr) ;

    }
    private static String commonPrefix(String lStr,String rStr){
       int min=Math.min(lStr.length(),rStr.length());
       for(int i=0;i<min;i++){
          if(lStr.charAt(i)!=rStr.charAt(i)){
              return lStr.substring(0,i);
          }
        }
       return lStr.substring(0,min);
    }


    //Time complexity : O(Slogm)  , where S is the sum of all characters in all strings.
    //Space complexity : O(1). We only used constant extra space.
    public static String binarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length()); //找出最小长度的元素

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

}
