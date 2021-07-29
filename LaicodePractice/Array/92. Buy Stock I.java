/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock and you can make at most 1 transaction. Determine the maximum profit you can make.

Assumptions

The given array is not null and is length of at least 2.
Examples

{2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
*/

public class Solution {
  public int maxProfit(int[] array) {
    // Write your solution here
    int maxProfit = 0;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int profit = array[j] - array[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }
    return maxProfit;
  }
}
// TC: O(n^2)
// SC: O(1)

  public int maxProfit(int[] array) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < minPrice) {
        minPrice = array[i];
      } else if (array[i] - minPrice > maxProfit) {
        maxProfit = array[i] - minPrice;
      }
    }
    return maxProfit;
  }
// TC: O(n)
// SC: O(1)
