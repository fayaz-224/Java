package DSA.BFS_DFS;

import java.util.*;

//Using Greedy method
//https://www.youtube.com/watch?v=XB4MIexjvY0
//SingleSourceShortestPath using Dijkstra’s Algorithm - undirected, connected graph
class Pair {
    int destination;
    int weight;

    public Pair(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class DijkstraAlgo {
    static int vertices = 4;  //nodes
    static int edgeCount = 5;  //edges

    public int[] dijkstra(int src, int[][] edges) {
        // Create adjacency list - Instead of pair obj we can use int[] also
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list from the edges array
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new Pair(v, w));
        }

        // Distance array
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Priority queue to get the minimum weight edge at each step
        PriorityQueue<int[]> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[] {src, 0}); // pq(node, distance from src)


        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];

            // Traverse all neighbors
            for (Pair neighbor : adjList.get(currentNode)) {
                int neighborNode = neighbor.destination;
                int weight = neighbor.weight;
                int newDist = dist[currentNode] + weight;

                if (newDist < dist[neighborNode]) {
                    dist[neighborNode] = newDist;
                    pq.offer(new int[] {neighborNode, newDist});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        DijkstraAlgo graph = new DijkstraAlgo();
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {2, 3, 4}, {3, 1, -6}, {0, 3, 8}};
        int sourceVertex = 0;

        int[] dist = graph.dijkstra(sourceVertex, edges);
        System.out.println("Vertex Distance from Source Vertex:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
