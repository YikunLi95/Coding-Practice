/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

Assumptions:

The original string only contains alphabetic characters.
Both input and pattern are not null.
Pattern would not contain invalid information like "a0a","0".

Examples:
pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
*/

public class Solution {
  public boolean match(String input, String pattern) {
    // Write your solution here
    return match(input, pattern, 0, 0);
  }

  private boolean match(String input, String pattern, int inputIndex, int patternIndex) {
    if (inputIndex == input.length() && patternIndex == pattern.length()) {
      return true;
    }
    if (inputIndex >= input.length() || patternIndex >= pattern.length()) {
      return false;
    }
    if (pattern.charAt(patternIndex) < '0' || pattern.charAt(patternIndex) > '9') {
      if (pattern.charAt(patternIndex) == input.charAt(inputIndex)) {
        return match(input, pattern, inputIndex + 1, patternIndex + 1);
      }
      return false;
    }
    int count = 0;
    while (patternIndex < pattern.length() && pattern.charAt(patternIndex) >= '0' && pattern.charAt(patternIndex) <= '9') {
      count = count * 10 + (pattern.charAt(patternIndex) - '0');
      patternIndex++;
    }
    return match(input, pattern, inputIndex + count, patternIndex);
  }
}
