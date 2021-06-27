/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
*/

public class Solution {
  private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    int[] remain = new int[] {l, l, m, m, n, n};
    int targetLen = 2 * l + 2 * m + 2 * n;
    StringBuilder cur = new StringBuilder();
    Deque<Character> stack = new LinkedList<>();
    List<String> res = new ArrayList<>();
    helper(remain, targetLen, cur, stack, res);
    return res;
  }

  private void helper(int[] remain, int targetLen, StringBuilder cur, Deque<Character> stack, List<String> res) {
    if (cur.length() == targetLen) {
      res.add(cur.toString());
      return;
    }
    for (int i = 0; i < remain.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          cur.append(PS[i]);
          stack.offerFirst(PS[i]);
          remain[i]--;
          helper(remain, targetLen, cur, stack, res);
          cur.deleteCharAt(cur.length() - 1);
          stack.pollFirst();
          remain[i]++;
        }
      } else {
        if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
          cur.append(PS[i]);
          stack.pollFirst();
          remain[i]--;
          helper(remain, targetLen, cur, stack, res);
          cur.deleteCharAt(cur.length() - 1);
          stack.offerFirst(PS[i - 1]);
          remain[i]++;
        }
      }
    }
  }
}
