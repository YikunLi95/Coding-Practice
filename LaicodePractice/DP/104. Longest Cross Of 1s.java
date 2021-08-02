/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
*/

public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    int N = matrix.length;
    if (N == 0) {
      return 0;
    }
    int M = matrix[0].length;
    if (M == 0) {
      return 0;
    }
    int[][] leftUp = leftUp(matrix, N, M);
    int[][] rightDown = rightDown(matrix, N, M);
    return merge(leftUp, rightDown, N, M);
  }

  private int[][] leftUp(int[][] matrix, int N, int M) {
    int[][] left = new int[N][M];
    int[][] up = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0 && j == 0) {
            left[i][j] = 1;
            up[i][j] = 1;
          } else if (i == 0) {
            up[i][j] = 1;
            left[i][j] = left[i][j - 1] + 1;
          } else if (j == 0) {
            left[i][j] = 1;
            up[i][j] = up[i - 1][j] + 1;
          } else {
            left[i][j] = left[i][j - 1] + 1;
            up[i][j] = up[i - 1][j] + 1;
          }
        }
      }
    }
    merge(left, up, N, M);
    return left;
  }

  private int[][] rightDown(int[][] matrix, int N, int M) {
    int[][] right = new int[N][M];
    int[][] down = new int[N][M];
    for (int i = N - 1; i >= 0; i--) {
      for (int j = M - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (i == N - 1 && j == M - 1) {
            right[i][j] = 1;
            down[i][j] = 1;
          } else if (i == N - 1) {
            down[i][j] = 1;
            right[i][j] = right[i][j + 1] + 1;
          } else if (j == M - 1) {
            right[i][j] = 1;
            down[i][j] = down[i + 1][j] + 1;
          } else {
            right[i][j] = right[i][j + 1] + 1;
            down[i][j] = down[i + 1][j] + 1;
          }
        }
      }
    }
    merge(right, down, N, M);
    return right;
  }

  private int merge(int[][] a, int[][] b, int N, int M) {
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        a[i][j] = Math.min(a[i][j], b[i][j]);
        res = Math.max(res, a[i][j]);
      }
    }
    return res;
  } 
}
// TC: O()
// SC: O()
