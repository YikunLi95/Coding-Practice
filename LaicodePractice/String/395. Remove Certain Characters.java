/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions
The given input string is not null.
The characters to be removed is given by another string, it is guaranteed to be not null.

Examples
input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
*/

public class Solution {
  public String remove(String input, String t) {
    // Write your solution here
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (!set.contains(array[fast])) {
        array[slow] = array[fast];
        slow++;
      }
    }
    return new String(array, 0, slow);
  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
