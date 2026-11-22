// Problem: 56. Merge Intervals
// Approach: Sort intervals by their starting points. 
//           Traverse the sorted intervals and merge overlapping intervals by updating the ending point to the maximum of the two ending points. 
//           Add non-overlapping intervals to the result list.
// Time Complexity: O(n log n)
// Space Complexity: O(n) - For storing the merged intervals.
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> arr = new ArrayList<>();
        int[] interval = intervals[0].clone();
        for(int s = 1;s<intervals.length;s++){
            if(intervals[s][0]<=interval[1]){
                interval[1] = Math.max(interval[1],intervals[s][1]);
            }
            else{
                arr.add(interval);
                interval = intervals[s].clone();
            }
        }
        arr.add(interval);
        return arr.toArray(new int[arr.size()][]);
    }
}
