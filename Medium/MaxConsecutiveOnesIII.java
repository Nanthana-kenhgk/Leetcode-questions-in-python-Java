// Problem: 1004. Max Consecutive Ones III
// Approach: Use a variable-size sliding window to maintain at most k zeros. 
//           Shrink the window when zeros exceed k and update the maximum window length at each step.
// Time Complexity: O(n) - Both pointers move forward at most n times.
// Space Complexity: O(1) - Only a constant number of variables are used.
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int start = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(val==0){
                count++;
            }
            while(count>k){
                if(nums[start]==0){
                    count--;
                }
                start++;
            }
            max = max>i-start+1?max:i-start+1;
        }
        return max;
    }
}
