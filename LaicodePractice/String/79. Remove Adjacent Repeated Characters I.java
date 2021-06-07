/*
Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

Assumptions
Try to do it in place.

Examples
“aaaabbbc” is transferred to “abc”

Corner Cases
If the given string is null, returning null or an empty string are both valid.
*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if (input == null) {
      return null;
    }
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (fast == 0 || array[fast] != array[slow - 1]) {
        array[slow] = array[fast];
        slow++;
      }
    }
    return new String(array, 0, slow);
  }
}
