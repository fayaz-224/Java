package Array.Basics;

//Approach-1: we can follow DuplicateElements code as well by using Map.

//Approach-2
public class Frequency {
    //find the frequency of each element in the array
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};
        int [] fr = new int [arr.length];   //to store frequencies of elements
        
        for(int i = 0; i < arr.length; i++){  //no need for arr.length-1 as we need to check all elements
            int count = 1;  
            for(int j = i+1; j < arr.length; j++){  
                if(arr[i] == arr[j]){  
                    count++;  
                    fr[j] = -1;  //To avoid counting/visiting same element again
                }  
            }  
            if(fr[i] != -1)  //to ignore visited ones
                fr[i] = count;
        }

        System.out.println(" Element | Frequency");
        System.out.println("---------------------");
        for(int i = 0; i < fr.length; i++){  
            if(fr[i] != -1)  
                System.out.println("    " + arr[i] + "    |    " + fr[i]);  
        }

        /*
        // logic same as above, add this after inner for-loop, inside main for-loop
        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

         if (count > maxFreq) {     //to Find the highest/lowest frequency element
            maxEle = arr[i];
            maxFreq = count;
        }
        if (count < minFreq) {
            minEle = arr[i];
            minFreq = count;
        }
         */
    }
}