// Course Schedule
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visited, visiting)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] visiting) {
        if (visiting[course]) {
            return false;
        }

        if (visited[course]) {
            return true;
        }

        visiting[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited, visiting)) {
                return false;
            }
        }

        visiting[course] = false;
        visited[course] = true;

        return true;
    }
}
