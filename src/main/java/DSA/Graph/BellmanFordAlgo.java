package DSA.Graph;

//In Dijkstra it does not allow -ve edges, But in Bellman Ford allows both +ve and -ve edges (follows DP strategy)
//Bellman–Ford naturally works by relaxing edges multiple times.
//we are achieving SingleSourceShortestPath using BellmanFord Algorithm
//https://www.youtube.com/watch?v=FtN3BYH2Zes
class BellmanFordAlgo {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int[] bellmanFord(int vertices, int src, int[][] edges) {
        int[] dist = new int[vertices];
        for (int i = 0; i < vertices; i++) {  //Arrays.fill(distance, Integer.MAX_VALUE);
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Relaxation
        for (int i = 0; i < vertices - 1; i++) {  //there will be vertices-1 nodes btw src to des. so we need to Relax edges V-1 times
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative weight cycles - It's a disadvantage of BellmanFord
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return new int[]{-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        BellmanFordAlgo graph = new BellmanFordAlgo();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {2, 3, 4}, {3, 1, -6}, {0, 3, 8}};  //we can generate edges from Edge class also
        int sourceVertex = 0;

        int vertices = 4;  //nodes
        int[] distance = graph.bellmanFord(vertices, sourceVertex, edges);
        System.out.println("Vertex Distance from Source Vertex:");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }
}
