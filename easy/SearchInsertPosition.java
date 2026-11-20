// Problem: 35. Search Insert Position
// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        int val = 0;
        while(start<=end){
            mid = start + (end-start)/2;
            val = nums[mid];
            if(val==target){
                return mid;
            }
            else if(val>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        if(target>val){
            return mid+1;
        }
        else{
            return mid;
        }
    }
}
