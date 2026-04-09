// flood fill using dfs
// traverse connected cells with the same original color and change its color
// time complexity: O(m*n) | space complexity: o(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image,sr,sc,image[sr][sc],color,visited);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int og, int color, boolean[][] visited){
        if (sr<0 || sr>=image.length || sc<0 || sc>=image[0].length){
          return;
        }
        if (visited[sr][sc] || image[sr][sc]!=og){
          return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;
        if(sr>0){
            dfs(image,sr-1,sc,og,color,visited);
        }
        if(sr<image.length-1){
            dfs(image,sr+1,sc,og,color,visited);
        }
        if(sc>0){
            dfs(image,sr,sc-1,og,color,visited);
        }
        if(sc<image[0].length-1){
            dfs(image,sr,sc+1,og,color,visited);
        }
    }
}
