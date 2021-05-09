/*
Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
*/
public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    // corner case
    if (array == null || array.length == 0) {
      return array;
    }
    // selection sort
    for (int i = 0; i < array.length - 1; i++) {
      int globalMin = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] <= array[globalMin]) {
          globalMin = j;
        }
      }
      swap(array, i, globalMin);
    }
    return array;
  }

  private void swap(int[] array, int x, int y) {
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}

// TC: O(n ^ 2) SC: O(1)
