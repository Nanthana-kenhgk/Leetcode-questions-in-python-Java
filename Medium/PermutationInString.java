// Problem: 567. Permutation in String
// Approach: Build a frequency map for s1 and another for the initial window of s2. 
//           Use a fixed-size sliding window to remove the outgoing character and add the incoming character. 
//           Compare the frequency maps at each step to check whether the current window is a permutation of s1.
// Time Complexity: O(m * k + n), where m is the length of s2, n is the length of s1, and k is the number of distinct characters (at most 26).
// Space Complexity: O(k) - For storing character frequencies in the two HashMaps.
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character,Integer> map1 = new HashMap<>();
        HashMap <Character,Integer> map2 = new HashMap<>();
        int n = s1.length();
        if(s1.length()>s2.length()){
            return false;
        }
        for(char c : s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int i=0;
        for(i=0;i<n;i++){
            char c = s2.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }
        for(;i<s2.length();i++){
            char c = s2.charAt(i);
            char out = s2.charAt(i - n);
            if(map2.containsKey(out)){
                if(map2.get(out)==1){
                    map2.remove(out);
                }
                else{
                    map2.put(out,map2.get(out)-1);
                }
            }
            map2.put(c,map2.getOrDefault(c,0)+1);
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }
}
