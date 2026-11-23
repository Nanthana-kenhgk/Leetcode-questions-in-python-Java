// Problem: 746. Min Cost Climbing Stairs
// Approach: Use bottom-up dynamic programming to calculate the minimum cost of reaching each position. 
//           For every position, choose the minimum cost between taking one step from the previous stair or two steps from the stair before it.
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost){
        int dp[] = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=cost.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int i;
        for(i=2;i<=cost.length-1;i++){
            dp[i] = Math.min(cost[i-2]+dp[i-2],cost[i-1]+dp[i-1]);
        }
        dp[i] = Math.min(cost[i-2]+dp[i-2],cost[i-1]+dp[i-1]);
        return dp[i];
    }
}
