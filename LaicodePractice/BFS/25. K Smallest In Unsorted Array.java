/*
Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.

Assumptions
A is not null
K is >= 0 and smaller than or equal to size of A

Return
an array with size K containing the K smallest numbers in ascending order

Examples
A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
*/
public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    // corner case
    if (array.length == 0 || k == 0) {
      return new int[0];
    }

    int[] res = new int[k];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      maxHeap.offer(array[i]);
    }
    for (int i = k; i < array.length; i++) {
      if (array[i] <= maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = maxHeap.poll();
    }
    return res;
  }
}
// TC: O(k + (n - k)logk) SC: O(k)
