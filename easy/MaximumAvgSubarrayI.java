// Problem: 643. Maximum Average Subarray I
// Approach: Calculate the sum of the first k elements to initialize a fixed-size sliding window. 
//           Slide the window by adding the incoming element and subtracting the outgoing element. 
//           Maintain the maximum window sum and divide it by k at the end to obtain the maximum average.
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double sum = 0;
        int i;
        for(i=0;i<k;i++){
            maxSum+= nums[i];
        }
        sum = maxSum;
        for(;i<nums.length;i++){
            sum += (nums[i] - nums[i-k]);
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum/k;
    }
}
