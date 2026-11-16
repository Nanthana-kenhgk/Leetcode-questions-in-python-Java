// Problem: 141. Linked List Cycle
// Topic: Linked List
// Given two Strings s and t, output true if ithey are an anagram else false
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character,Integer> map = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            else{
                int v = map.get(c) - 1;
                if(v==0){
                    map.remove(c);
                }
                else{
                    map.put(c,v);
                }
            }
        }
        return map.isEmpty();
    }
}
