/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.

Assumptions
There can be duplicate elements in the array.

Examples
A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 3

Corner Cases
What if A is null or A is array of zero length? We should return -1 in this case.
*/

public class Solution {
  public int lastOccur(int[] array, int target) {
    // Write your solution here
    // corner case
    if (array == null || array.length == 0) {
      return -1;
    }
    // binary search
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        left = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    // post processing
    if (array[right] == target) {
      return right;
    } else if (array[left] == target) {
      return left;
    } else {
      return -1;
    }
  }
}

// TC: O(logn) SC: O(1)
