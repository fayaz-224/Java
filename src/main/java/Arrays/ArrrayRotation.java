package Arrays;
//Left Rotation/shift

class ArrrayRotation 
{
    public static void splitArr(int arr[], int n, int d)
    {
        for (int i = 0; i < d; i++) {            // Rotate array 1 by 1 upto d times.
 
            int temp = arr[0];	//left rotation
            for (int j = 0; j < n - 1; j++) //n-1 becoz, in array index starts from 0. so, we are ignoring last digt which will get replaced by arr[0]
                arr[j] = arr[j + 1];
            arr[n - 1] = temp;
        }
    }
 
    
    public static void main(String[] args)
    {
        int arr[] = { 12, 10, 5, 6, 52, 36 };
        int n = arr.length;
        System.out.println(n);
        int d = 2; //no. of positions to shift
 
        splitArr(arr, n, d);
 
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
 
//for (int i = 0; i < d; i++) {
//int temp = arr[arr.length-1];	//right or cylindrical rotation
//for (int j = arr.length-1; j > 0; j--)
//    arr[j] = arr[j - 1];
//arr[0] = temp;
//}