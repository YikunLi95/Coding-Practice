class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return 0;
                }
                return s1.length() < s2.length() ? -1 : 1;
            }
        });
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            String a = words[i];
            for (int j = i + 1; j < n; j++) {
                String b = words[j];
                if (isPredecessor(a, b)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(res, dp[j]);
                }
            }
        }
        return res + 1;
    }
    
    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        if (m + 1 != n) {
            return false;
        }
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
// TC: O(n^2*L)
// SC: O(n)
