// Problem: 238. Product of Array Except Self
// Approach: Use two passes to calculate prefix and suffix products. First, store the product of all elements to the left of each index. 
//           Then, multiply each position by the product of all elements to its right. This way it takes O(n) to calculate prefix and suffix.

// Time Complexity: O(n)
// Space Complexity: O(1) auxiliary space (excluding the output array)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int arr[] = new int[nums.length];
        arr[0] = 1;
        for(int i=1;i<nums.length;i++){
            arr[i] = prefix*nums[i-1];
            prefix = prefix*nums[i-1];
        }
        int suffix = 1;
        for(int i=nums.length-1;i>0;i--){
            arr[i-1]*= suffix*nums[i];
            suffix = suffix*nums[i];
        }
        return arr;
    }
}
