// Problem 547. Number of Provinces
// Given an adjacency matrix representing an undirected graph, return the number of provinces (connected components)
// DFS is used to mark all cities (nodes) in a province (connected component) as visited
// time complexity: O(n^2) | space complexity: O(n)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet <Integer> visited = new HashSet<>();
        int count = 0;
        for(int current=0;current<isConnected.length;current++){
            if(!visited.contains(current)){
                count++;
                visited.add(current);
                dfs(isConnected, current, visited);
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, int current, HashSet <Integer> visited){
        for(int neighbour=0;neighbour<isConnected.length;neighbour++){
            if (isConnected[current][neighbour]==1 && !visited.contains(neighbour)){
                visited.add(neighbour);
                dfs(isConnected,neighbour,visited);
            }
        }
    }
}
