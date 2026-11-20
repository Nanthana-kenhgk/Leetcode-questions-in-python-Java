// Problem: 704. Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            int val = nums[mid];
            System.out.println(val);
            if(val==target){
                return mid;
            }
            else if(val<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
