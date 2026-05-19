import java.util.Stack;
import java.util.ArrayList;

public class TopologicalSorting {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3)); // 2 → 3

        graph[3].add(new Edge(3, 1)); // 3 → 1

        graph[4].add(new Edge(4, 0)); // 4 → 0
        graph[4].add(new Edge(4, 1)); // 4 → 1

        graph[5].add(new Edge(5, 0)); // 5 → 0
        graph[5].add(new Edge(5, 2)); // 5 → 2

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void topoSortUtil(ArrayList<Edge> graph[],boolean vis[],int curr,Stack<Integer> s){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topoSortUtil(graph, vis, e.dest, s);
            }
        }

        s.push(curr);
    }

    public static void topoSort(ArrayList<Edge> graph[]) {
        boolean vis[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i]){
                topoSortUtil(graph,vis,i,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topoSort(graph);
    }
}
