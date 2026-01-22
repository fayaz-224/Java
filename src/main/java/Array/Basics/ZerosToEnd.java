package Array.Basics;
 
class ZerosToEnd {

    static void pushZerosToEnd(int arr[], int n) {
        int idx = 0;
 
        // if element encountered is non-zero, then replace the element at index 'idx' with this element
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                arr[idx++] = arr[i];
        }

        // Make remaining elements 0 from idx to end.
        while (idx < n)
            arr[idx++] = 0;
    }

    public static void moveZeros(int[] arr) {  //2 pointer approach
        int i = 0; // slow pointer

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                // Swap only if i and j are different
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++; // move to next position
            }
        }
    }
    
    public static void main (String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        moveZeros(arr);
        System.out.println("Array after pushing zeros to the back: ");
        for (int j : arr)
            System.out.print(j + " ");
    }
}