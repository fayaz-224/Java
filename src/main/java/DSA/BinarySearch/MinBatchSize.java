package DSA.BinarySearch;

//A machine learning training pipeline processes data in batches to optimize graphics processing unit (GPU) utilization.
// Several users contribute data samples, and the pipeline divides them into batches of a specific size. All data must be processed.
// Multiple users' data cannot be combined for processing. The number of batches across all users cannot exceed a limit.
// Determine the minimum batch size.
public class MinBatchSize {

    public static int minBatchSize(int[] dataSamples, int maxBatches) {
        int left = 1;  // smallest possible batch size
        int right = getMax(dataSamples); // largest possible (process one user in one batch)
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canProcess(dataSamples, maxBatches, mid)) {
                result = mid;      // valid batch size
                right = mid - 1;   // try smaller
            } else {
                left = mid + 1;    // need larger batch size
            }
        }
        return result;
    }

    private static boolean canProcess(int[] dataSamples, int maxBatches, int batchSize) {
        int total = 0;
        for (int samples : dataSamples) {
            total += Math.ceil((double) samples / batchSize);
            if (total > maxBatches)
                return false; // early exit
        }
        return true; //return total <= maxBatches;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static void main(String[] args) {
        int[] dataSamples1 = {1, 5, 7};
        int maxBatches1 = 8;
        System.out.println(minBatchSize(dataSamples1, maxBatches1)); // Output: 2

        int[] dataSamples2 = {2, 4, 5};
        int maxBatches2 = 10;
        System.out.println(minBatchSize(dataSamples2, maxBatches2)); // Output: 2
    }
}

/*
Example:
 Input: dataSamples = [1, 5, 7], maxBatches = 8
 Output: 2

 Explanation:
 If the batch size is 1, the number of batches required is 1 + 5 + 7 = 13 (exceeds the limit).
 If the batch size is 2, the number of batches required is ceil(1/2) + ceil(5/2) + ceil(7/2) = 1 + 3 + 4 = 8 (meets the limit).
 */