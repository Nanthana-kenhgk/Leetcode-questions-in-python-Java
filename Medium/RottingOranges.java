// Problem: 994. Rotting Oranges
// given a grid where 0 = empty cell, 1 = fresh orange and 2 = rotting orange, return the minimum time required for fresh oranges to become rotten
/* Approach: 
   use a multi-source BFS and implement it level by level
   at each level increment minutes (level represents minute)
   at each step, rot the adjacent (4-directional) fresh oranges and add them to the queue
   if a fresh orange remains after BFS, return -1     */
// time complexity: O(n*m) | space complexity: O(n*m)
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){                         // if there are no fresh oranges initially then return 0 (no fresh oranges to rotten)
          return 0;
        }
        while(!queue.isEmpty() && fresh>0){
            int size = queue.size();          // number of oranges that will rot the rest in that particular minute
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();    // current rotten orange
                int r = cell[0];
                int c = cell[1];
                if(r>0 && grid[r-1][c]==1){
                    grid[r-1][c] = 2;
                    queue.add(new int[]{r-1,c});
                    fresh--;
                }
                if(r<grid.length-1 && grid[r+1][c]==1){
                    grid[r+1][c] = 2;
                    queue.add(new int[]{r+1,c});
                    fresh--;
                }
                if(c>0 && grid[r][c-1]==1){
                    grid[r][c-1] = 2;
                    queue.add(new int[]{r,c-1});
                    fresh--;
                }
                if(c<grid[0].length-1 && grid[r][c+1]==1){
                    grid[r][c+1] = 2;
                    queue.add(new int[]{r,c+1});
                    fresh--;
                }
            }
            minutes++;                             // increment minute after one level of BFS is completed
        }
        if(fresh>0){
            return -1;                            // if any fresh orange remains return -1
        }
        return minutes;                           // else return minutes (the minutes it took to rot all the fresh oranges)
    }
}
