/*
Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

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
  public int[] mergeSort(int[] array) {
    // Write your solution here
    // corner case
    if (array == null || array.length <= 1) {
      return array;
    }
    return mergeSort(array, 0, array.length - 1);
  }

  private int[] mergeSort(int[] array, int left, int right) {
    // base case
    if (left == right) {
      return new int[] {array[left]};
    }
    // recursion rule
    int mid = left + (right - left) / 2;
    int[] leftRes = mergeSort(array, left, mid);
    int[] rightRes = mergeSort(array, mid + 1, right);
    return merge(leftRes, rightRes);
  }

  private int[] merge(int[] leftRes, int[] rightRes) {
    int[] res = new int[leftRes.length + rightRes.length];

    // initial the 3 pointers
    int leftIndex = 0;
    int rightIndex = 0;
    int resIndex = 0;

    // move smaller element
    while (leftIndex < leftRes.length && rightIndex < rightRes.length) {
      if (leftRes[leftIndex] <= rightRes[rightIndex]) {
        res[resIndex] = leftRes[leftIndex];
        leftIndex++;
      } else {
        res[resIndex] = rightRes[rightIndex];
        rightIndex++;
      }
      resIndex++;
    }
    // post processing
    while (leftIndex < leftRes.length) { // leftRes still has elements left
      res[resIndex] = leftRes[leftIndex];
      leftIndex++;
      resIndex++;
    }
    while (rightIndex < rightRes.length) { // rightRes still has elements left
      res[resIndex] = rightRes[rightIndex];
      rightIndex++;
      resIndex++;
    }
    return res;
  }
}

// TC: O(nlogn) SC: O(n)
