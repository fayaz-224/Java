package DSA.Greedy;

import java.util.*;

//We are given two arrays that represent the arrival and departure times of trains that stop at the platform.
// We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
class MinPlatforms {  // Greedy Algorithm

    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, maxPlatforms = 1; //Both are "1" as we need at least one platform at station
        int i = 1, j = 0;  //i=1 becoz, we already assumed 1st train reached platform 1

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) { //arrival train is coming before departure train, so platform increases
                plat_needed++;
                i++;  //imaginary index for arrival trains
            } else if (arr[i] > dep[j]) {  //departure train moved before arrival train, so platform decreases
                plat_needed--;
                j++;  //imaginary index for departure trains
            }

            //find max platforms needed
            maxPlatforms = Math.max(maxPlatforms, plat_needed);
        }
        return maxPlatforms;
    }

    public static void main (String[] args) {
        int[] arr = {900,945,955,1100,1500,1800};
        int[] dep = {920,1200,1130,1150,1900,2000};
        int n = arr.length;

        int totalCount=findPlatform(arr,dep,n);
        System.out.println("Minimum number of Platforms required "+ totalCount);
    }
}
