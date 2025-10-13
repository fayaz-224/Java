package DSA.Prefix_Sufix;

public class CorporateFlightBookings {
    //Bruteforce
    public int[] corpFlightBookings1(int[][] bookings, int n) {

        int[] res = new int[n];
        for(int[] curr : bookings){
            int start = curr[0]-1;  // to make 0-index
            int end = curr[1];  //exclusive
            int val = curr[2];

            for(int i = start ; i < end ; i++){
                res[i] += val;
            }
        }
        return res;
    }

    //Prefix
    public int[] corpFlightBookings2(int[][] bookings, int n) {

        int[] res = new int[n];
        for(int[] curr : bookings){
            int start = curr[0]-1;  //Since flight indices are 1-based and array indices in Java are 0-based, use first - 1 for correct indices.
            int end = curr[1];  //exclusive
            int seats = curr[2];

            res[start] += seats; // Start adding seats from this flight
            if(end < n){
                res[end] -= seats;
                //we ensure that the increment of seats no longer affects positions beyond the end when a prefix sum is performed.

                //Instead of updating every element from start-1 to end-1 with seats, we:
                //Add seats at start-1
                //Subtract seats at end, so that when we compute the prefix sum, the addition stops at the correct point (end) will not propagate to other indices means, addition will be done from start-1 to end-1.
            }
        }

        // Apply the prefix sum to propagate the effect of the difference array
        for(int i = 1 ; i < n ; i++){
            res[i] += res[i-1];  //Add the value of the previous index to the current index
        }
        return res;
    }

    public static void main(String[] args) {
        CorporateFlightBookings fb = new CorporateFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};  //[firstFlight, lastFlight, seatsBooked]
        int n = 5;  //no. of flights

        int[] result = fb.corpFlightBookings1(bookings, n);

        System.out.println("Seats booked on each flight:");
        for (int seats : result) {
            System.out.print(seats + " ");  //[10,55,45,25,25]
        }
    }
}


/*
Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]

Explanation:
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]


DRY RUN:
Initialization:
Start with an empty array, res, based on the number of flights n = 5.
res = [0, 0, 0, 0, 0]

Booking 1: {1, 2, 10}
Start: 1 - 1 = 0
End: 2
Seats: 10
Apply:
res[start] += 10 → res[0] += 10 » res = [10, 0, 0, 0, 0]
res[end] -= 10 → res[2] -= 10 » res = [10, 0, -10, 0, 0]

Booking 2: {2, 3, 20}
Start: 2 - 1 = 1
End: 3
Seats: 20
Apply:
res[start] += 20 → res[1] += 20 » res = [10, 20, -10, 0, 0]
res[end] -= 20 → res[3] -= 20 » res = [10, 20, -10, -20, 0]

Booking 3: {2, 5, 25}
Start: 2 - 1 = 1
End: 5
Seats: 25
Apply:
res[start] += 25 → res[1] += 25 » res = [10, 45, -10, -20, 0]
Because the end is 5, it matches exactly the length of res, thus no decrement for overflow beyond the last index.

Compute the final seats with a prefix sum:
Start with res = [10, 45, -10, -20, 0].
Perform Prefix Sum:
res[1] += res[0] → res[1] = 45 + 10 = 55
res[2] += res[1] → res[2] = -10 + 55 = 45
res[3] += res[2] → res[3] = -20 + 45 = 25
res[4] += res[3] → res[4] = 0 + 25 = 25

Final res after prefix sum:
res = [10, 55, 45, 25, 25]
*/