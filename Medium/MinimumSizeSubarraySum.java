// Problem: 209. Minimum Size Subarray Sum
// Approach: Use a sliding window to find the minimum length subarray whose sum is greater than or equal to the target. 
//           Expand the window by moving the end pointer and shrink it from the start whenever the current sum satisfies the target.
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int val = 0;
        int min = nums.length+1;
        for(int end=0;end<nums.length;end++){
            val+=nums[end];
            while(val>=target){
                int size = end-start+1;
                min = min<=size?min:size;
                val-=nums[start];
                start++;
            }
        }
        if(min==nums.length+1){
            return 0;
        }
        return min;
    }
}
