// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Note : you can buy and sell the stock once

// ex.
// arr = 7 1 5 3 6 4
// output = 5            (buy for 1 and sell for 6)


// Time - O(N)
// Space - O(1)

public class Best_Time_to_Buy_and_Sell_Stock {

    static int maxProfit(int[] arr) {
        int maxProfit = Integer.MIN_VALUE;
        int curProfit;
        int minProfit = arr[0];

        for (int ele : arr) {
            minProfit = Math.min(minProfit, ele);
            curProfit = ele - minProfit;

            maxProfit = Math.max(maxProfit, curProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(arr));
    }
}
