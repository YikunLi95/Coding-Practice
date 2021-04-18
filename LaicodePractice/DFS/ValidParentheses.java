package codingProblems;

import java.util.ArrayList;

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

TC: O(2 ^ 2*N * N) SC: O(N)
*/

import java.util.List;

public class ValidParentheses {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(0, 0, sb, n, res);
		return res;
	}
	
	private void helper(int left, int right, StringBuilder sb, int n, List<String> res) {
		if (left == n && right == n) {
			res.add(sb.toString());
			return;
		}
		if (left < n) {
			helper(left + 1, right, sb.append('('), n, res);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			helper(left, right + 1, sb.append(')'), n, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
} 
