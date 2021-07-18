/*
Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.

Assumptions

The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0
Examples

dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
*/

public class Solution {
  public int largestProduct(String[] dict) {
    // Write your solution here
    HashMap<String, Integer> bitMasks = getBitMasks(dict);
    Arrays.sort(dict, new Comparator<String>() {
      @Override
      public int compare(String s0, String s1) {
        if (s0.length() == s1.length()) {
          return 0;
        }
        return s0.length() < s1.length() ? 1 : -1;
      }
    });
    int largest = 0;
    for (int i = 1; i < dict.length; i++) {
      for (int j = 0; j < i; j++) {
        int prod = dict[i].length() * dict[j].length();
        if (prod <= largest) {
          break;
        }
        int iMask = bitMasks.get(dict[i]);
        int jMask = bitMasks.get(dict[j]);
        if ((iMask & jMask) == 0) {
          largest = prod;
        }
      }
    }
    return largest;
  }

  private HashMap<String, Integer> getBitMasks(String[] dict) {
    HashMap<String, Integer> map = new HashMap<>();
    for (String str : dict) {
      int bitMask = 0;
      for (int i = 0; i < str.length(); i++) {
        bitMask |= 1 << (str.charAt(i) - 'a');
      }
      map.put(str, bitMask);
    }
    return map;
  }
}
