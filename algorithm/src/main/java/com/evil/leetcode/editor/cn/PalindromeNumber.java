package com.evil.leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        return isPalindromeByString(x);
    }

    public boolean isPalindromeByString(int x){
       StringBuilder sb=new StringBuilder(x);
        if(sb.reverse().equals(sb)){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}