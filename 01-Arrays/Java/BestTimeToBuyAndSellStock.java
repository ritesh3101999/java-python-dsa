/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. 

======================================================================================================
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
======================================================================================================

======================================================================================================
COMPLEXITY ANALYSIS
======================================================================================================
Time Complexity: O(n)
- We iterate through the prices array exactyly once.

Space Complexity: O(1)
- Only a couple of primitive variables are used to track state, requiring no extra data structure.
======================================================================================================
*/

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price:prices){
            if(price < minPrice){
                minPrice = price; // Track the lowest price seen so far
            }else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice; // Check if selling today beats our record
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices)); // Output: 5
    }
}
