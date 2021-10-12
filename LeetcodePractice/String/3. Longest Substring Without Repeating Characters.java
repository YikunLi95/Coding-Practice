class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        Set<Character> distinct = new HashSet<>();
        int slow = 0, fast = 0;
        int longest = 0;
        while (fast < s.length()) {
            if (!distinct.contains(s.charAt(fast))) {
                distinct.add(s.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            } else {
                distinct.remove(s.charAt(slow++));
            }
        }
        return longest;
    }
}
// TC: O(n)
// SC: O(n)
