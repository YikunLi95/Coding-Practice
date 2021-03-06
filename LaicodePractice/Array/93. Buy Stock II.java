/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2
Examples

{2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
*/

public class Solution {
  public int maxProfit(int[] array) {
    // Write your solution here
    int maxProfit = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        maxProfit += array[i] - array[i - 1];
      }
    }
    return maxProfit;
  }
}
// TC: O(n)
// SC: O(1)
