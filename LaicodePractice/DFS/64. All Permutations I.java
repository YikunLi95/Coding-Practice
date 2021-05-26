/*
Given a string with no duplicate characters, return a list with all permutations of the characters.

Assume that input string is not null.

Examples
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "", all permutations are [""]
*/

public class Solution {
  public List<String> permutations(String input) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    char[] set = input.toCharArray();
    helper(res, set, 0);
    return res;
  }

  private void helper(List<String> res, char[] set, int index) {
    if (index == set.length) {
      res.add(new String(set));
      return;
    }

    for (int i = index; i < set.length; i++) {
      swap(set, index, i);
      helper(res, set, index + 1);
      swap(set, index, i);
    }
  }

  private void swap(char[] array, int x, int y) {
    char tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}
// TC: O(n! * n) SC: O(n)
