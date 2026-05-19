import java.util.*;

// !  Graph using HashMap (Adjacency List)
class Graph {
  
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    Graph(int v) {
        
        for (int i = 0; i < v; i++) {
            adjList.put(i, new ArrayList<Integer>());
        }
    }

   
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    
    public void printAdjList() {
        System.out.println("\nAdjacency List (HashMap Version):");
        for (int key : adjList.keySet()) {
            System.out.print("Vertex " + key + " -> ");
            for (int val : adjList.get(key)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

public class GraphDemo2 {
    public static void main(String[] args) {

        int vertices = 5;
        Graph g = new Graph(vertices);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 1);

        g.addEdge(0, 1);

        g.printAdjList();
    }
}