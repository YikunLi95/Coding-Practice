/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

​Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].
*/

public class Solution {
  public List<String> subSetsOfSizeK(String set, int k) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(arraySet, k, sb, 0, res);
    return res;
  }

  private void helper(char[] set, int k, StringBuilder sb, int index, List<String> res) {
    if (sb.length() == k) {
      res.add(sb.toString());
      return;
    }
    if (index == set.length) {
      return;
    }
    helper(set, k, sb, index + 1, res);
    helper(set, k, sb.append(set[index]), index + 1, res);
    sb.deleteCharAt(sb.length() - 1);
  }
}
