package Special;

import java.util.Scanner;

//calculates the number of notes of each denomination (500, 200, and 100) required to dispense that amount from an ATM
public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount % 50 != 0) {  // Check if amount is a multiple of 50 or 100 as per req.
            System.out.println("Invalid amount. Please enter a multiple of 100.");
            return;
        }

        int[] denominations = {500, 200, 100, 50};
        int[] notesCount = new int[denominations.length]; // Array to store count of each denomination

        for (int i = 0; i < denominations.length; i++) {
            notesCount[i] = amount / denominations[i];
            amount %= denominations[i];
        }

        // Displaying the count of each denomination - we can display in abode for loop only if needed
        for (int i = 0; i < denominations.length; i++) {
            System.out.println("Number of " + denominations[i] + " notes: " + notesCount[i]);
        }
    }
}

