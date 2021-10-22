class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        
        int curr = 0;
        while (curr < t.length()) {
            char curLetter = t.charAt(curr);
            if (map.containsKey(curLetter) && map.get(curLetter) > 0) {
                map.put(curLetter, map.get(curLetter) - 1);
                curr++;
            } else {
                return false;
            }
        }
        return true;
    }
}
// TC: O(n)
// SC: O(n)
