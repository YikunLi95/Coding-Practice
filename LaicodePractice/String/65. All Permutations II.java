/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/

public class Solution {
  public List<String> permutations(String input) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    if (input == null) {
      return res;
    }
    char[] array = input.toCharArray();
    helper(array, 0, res);
    return res;
  }

  private void helper(char[] array, int index, List<String> res) {
    if (index == array.length) {
      res.add(new String(array));
      return;
    }
    Set<Character> used = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (used.add(array[i])) {
        swap(array, index, i);
        helper(array, index + 1, res);
        swap(array, index, i);
      }
    }
  }

  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
// TC
