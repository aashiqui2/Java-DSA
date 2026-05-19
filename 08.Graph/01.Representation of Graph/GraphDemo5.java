import java.util.ArrayList;

public class GraphDemo5 {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // ! get rid of null pointer exception by making the list empty instead of null
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        // System.out.println(graph[0]); // null by default

        // ! when it is null we cannot store any value in the place of null cause NPE (EXCEPTION)
        /*
           graph[0].add(new Edge(1, 2));
           System.out.println(graph[0]);
         */

        createGraph(graph);

        for (int v = 0; v < graph.length; v++) {
            System.out.print("Neighbors of vertex " + v + ": ");

            for (int i = 0; i < graph[v].size(); i++) {
                Edge e = graph[v].get(i);
                System.out.print(e.dest + " ");
            }

            System.out.println();
        }

    }
}