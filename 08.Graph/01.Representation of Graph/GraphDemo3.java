class Graph {
    int[][] adjMatrix;
    int V; 

    Graph(int[][] matrix) {
        adjMatrix = matrix; 
        V = matrix.length;
    }

    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printNeighbors() {
        System.out.println("\nNeighbors of each vertex:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int u, int v) {
        return adjMatrix[u][v] != 0;
    }
}

public class GraphDemo3
 {
    public static void main(String[] args) {

        //! ------------------- Adjacency Matrix---------------
        int a[][] = {
            { 0, 1, 0, 0, 1 },
            { 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 1 },
            { 1, 1, 0, 1, 0 }
        };

        Graph g = new Graph(a);

        g.printMatrix();       // print the adjacency matrix
        g.printNeighbors();    // print neighbors of each vertex

        System.out.println("\nCheck edge between 0 and 4: " + g.hasEdge(0, 4));
        System.out.println("Check edge between 0 and 2: " + g.hasEdge(0, 2));
    }
}
