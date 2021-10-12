/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
*/

public class Solution {
  public int longest(String input) {
    // Write your solution here
    Set<Character> distinct = new HashSet<>();
    int slow = 0;
    int fast = 0;
    int longest = 0;
    while (fast < input.length()) {
      if (distinct.contains(input.charAt(fast))) {
        distinct.remove(input.charAt(slow++));
      } else {
        distinct.add(input.charAt(fast++));
        longest = Math.max(longest, fast - slow);
      }
    }
    return longest;
  }
}
// TC: O(n)
// SC: O(n)
