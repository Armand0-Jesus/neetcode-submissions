// Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        int[] order = new int[numCourses];
        int[] index = {numCourses - 1};

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visited, visiting, order, index)) {
                return new int[0];
            }
        }

        return order;
    }

    public boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] visiting,
        int[] order, int[] index) {
        if (visiting[course]) {
            return false;
        }

        if (visited[course]) {
            return true;
        }

        visiting[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited, visiting, order, index)) {
                return false;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        order[index[0]] = course;
        index[0]--;

        return true;
    }
}
