/*
Given an array of integers, move all the 0s to the right end of the array.
The relative order of the elements in the original array does not need to be maintained.

Assumptions:
The given array is not null.

Examples:
{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
*/

public class Solution {
  public int[] moveZero(int[] array) {
    // Write your solution here
    // corner case
    if (array.length <= 1) {
      return array;
    }

    // shuffling
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      if (array[left] == 0) {
        swap(array, left, right--);
      } else {
        left++;
      }
    }
    return array;
  }

  private void swap(int[] array, int left, int right) {
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }
}

// TC: O(n) SC: O(1)
