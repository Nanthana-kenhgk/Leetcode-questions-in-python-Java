// Problem: 198. House Robber
// Approach: Use dynamic programming to calculate the maximum money that can be robbed up to each house. 
//           At every index, choose between robbing the current house and adding its value to the maximum amount from two houses before, 
//           or skipping it and retaining the previous maximum.
// Recurrence: dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1])
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length==1){
            return dp[0];
        }
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<=nums.length-1;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
