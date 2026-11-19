// Problem: 53. Maximum Subarray
// Approach: Use Kadane's algorithm to find the maximum subarray sum by deciding whether to extend the previous subarray or start a new one at each index.
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}
