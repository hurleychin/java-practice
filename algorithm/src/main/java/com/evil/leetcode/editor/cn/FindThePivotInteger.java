package com.evil.leetcode.editor.cn;

public class FindThePivotInteger {
    public static void main(String[] args) {
        Solution solution = new FindThePivotInteger().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotInteger(int n) {

        for(int pivot=1;pivot<=n;pivot++){

            int left = 0,right=0;
            for(int i=1;i<=pivot;i++){
                left+=i;
            }
            for(int i=pivot;i<=n;i++){
                right+=i;
            }

            if( left==right){
                return pivot;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}