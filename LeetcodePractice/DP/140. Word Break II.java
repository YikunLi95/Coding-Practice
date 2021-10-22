class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = toSet(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();
            dfs(s, len, dictSet, dp, path, res);
        }
        return res;
    }
    
    private Set<String> toSet(List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String s : wordDict) {
            set.add(s);
        }
        return set;
    }
    
    private void dfs(String s, int len, Set<String> dictSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
            return;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (dictSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, dictSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
