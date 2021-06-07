/*
Right shift a given string by n characters.

Assumptions
The given string is not null.
n >= 0.

Examples
"abc", 4 -> "cab"
*/

public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    if (input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    n %= array.length;
    reverse(array, array.length - n, array.length - 1);
    reverse(array, 0, array.length - n - 1);
    reverse(array, 0, array.length - 1);
    return new String(array);
  }

  private void reverse(char[] array, int left, int right) {
    while (left < right) {
      char tmp = array[left];
      array[left] = array[right];
      array[right] = tmp;
      left++;
      right--;
    }
  }
}
