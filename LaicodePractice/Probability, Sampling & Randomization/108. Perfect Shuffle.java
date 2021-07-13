/*
Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.

Assumptions

The given array is not null
*/

public class Solution {
  public void shuffle(int[] array) {
    // Write your solution here.
    if (array.length <= 1) {
      return;
    }
    for (int i = array.length; i >= 1; i--) {
      int idx = (int) (Math.random() * i);
      swap(array, i - 1, idx);
    }
  }

  private void swap(int[] array, int x, int y) {
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}
// TC
