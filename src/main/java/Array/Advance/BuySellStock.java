package Array.Advance;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BuySellStock { //one buy - one sell
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            else if (price - min > maxProfit)
                maxProfit = price - min;
        }
        return maxProfit;
    }

    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        System.out.println("Max profit: "+maxProfit(prices));
    }
}

/*
public class BuySellStock { //buy - sell - buy - sell (2 transactions)

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstProfit = 0;

        int secondBuy = Integer.MAX_VALUE;
        int secondProfit = 0;

        for (int price : prices) {
            // First transaction
            firstBuy = Math.min(firstBuy, price);
            firstProfit = Math.max(firstProfit, price - firstBuy);

            // Second transaction
            secondBuy = Math.min(secondBuy, price - firstProfit);  //see logic for this below
            secondProfit = Math.max(secondProfit, price - secondBuy);
        }

        return secondProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Max profit with 2 transactions: " + maxProfit(prices)); // Output: 6
    }
}
//firstBuy → Minimum price for first buy
//firstProfit → Maximum profit from first transaction
//secondBuy → Effective cost after gaining firstProfit
//secondProfit → Final result (max profit using both transactions)

//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation:
//Buy on day 3 (price = 0), sell on day 5 (price = 3), profit = 3
//Then buy on day 6 (price = 1), sell on day 7 (price = 4), profit = 3
//Total profit = 3 + 3 = 6


//secondBuy = Math.min(secondBuy, price - firstProfit);
//Think of this as your effective cost for buying the second stock.
//firstProfit = 3
//Today's price = 6
//so, effective second buy = 6 - 3 = 3
//You're treating the stock as if it costs only 3 because you earned 3 earlier.
//after next line, we get the maximum profit overall.
 */