/*
Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

Assumptions

The given array is not null and is not empty

K >= 1, K <= A.length

Examples

A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]
*/

public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    List<Integer> max = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < array.length; i++) {
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
        deque.pollLast();
      }
      if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        max.add(array[deque.peekFirst()]);
      }
    }
    return max;
  }
}
