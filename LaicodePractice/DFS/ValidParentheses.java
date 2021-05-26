/*
Given N pairs of parentheses ¡°()¡±, return a list with all the valid permutations.

Assumptions: N > 0

Examples:

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

Recursion tree:                              {}
                                             /\
0                                           (  )
                                           /\  /\
1                                        (( ()  ( )
                                         /\
2                                     (((  (()
                                       |
3                                     ((()
                                       |
4                                    ((())
                                       |
5                                   ((()))
*/

public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int left = 0;
    int right = 0;
    helper(res, sb, left, right, n);
    return res;
  }

  private void helper(List<String> res, StringBuilder sb, int left, int right, int n) {
    if (left == n && right == n) {
      res.add(sb.toString());
      return;
    }

    if (left < n) {
      helper(res, sb.append('('), left + 1, right, n);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (right < left) {
      helper(res, sb.append(')'), left, right + 1, n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
// TC: O(2 ^ 2n * 2n) SC: O(2n)
