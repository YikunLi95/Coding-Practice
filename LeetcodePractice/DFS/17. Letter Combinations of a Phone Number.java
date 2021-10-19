class Solution {
    
    Map<Character, char[]> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        initMap();
        dfs(digits, result, 0, new StringBuilder());
        return result;
    }
    
    private void dfs(String digits, List<String> result, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        for (char c : map.get(digit)) {
            sb.append(c);
            dfs(digits, result, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    private void initMap() {
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
}
// TC: O(4^n)
// SC: O(n)
