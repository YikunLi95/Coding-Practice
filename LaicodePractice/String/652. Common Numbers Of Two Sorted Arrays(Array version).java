/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Assumptions
In each of the two sorted arrays, there could be duplicate numbers.
Both two arrays are not null.

Examples
A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
*/

public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    // Write your solution here
    List<Integer> res = new ArrayList<Integer>();
    if (A.length == 0 || B.length == 0) {
      return res;
    }
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
      if (A[i] == B[j]) {
        res.add(A[i]);
        i++;
        j++;
      } else if (A[i] < B[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res;
  }
}
