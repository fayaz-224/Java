package DSA.Graph;

import java.util.*;

//Using Greedy method
//https://www.youtube.com/watch?v=XB4MIexjvY0
//SingleSourceShortestPath using Dijkstra’s Algorithm - undirected, connected graph
class DijkstraAlgo {

    static class Pair {
        int destination;
        int weight;

        public Pair(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int vertices, int src, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list from the edges array
        for (int[] edge : edges) {
            int u = edge[0]; //source vertex
            int v = edge[1]; //destination vertex
            int w = edge[2];  //distance from S to D
            adjList.get(u).add(new Pair(v, w));
        }
//        System.out.println("Adjacency List:");  //to see data in adj list
//        for (int u = 0; u < vertices; u++) {
//            System.out.print(u + " -> ");
//            for (Pair neighbor : adjList.get(u)) {
//                System.out.print("(" + neighbor.destination + ", " + neighbor.weight + ") ");
//            }
//            System.out.println();
//        }

        // Distance array
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Priority queue to get the minimum weight edge at each step
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));  //when comparing two arrays, look at index 1 (the cost/distance) and sort by that.
        pq.offer(new int[]{src, 0}); // pq(node, distance from src)

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int distance = current[1];

            // Traverse all neighbors
            for (Pair neighbor : adjList.get(currentNode)) {
                int neighborNode = neighbor.destination;
                int weight = neighbor.weight;
                int newDist = distance + weight;

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
        int vertices = 4;  //nodes

        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {2, 3, 4}, {3, 1, -6}, {0, 3, 8}};  //{source, destination, weight} - Instead of pair obj as below we can use int[] also
        int sourceVertex = 0;  //choose any vertex/node as source vertex

// Another way for edges
//        List<List<Edge>> graph = new ArrayList<>();
//        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());
//
//        graph.get(0).add(new Pair(1, 1));
//        graph.get(1).add(new Pair(2, 3));
//        graph.get(2).add(new Pair(3, 4));
//        graph.get(0).add(new Pair(3, 8));

        int[] dist = graph.dijkstra(vertices, sourceVertex, edges);
        System.out.println("Vertex Distance from Source Vertex:");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}


/*
output:
Vertex Distance from Source Vertex:
0 		 0
1 		 1
2 		 4
3 		 8
 */