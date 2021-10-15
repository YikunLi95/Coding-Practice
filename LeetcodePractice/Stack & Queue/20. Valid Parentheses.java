class Solution {
    
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        initMap(map);
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (map.containsKey(letter)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(letter) != stack.pollLast()) {
                    return false;
                }
            } else {
                stack.offerLast(letter);
            }
        }
        return stack.isEmpty();
    }
    
    private void initMap(Map<Character, Character> map) {
        
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
}
// TC: O(n)
// SC: O(n)
