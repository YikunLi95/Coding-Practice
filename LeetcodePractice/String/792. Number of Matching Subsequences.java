class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // corner case
        if (s.length() < words[0].length()) {
            return 0;
        }
        
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new ArrayDeque<>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).offerLast(word);
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<String> deque = map.get(c);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String word = deque.pollFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).offerLast(word.substring(1));
                }
            }
        }
        return count;
    }
}
// TC: O(s.length * words.length)
// SC: O(words.length)
