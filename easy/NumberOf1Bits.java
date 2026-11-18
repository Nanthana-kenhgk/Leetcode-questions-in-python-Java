// Problem: 191. Number of 1 Bits
// Approach: Iterate through the binary representation using right shifts. Check the least significant bit using (i & 1) and increment the counter whenever it is 1.
// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int hammingWeight(int n) {
        int num = 0;
        for(int i=n;i>0;i>>=1){
            num+= (i & 1);
        }
        return num;
    }
}
