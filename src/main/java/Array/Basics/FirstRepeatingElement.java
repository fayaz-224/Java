package Array.Basics;

import java.util.HashSet;

//use streams for easy approach
public class FirstRepeatingElement {
    static void printFirstRepeatingElement(int arr[]) {
        int min = -1;
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i]))
                min = i; // If element is already in hash set, update min
            else
                set.add(arr[i]);
        }

        if (min != -1)
            System.out.println("The first repeating element is "+ arr[min]);
        else
            System.out.println("There are no repeating elements");
    }

    public static void main(String[] args) {
        int arr[] = {1,4,6,9,3,6,1,4};
        printFirstRepeatingElement(arr);  //op: 1
    }
}

//6 appears at indices 2 and 5
//1 appears at indices 0 and 6
