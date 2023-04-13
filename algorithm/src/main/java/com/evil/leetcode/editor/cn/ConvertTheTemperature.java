package com.evil.leetcode.editor.cn;

public class ConvertTheTemperature {
    public static void main(String[] args) {
        Solution solution = new ConvertTheTemperature().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin=celsius+273.15;
        double fahrenheit=celsius*1.80+32.00;

        double [] ans=new double[]{kelvin,fahrenheit};
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}