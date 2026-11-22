// Problem: 455. Assign Cookies
// Approach: Sort the greed factors and cookie sizes. Use two pointers to assign the smallest sufficient cookie to the least greedy child. 
//           If a cookie is too small, move to the next larger cookie.
// Time Complexity: O(n log n + m log m)
// Space Complexity: O(1) 
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int assigned = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                assigned++;
                i++;
                j++;
            }
            else if(g[i]>s[j]){
                j++;
            }
        }
        return assigned;
    }
}
