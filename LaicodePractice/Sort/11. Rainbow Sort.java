/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

Examples
{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}

Assumptions
The input array is not null.

Corner Cases
What if the input array is of length zero? In this case, we should not do anything as well.
*/

public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    // corner case
    if (array.length == 0) {
      return array;
    }

    int i = 0; // [0, i) -> -1
    int j = 0; // [i, j) -> 0, [j, k] -> unknown
    int k = array.length - 1; // (k, array.length) -> 1
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i++, j++);
      } else if (array[j] == 0) {
        j++;
      } else {
        swap(array, j, k--);
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
