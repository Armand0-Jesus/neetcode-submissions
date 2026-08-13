// Number of Connected Components in an Undirected Graph
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        int count = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, graph, visited);
                count++;
            }
        }
    
        return count;
    }

     public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
     }
}
