package Array;

import java.util.*;

// Java Program to compute sum of ranges for different range queries
class Query { // Class to represent a query range
    int start;
    int end;
    Query(int L, int R){
        start = L;
        end = R;
    }
}
 
class MoAlgorithm {
    // Prints sum of all query ranges. m is number of queries, n is the size of the array.
    static void printQuerySums(int arr[], List<Query> q, int m) {
        for (int i=0; i<m; i++) {  // One by one compute sum of all queries
            // Left and right boundaries of current range
            int left = q.get(i).start;
            int right = q.get(i).end;
     
            // Compute sum of current query range
            int sum = 0;
            for (int j=left; j<=right; j++)
                sum += arr[j];
            
            System.out.println("Sum of [" + left + ", " + right + "] is "  + sum);
        }
    }
     
    public static void main(String argv[]){
        int arr[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
         
        List<Query> q = new ArrayList<>();
        q.add(new Query(0,4));	//query ranges for which we need sum
        q.add(new Query(1,3));
        q.add(new Query(2,7));
         
        int m = q.size();
        printQuerySums(arr, q, m);
    }
}