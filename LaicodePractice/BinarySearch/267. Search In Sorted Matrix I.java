/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:
The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

Examples:
matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
target = 7, return {1, 2}
target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
*/

public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here
    // corner case
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new int[] {-1, -1};
    }
    // binary search
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row * col - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int r = mid / col;
      int c = mid % col;
      if (matrix[r][c] == target) {
        return new int[] {r, c};
      } else if (matrix[r][c] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return new int[] {-1, -1};
  }
}

// TC: O(log(row * col))
// SC: O(1)
