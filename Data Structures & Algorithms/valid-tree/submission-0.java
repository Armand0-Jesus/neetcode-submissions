// Graph Valid Tree
class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        for (boolean node : visited) {
            if (!node) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            } else if (!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
