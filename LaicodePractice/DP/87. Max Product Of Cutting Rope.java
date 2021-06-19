/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

Assumptions
n >= 2

Examples
n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/

public class Solution {
  public int maxProduct(int length) {
    // Write your solution here
    int[] max = new int[length + 1]; // max[i] represents the max product of i-length rope
    max[0] = 0;
    max[1] = 1;
    for (int i = 2; i <= length; i++) { // i represents the length of the rope
      for (int j = 1; j < i; j++) { // j represents the cut positions
        max[i] = Math.max(max[i], Math.max(max[j], j) * (i - j));
      }
    }
    return max[length];
  }
}
// TC: O(n^2) SC: O(n) -> n represents the length of the rope
