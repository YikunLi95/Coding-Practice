/*
Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions
dictionary A is not null
dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds

Examples
A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
*/

/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    // corner case
    if (dict == null) {
      return -1;
    }
    // find boundary
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = 2 * right;
    }
    return binarySearch(dict, target, left, right);
  }

  private int binarySearch(Dictionary dict, int target, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null || dict.get(mid) > target) {
        right = mid - 1;
      } else if (dict.get(mid) < target) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}

// TC: O(logT), T is the index of target value
// SC: O(1)
