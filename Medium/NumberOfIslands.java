// Problem: 200. Number of Islands
// Approach: Traverse the grid and start BFS whenever an unvisited land cell is found. 
//           Each BFS explores and marks all horizontally and vertically connected land cells as visited, representing one complete island.
// Time Complexity: O(m * n) - Each cell is visited at most once.
// Space Complexity: O(m * n) - Visited matrix and BFS queue.
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int i, int j, boolean[][] visited){
        Queue <int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            if(r>0 && grid[r-1][c]=='1' && !visited[r-1][c]){
                visited[r-1][c] = true;
                queue.add(new int[]{r-1,c});
            }
            if(r<grid.length-1 && grid[r+1][c]=='1' && !visited[r+1][c]){
                visited[r+1][c] = true;
                queue.add(new int[]{r+1,c});
            }
            if(c>0 && grid[r][c-1]=='1' && !visited[r][c-1]){
                visited[r][c-1] = true;
                queue.add(new int[]{r,c-1});
            }
            if(c<grid[0].length-1 && grid[r][c+1]=='1' && !visited[r][c+1]){
                visited[r][c+1] = true;
                queue.add(new int[]{r,c+1});
            }
        }
    }
}
