package DSA.BFS_DFS;

//This can be achieved by Dijkstra(Greedy) and Bellman Ford(DP) Algorithms
//In Dijkstra it does not allow -ve edges, But in Bellman Ford allows both +ve and -ve edges
//we are achieving SingleSourceShortestPath using Dijkstra’s Algorithm
class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class BellmanFordAlgo {
    static int vertices = 4;  //nodes
    static int edgeCount = 5;  //edges

    public int[] bellmanFord(int src, int[][] edges) {
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {  //Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        // Relax edges repeatedly
        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j < edgeCount; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative weight cycles.
        for (int j = 0; j < edgeCount; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return new int[]{-1};
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        BellmanFordAlgo graph = new BellmanFordAlgo();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {2, 3, 4}, {3, 1, -6}, {0, 3, 8}};
        int sourceVertex = 0;

        int[] distance = graph.bellmanFord(sourceVertex, edges);
        System.out.println("Vertex Distance from Source Vertex:");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }
}
