package DSA.BFS_DFS;

import java.util.*;

//we cant use Dijkstra Algo directly for this, we have to modify it, so we have to store/focus everything in terms of stops
//https://www.youtube.com/watch?v=vebK1z7rgvM
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {

    //TC: O(N + e*k)
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create the adjacency list to depict airports and flights in the form of a graph.
        //we can also use ArrayList as shown in Dijkstra Algo code
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>())
                    .add(new int[] {flight[1], flight[2]});
        }

        // Distance array to store the updated distances from the source.
        int[] shortDist = new int[n];
        Arrays.fill(shortDist, Integer.MAX_VALUE);
        shortDist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0, 0});  //queue(node, distance, stops)

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int node = temp[0];
            int distance = temp[1];
            int stops = temp[2];

            // If the current node is the destination, and we're within the maximum stops, consider returning the cost
            if (node == dst) continue;

            // Proceed only if we have allowable stops left
            if (stops <= k) {
                // Process all connected flights
                for (int[] flight : adj.getOrDefault(node, new ArrayList<>())) {
                    int nextNode = flight[0];
                    int distanceToNext = flight[1];
                    int newDistance = distance + distanceToNext;
                    // Continue only if newCost is cheaper than known cost to nextNode
                    if (newDistance < shortDist[nextNode]) {
                        shortDist[nextNode] = newDistance;
                        queue.add(new int[] {nextNode, newDistance, stops + 1});
                    }
                }
            }
        }

        return shortDist[dst] == Integer.MAX_VALUE ? -1 : shortDist[dst];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        int cheapestPrice = findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + cheapestPrice);
    }
}
