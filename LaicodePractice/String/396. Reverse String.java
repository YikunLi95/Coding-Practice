/*
Reverse a given string.

Assumptions
The given string is not null.
*/

public class Solution {
  public String reverse(String input) {
    // Write your solution here
    if (input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    for (int left = 0, right = array.length - 1; left < right; left++, right--) {
      swap(array, left, right);
    }
    return new String(array);
  }

  private void swap(char[] array, int a, int b) {
    char tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
// TC:
