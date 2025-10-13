package DSA.BFS_DFS;

import java.util.*;

//we cant use Dijkstra Algo directly for this, we have to modify it, so we have to store/focus everything in terms of stops
//https://www.youtube.com/watch?v=vebK1z7rgvM
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice1(int n, int[][] flights, int src, int dest, int K) {  //Bellman–Ford style = O(K*E)
        // distance array initialized with infinity
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges up to K+1 times (shortest path with at most K stops has at most K+1 edges.)
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(dist, n); // keep previous iteration
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp; // update
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {  //Dijkstra style = O(E log V)
        // Build adjacency list: we can also use Map
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]}); // {destination, price}
        }

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();  //we should use Priority queue on cost
        queue.offer(new int[] {src, 0, 0});  //{city, distance, stops}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            int stops = current[2];

            // If the current node is the destination, and we're within the maximum stops, consider returning the cost
            if (node == dst) return distance;

            // Proceed only if we have allowable stops left
            if (stops <= k) {
                for (int[] nextFlight : adjList.get(node)) {
                    int nextNode = nextFlight[0];
                    int distanceToNext = nextFlight[1];
                    int newDistance = distance + distanceToNext;

                    if (newDistance < dist[nextNode]) {
                        dist[nextNode] = newDistance;
                        queue.add(new int[] {nextNode, newDistance, stops + 1});  //increment stops
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100},
                            {1, 2, 100},
                            {2, 3, 100},
                            {0, 2, 500}};  //{from, to, cost}
        int src = 0;
        int dst = 3;
        int k = 1; //stops

        int cheapestPrice = findCheapestPrice1(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + cheapestPrice);  //600
    }
}
