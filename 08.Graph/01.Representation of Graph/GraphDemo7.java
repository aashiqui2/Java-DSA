import java.util.*;

class EdgeList {
   static  class Edge {
    int src;
    int dest;
    int weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}
    ArrayList<Edge> edgeList = new ArrayList<>();

 
    public void buildFromAdjMatrix(int[][] matrix) {
        int n = matrix.length;


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    edgeList.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
    }

    public void printEdgeList() {
        System.out.println("\nWeighted Edge List:");
        for (Edge e : edgeList) {
            System.out.println(e.src + " -- " + e.dest + " (w=" + e.weight + ")");
        }
    }
}

public class GraphDemo7 {
    public static void main(String[] args) {

        int a[][] = {
            { 0, 5, 0, 0, 2 },
            { 5, 0, 3, 0, 4 },
            { 0, 3, 0, 7, 0 },
            { 0, 0, 7, 0, 6 },
            { 2, 4, 0, 6, 0 }
        };

        EdgeList g = new EdgeList();
        g.buildFromAdjMatrix(a);
        g.printEdgeList();
    }
}
