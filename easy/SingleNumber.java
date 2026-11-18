// Problem: 136. Single Number
// Topic: Bit Manipulation, XOR
// Approach: XOR all array elements. Since a ^ a = 0 and a ^ 0 = a, duplicate elements cancel out, leaving the unique element.
// time complexity: O(n)
// space complexity: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int x: nums){
            ans^=x;
        }
        return ans;
    }
}
