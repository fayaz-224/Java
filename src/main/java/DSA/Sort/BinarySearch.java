package DSA.Sort;

//Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
class BinarySearch {

   static int binarySearch(int[] arr, int target) {
      int start = 0;
      int end = arr.length - 1;

      while(start <= end) {
          //  int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
          int mid = start + (end - start) / 2;

          if (arr[mid] == target)
              return mid;
          else if (target < arr[mid])  // for ascending order of input array
              end = mid - 1;
          else
              start = mid + 1;

//          else if (target < arr[mid]) // for descending order of input array
//              start = mid + 1;
//          else
//              end = mid - 1;

      }
      return -1;    //for normal binary search

      //return start;      // to find ceiling number - The smallest no. greater than or equals to given key
      //return end;      // to find floor number - The biggest no. less than or equals to given key
   }

    public static void main(String args[]) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89}; //the elements should be in sorted order
        int target = 22;
        int pos = binarySearch(arr, target);
        System.out.println("found at : "+pos);
    }
}
