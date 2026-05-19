class Graph {
    int[][] adjMatrix;
    int V;

    Graph(int[][] matrix) {
        adjMatrix = matrix;
        V = matrix.length;
    }

    public void printMatrix() {
        System.out.println("Weighted Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printNeighbors() {
        System.out.println("\nNeighbors with weights:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.print("(" + j + ", w=" + adjMatrix[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }
}

public class GraphDemo4 {
    public static void main(String[] args) {

        int a[][] = {
            { 0, 5, 0, 0, 2 },
            { 5, 0, 3, 0, 4 },
            { 0, 3, 0, 7, 0 },
            { 0, 0, 7, 0, 6 },
            { 2, 4, 0, 6, 0 }
        };

        Graph g = new Graph(a);
        g.printMatrix();
        g.printNeighbors();
    }
}
