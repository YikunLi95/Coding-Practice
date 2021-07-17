/*
Reverse the words in a sentence.

Assumptions
Words are separated by single space

There are no heading or tailing white spaces

Examples
“I love Google” → “Google love I”

Corner Cases
If the given string is null, we do not need to do anything.
*/

public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    char[] array = input.toCharArray();
    reverse(array, 0, array.length - 1);
    int start = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
        start = i;
      }
      if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
        reverse(array, start, i);
      }
    }
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
// TC:
