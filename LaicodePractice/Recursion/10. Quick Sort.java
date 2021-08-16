/*
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

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
  public int[] quickSort(int[] array) {
    // Write your solution here
    // corner case
    if (array == null || array.length == 0) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private void quickSort(int[] array, int left, int right) {
    // base case
    if (left >= right) {
      return;
    }
    // define a pivot
    int pivotPos = partition(array, left, right);
    // recursion rule
    quickSort(array, left, pivotPos - 1);
    quickSort(array, pivotPos + 1, right);
  }

  private int partition(int[] array, int left, int right) {
    int pivotIndex = pivotIndex(left, right);
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, right);
    int leftBound = left;
    int rightBound = right - 1;
    while (leftBound <= rightBound) {
      if (array[leftBound] < pivot) {
        leftBound++;
      } else {
        swap(array, leftBound, rightBound--);
      }
    }
    swap(array, leftBound, right);
    return leftBound;
  }

  private int pivotIndex(int left, int right) {
    return left + (int) (Math.random() * (right - left + 1));
  }

  private void swap(int[] array, int x, int y) {
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}

// worst: TC: O(n ^ 2) SC: O(n)
// average: TC: O(nlogn) SC: O(logn)
