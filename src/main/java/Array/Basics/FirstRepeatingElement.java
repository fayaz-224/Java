package Array.Basics;

import java.util.HashSet;

public class FirstRepeatingElement {
    static void printFirstRepeatingElement(int arr[]) {  //int array
        int min = -1;
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;
            else
                set.add(arr[i]);
        }

        if (min != -1)
            System.out.println("The first repeating element is "+ arr[min]);
        else
            System.out.println("There are no repeating elements");
    }

    public static void main(String[] args) {
        int arr[] = {1,4,6,9,3,6,1};
        printFirstRepeatingElement(arr);
    }
}