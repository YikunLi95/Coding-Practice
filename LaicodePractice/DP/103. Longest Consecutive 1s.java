/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

The given array is not null
Examples

{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
*/

public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if (array.length == 0) {
      return 0;
    }
    int[] M = new int[array.length];
    if (array[0] == 0) {
      M[0] = 0;
    } else {
      M[0] = 1;
    }
    int globalMax = M[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] == 1) {
        M[i] = M[i - 1] + 1;
        globalMax = Math.max(globalMax, M[i]);
      } else {
        M[i] = 0;
      }
    }
    return globalMax;
  }
}
// TC: O()
