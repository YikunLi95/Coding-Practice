/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example
Given [1, 3, 3, 3, 5, 5, 7], and target value 3,
return [1, 3].
*/

public class Solution {
  public int[] range(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return new int[] {-1, -1};
    }
    int left = 0, right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        right = mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    if (array[left] == target) {
      int endIndex = 0;
      for (int i = left; i < array.length; i++) {
        if (array[i] != target) {
          endIndex = i - 1;
          break;
        } else {
          endIndex = i;
        }
      }
      return new int[] {left, endIndex};
    } else if (array[right] == target) {
      int endIndex = 0;
      for (int i = right; i < array.length; i++) {
        if (array[i] != target) {
          endIndex = i - 1;
          break;
        } else {
          endIndex = i;
        }
      }
      return new int[] {right, endIndex};
    } else {
      return new int[] {-1, -1};
    }
  }
}
// TC: O(logn + k) -> n represents the length of array, k represents the length of range
// SC: O(1)
