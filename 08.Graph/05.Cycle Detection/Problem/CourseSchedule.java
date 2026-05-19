public class CourseSchedule {
    // DFS to detect cycle in directed graph
    public static boolean isCycledDFS(int src, boolean[] vis, boolean[] recStack, int[][] edges) {
        vis[src] = true;
        recStack[src] = true;

        // Check all edges to find outgoing edges src -> v
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // u -> v exists, so check if src == u
            if (u == src) {
                // Case 1: DFS to unvisited node
                if (!vis[v]) {
                    if (isCycledDFS(v, vis, recStack, edges)) {
                        return true; // cycle found
                    }
                }
                // Case 2: Back-edge found -> cycle
                else if (recStack[v]) {
                    return true;
                }
            }
        }

        recStack[src] = false; // backtrack
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] edges) {
        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // Try DFS from every node
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (isCycledDFS(i, vis, recStack, edges)) {
                    return false; // cycle detected → cannot finish courses
                }
            }
        }
        return true; // no cycle → can finish
    }

    public static void main(String[] args) {
        // Example edges (prerequisites)
        // Format: [course, dependsOn]
        // Example has a cycle: 0→1→2→3

        int[][] edges = {
                { 1, 0 },
                { 2, 0 },
                { 3, 1 },
                { 3, 2 }
        };
        int numCourses = 4;

        // int[][] edges = {
        //         { 1, 0 },
        //         { 2, 1 },
        //         { 0, 2 } // back edge forming cycle
        // };
        // int numCourses = 3;


        boolean result = canFinish(numCourses, edges);

        System.out.println("Can finish all courses? " + result);
    }
}
