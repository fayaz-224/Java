package Arrays;
// Java Program to compute sum of ranges for different range queries

import java.util.*;
  
// Class to represent a query range
class Query{
    int start;
    int end;
    Query(int L, int R){
        start = L;
        end = R;
    }
}
 
class MoAlgorithm
{
    // Prints sum of all query ranges. m is number of queries, n is the size of the array.
    static void printQuerySums(int a[], int n, ArrayList<Query> q, int m)
    {
        for (int i=0; i<m; i++)   // One by one compute sum of all queries
        {
            // Left and right boundaries of current range
            int L = q.get(i).start, R = q.get(i).end;
     
            // Compute sum of current query range
            int sum = 0;
            for (int j=L; j<=R; j++)
                sum += a[j];
            
            System.out.println("Sum of [" + L + ", " + R + "] is "  + sum);
        }
    }
     
    public static void main(String argv[])
    {
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int n = a.length;
         
        ArrayList<Query> q = new ArrayList<Query>();
        q.add(new Query(0,4));	//query ranges for which we need sum
        q.add(new Query(1,3));
        q.add(new Query(2,7));
         
        int m = q.size();
        printQuerySums(a, n, q, m);
    }
}