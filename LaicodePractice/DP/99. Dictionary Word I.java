/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions

The given word is not null and is not empty
The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples

Dictionary: {“bob”, “cat”, “rob”}

Word: “robob” return false

Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    Set<String> set = toSet(dict);
    // M[i] represents the substring of input [0, i), whether is valid
    // M[0] represents "", M[1] represents input[0], M[2] represents input[0, 1]
    boolean[] M = new boolean[input.length() + 1];

    M[0] = true;
    for (int i = 1; i <= input.length(); i++) { // i represents # of letters
      for (int j = 0; j < i; j++) { // j represents the cutting position
        if (M[j] && set.contains(input.substring(j, i))) { // substring(i, j) represents the [i, j - 1] indices
          M[i] = true;
          break;
        }
      }
    }
    return M[input.length()];
  }

  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
// TC: O(n ^ 3) SC: O(n) -> n represents the length of input string
