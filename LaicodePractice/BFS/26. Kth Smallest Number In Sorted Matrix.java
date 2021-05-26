/*
Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions
the matrix is not null, N > 0 and M > 0
K > 0 and K <= N * M

Examples
{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }

the 5th smallest number is 4
the 8th smallest number is 6
*/

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    int rows = matrix.length;
    int columns = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new MyComparator());
    boolean[][] visited = new boolean[rows][columns];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
        minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < columns && !visited[cur.row][cur.col + 1]) {
        minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
 
}

class Cell {
  int row;
  int col;
  int value;

  public Cell(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }
}

class MyComparator implements Comparator<Cell> {
  @Override
  public int compare(Cell c1, Cell c2) {
    if (c1.value == c2.value) {
      return 0;
    }
    return c1.value < c2.value ? -1 : 1;
  }
}
// TC: O(klogk) SC: O(mn + k) m,n represents rows and cols of the boolean matrix
