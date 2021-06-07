/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples
"abbbaaccz" → "aaaccz" → "ccz" → "z"
"aabccdc" → "bccdc" → "bdc"
*/

public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int end = 0;
    for (int i = 1; i < array.length; i++) {
      if (end == -1 || array[i] != array[end]) {
        array[++end] = array[i];
      } else {
        end--;
        while (i + 1 < array.length && array[i] == array[i + 1]) {
          i++;
        }
      }
    }
    return new String(array, 0, end + 1);
  }
}
