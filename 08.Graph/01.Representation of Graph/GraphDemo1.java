import java.util.*;

//! Graph using Array of ArrayList (Adjacency List) 
class Graph {

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    Graph(int v) {
       
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

  
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }


    public void printAdjList() {
        System.out.println("\nAdjacency List (ArrayList Version):");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
public class GraphDemo1 {
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