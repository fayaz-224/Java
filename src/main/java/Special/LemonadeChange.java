package Special;

//Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
// - Greedy Algorithm
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        // Initialize variables to keep track of available change
        int fives = 0;
        int tens = 0;

        // Iterate through each customer
        for (int bill : bills) {
            if (bill == 5) { // If the customer pays with $5, no change needed
                fives++;
            } else if (bill == 10) { // If the customer pays with $10, need to return $5 as change
                if (fives == 0)
                    return false; // Unable to provide change
                fives--;
                tens++;
            } else if (bill == 20) { // If the customer pays with $20
                if (tens > 0 && fives > 0) { // Prefer to give $10 + $5 as change
                    tens--;
                    fives--;
                } else if (fives >= 3) {  // If $10 bill is not available, give three $5 bills as change
                    fives -= 3;
                } else
                    return false; // Unable to provide change
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20}; // Should return true
        int[] bills2 = {5, 5, 10}; // Should return true
        int[] bills3 = {10, 10}; // Should return false
        System.out.println("Can provide correct change for bills1: " + lemonadeChange(bills1));
        System.out.println("Can provide correct change for bills2: " + lemonadeChange(bills2));
        System.out.println("Can provide correct change for bills3: " + lemonadeChange(bills3));
    }
}


/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills).
 Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Example 1:
Input: bills = [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

Example 2:
Input: bills = [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.
 */