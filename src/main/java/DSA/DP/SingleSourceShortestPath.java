package DSA.DP;

//This can be achieved by Dijkstra(Greedy) and Bellman Ford(DP) Algorithms
//In Dijkstra it does not allow -ve edges, But in Bellman Ford allows both +ve and -ve edges
//So, we are achieving SingleSourceShortestPath using DP by Bellman Ford Algo
class BellmanFord {

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

    static class SingleSourceShortestPath {
        int vertices;
        Edge[] edges;
        int edgeCount;

        public SingleSourceShortestPath(int vertices, int edgeCount) {
            this.vertices = vertices;
            this.edgeCount = edgeCount;
            edges = new Edge[edgeCount];
        }

        public void addEdge(int edgeIndex, int source, int destination, int weight) {
            edges[edgeIndex] = new Edge(source, destination, weight);
        }

        public void bellmanFord(int src) {
            int[] distance = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            distance[src] = 0;

            // Relax edges repeatedly
            for (int i = 0; i < vertices - 1; i++) {
                for (int j = 0; j < edgeCount; j++) {
                    int u = edges[j].source;
                    int v = edges[j].destination;
                    int weight = edges[j].weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }
                }
            }

            // Check for negative weight cycles.
            for (int j = 0; j < edgeCount; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }

            printSolution(distance, src);
        }

        public void printSolution(int[] distance, int src) {
            System.out.println("Vertex Distance from Source (Vertex " + src + ")");
            for (int i = 0; i < vertices; i++) {
                System.out.println(i + " \t\t " + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        int edges = 5;
        SingleSourceShortestPath graph = new SingleSourceShortestPath(vertices, edges);
        graph.addEdge(0, 0, 1, 1);
        graph.addEdge(1, 1, 2, 3);
        graph.addEdge(2, 2, 3, 4);
        graph.addEdge(3, 3, 1, -6);
        graph.addEdge(4, 0, 3, 8);

        int sourceVertex = 0;
        graph.bellmanFord(sourceVertex);
    }
}
