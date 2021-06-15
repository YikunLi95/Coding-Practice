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
    Set<String> dictSet = toSet(dict);
    boolean[] canBreak = new boolean[input.length() + 1];
    canBreak[0] = true;
    for (int i = 1; i <= input.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (canBreak[j] && dictSet.contains(input.substring(j, i))) {
          canBreak[i] = true;
          break;
        }
      }
    }
    return canBreak[input.length()];
  }

  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  } // TC: O(n ^ 3) SC: O(n)
}
