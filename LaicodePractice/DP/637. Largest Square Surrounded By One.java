/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.



Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0



Examples

{{1, 0, 1, 1, 1},

 {1, 1, 1, 1, 1},

 {1, 1, 0, 1, 0},

 {1, 1, 1, 1, 1},

 {1, 1, 1, 0, 0}}



The largest square surrounded by 1s has length of 3.
*/

public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    // Write your solution here
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int res = 0;
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] left = new int[M + 1][N + 1];
    int[][] up = new int[M + 1][N + 1];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          left[i + 1][j + 1] = left[i + 1][j] + 1;
          up[i + 1][j + 1] = up[i][j + 1] + 1;
        }
        for (int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--) {
          if (left[i + 2 - maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength) {
            res = Math.max(res, maxLength);
            break;
          }
        }
      }
    }
    return res;
  }
}
// TC: O() SC: O()
