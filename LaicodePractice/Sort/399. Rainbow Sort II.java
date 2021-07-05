/*
Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, sort the balls such that all balls with same color are grouped together and from left to right the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3).

Examples

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}
Assumptions

The input array is not null.
*/

public class Solution {
  public int[] rainbowSortII(int[] array) {
    // Write your solution here
    if (array.length == 0) {
      return new int[0];
    }
    int i = 0, j = 0, k = array.length - 1, l = array.length - 1;
    while (j <= k) {
      if (array[j] == 0) {
        swap(array, i++, j++);
      } else if (array[j] == 1) {
        j++;
      } else if (array[j] == 2) {
        swap(array, j, k--);
      } else {
        swap(array, j, l--);
        if (k > l) {
          k--;
        }
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
