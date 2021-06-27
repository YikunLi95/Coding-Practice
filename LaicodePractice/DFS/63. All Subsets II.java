/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    if (set == null) {
      return res;
    }
    char[] arraySet = set.toCharArray();
    Arrays.sort(arraySet);
    StringBuilder sb = new StringBuilder();
    helper(arraySet, sb, 0, res);
    return res;
  }

  private void helper(char[] set, StringBuilder sb, int index, List<String> res) {
    if (index == set.length) {
      res.add(sb.toString());
      return;
    }
    helper(set, sb.append(set[index]), index + 1, res);
    sb.deleteCharAt(sb.length() - 1);
    while (index < set.length - 1 && set[index] == set[index + 1]) {
      index++;
    }
    helper(set, sb, index + 1, res);
  }
}
