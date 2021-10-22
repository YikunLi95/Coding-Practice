class Solution {
    public String minWindow(String s, String t) {
        // corner case
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }
        
        // store the chars of t
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        // initialize two pointers to iterate s
        int left = 0, right = 0;
        int charTLen = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        
        // process of expand the right bound of sliding window
        while (right < s.length()) {
            char currLetter = s.charAt(right);
            if (map.containsKey(currLetter)) {
                int count = map.get(currLetter);
                if (count > 0) {
                    charTLen--;
                }
                map.put(currLetter, count - 1);
            }
            right++;
        
            // process of shrink the left bound of sliding window
            while (charTLen == 0) {
                if (minLen > right - left) {
                    minLen = right - left;
                    minStart = left;
                }
                char abandon = s.charAt(left);
                if (map.containsKey(abandon)) {
                    int count = map.get(abandon);
                    if (count == 0) {
                        charTLen++;
                    }
                    map.put(abandon, count + 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
// TC: O(S + T) S -> length of s; T -> length of t
// SC: O(T)
