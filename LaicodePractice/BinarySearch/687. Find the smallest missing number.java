/*
Description: Given a sorted array of n distinct integers, there are numerous missing elements in the complete array [0, 1, 2, 3, ..., m - 1] (m >= n). For example, [0, 1, 3, 5] is a case when m = 6 and n = 4, and 2, 4 are missing in the array.



Write a binary search solution to find the smallest number that is missing in the array, i.e. 2 in the above example. Return 0 if the array is null or empty.



Examples:

Input: array = [0, 1, 2, 6, 9] (n = 5, m = 10)

Output: 3



Input: array = [4, 5, 10, 11] (n = 4, m = 12)


Output: 0
*/

public class Solution {
  public int findFirstMissingElement(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int left = 0, right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] != mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    int result = 0;
    if (array[left] != left) {
      result = array[left] - (array[left] - left);
    } else if (array[right] != right) {
      result = array[right] - (array[right] - right);
    } else {
      result = array.length;
    }
    return result;
  }
}
// TC: O(logn)
// SC: O(1)
