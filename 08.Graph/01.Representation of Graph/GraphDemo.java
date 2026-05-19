import java.util.*;

//! Graph using Array of ArrayList (Adjacency List) 
class Graph {
    ArrayList<Integer> adjList[];

    Graph(int v) {
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

   
    public void printAdjList() {
        System.out.println("\nAdjacency List (Array Version):");
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int val : adjList[i]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
public class GraphDemo {
    public static void main(String[] args) {

        int vertices=5;

        Graph g=new Graph(vertices);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 1);

        g.printAdjList(); 
    }      
}
