// Problem: 724. Find Pivot Index
// Approach: First, calculate the total sum of the array. Then traverse the array while maintaining the left sum. 
//           Calculate the right sum by subtracting the left sum and current element from the total sum. 
//           Return the first index where the left and right sums are equal.
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<=nums.length-1;i++){
            rightSum = totalSum - leftSum - nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
