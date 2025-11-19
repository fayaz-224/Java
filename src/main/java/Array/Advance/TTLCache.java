package Array.Advance;

import java.util.*;

//Implement a prototype of a time-to-live cache. determine the number of data items present in the cache at each query time.
//Optimised: use binary search
public class TTLCache {

    //Brute force
    public static int[] cacheItems(int[][] data, int[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int[] item : data) {
                int start = item[0];
                int end = start + item[1];
                if (queries[i] >= start && queries[i] <= end) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] data = {
                {105231, 183},
                {105334, 34},
                {105198, 543}
        };
        int[] queries = {105338, 105410};

        System.out.println(Arrays.toString(cacheItems(data, queries))); // Output: [3, 2]
    }
}

/*
Every data item has:
    a start time (when it was added to the cache)
    a time-to-live (TTL) — how long it stays in the cache

startTime = data[i][0]
endTime = data[i][0] + data[i][1]
That means:
The data item is in the cache at any time t where startTime ≤ t ≤ endTime


For each query time (like 105338, 105410, etc.),
we must find how many items are still alive (still in the cache).

Let’s compute when each item expires:
Index	Start Time	TTL	    End Time (= start + TTL)
1	    105231	    183	    105414
2	    105334	    34	    105368
3	    105198	    543	    105741

Query 1 → 105338
We check each item:
Data alive at 105338?	Why
1	✅ yes	            105231 ≤ 105338 ≤ 105414
2	✅ yes	            105334 ≤ 105338 ≤ 105368
3	✅ yes	            105198 ≤ 105338 ≤ 105741

3 items alive

Query 2 → 105410
We check again:
Data alive at 105410?	Why
1	✅ yes	            105231 ≤ 105410 ≤ 105414
2	❌ no	            105410 > 105368
3	✅ yes	            105198 ≤ 105410 ≤ 105741

2 items alive

Therefore, op → [3, 2]
 */