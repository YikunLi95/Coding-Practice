/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions
sh is not null or empty.
lo is not null.

Examples
l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
*/

public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    List<Integer> res = new ArrayList<>();
    if (lo.length() == 0) {
      return res;
    }
    if (sh.length() > lo.length()) {
      return res;
    }
    Map<Character, Integer> map = countMap(sh);
    int match = 0;
    for (int i = 0; i < lo.length(); i++) {
      char tmp = lo.charAt(i);
      Integer count = map.get(tmp);
      if (count != null) {
        map.put(tmp, count - 1);
        if (count == 1) {
          match++;
        }
      }
      if (i >= sh.length()) {
        tmp = lo.charAt(i - sh.length());
        count = map.get(tmp);
        if (count != null) {
          map.put(tmp, count + 1);
          if (count == 0) {
            match--;
          }
        }
      }
      if (match == map.size()) {
        res.add(i - sh.length() + 1);
      }
    }
    return res;
  }

  private Map<Character, Integer> countMap(String sh) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : sh.toCharArray()) {
      Integer count = map.get(ch);
      if (count == null) {
        map.put(ch, 1);
      } else {
        map.put(ch, count + 1);
      }
    }
    return map;
  }
}
