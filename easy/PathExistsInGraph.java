// given n nodes (0 to n-1), an edge list representing an undirected graph and a source and a destination, determine if a path exists between them
// Build an adjacency list and use BFS to check if path exists
// Nodes are marked visited when added to queue to avoid revisiting them
// time complexity: O(V+E) | space complexity: O(V+E)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List <List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet <Integer> visited = new HashSet<>();
        visited.add(source);
        Queue <Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(current==destination){
                return true;
            }
            for (int neighbour: graph.get(current)){
                if (!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }
}
