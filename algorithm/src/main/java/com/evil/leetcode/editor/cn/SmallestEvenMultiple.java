package com.evil.leetcode.editor.cn;

public class SmallestEvenMultiple {
    public static void main(String[] args) {
        Solution solution = new SmallestEvenMultiple().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestEvenMultiple(int n) {
        return n<<(n&1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}