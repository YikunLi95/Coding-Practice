class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = toSet(wordDict);
        boolean[] ans = new boolean[s.length() + 1];
        ans[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (ans[j] && dictSet.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[s.length()];
    }
    
    private Set<String> toSet(List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        for (String s : wordDict) {
            dictSet.add(s);
        }
        return dictSet;
    }
}
// TC: O(n^3)
// SC: O(n)
