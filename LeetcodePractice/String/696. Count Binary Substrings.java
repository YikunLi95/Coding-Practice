class Solution {
    public int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        int t = 0;
        group[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                group[++t] = 1;
            } else {
                group[t]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(group[i], group[i - 1]);
        }
        return ans;
    }
}
// TC: O(n) -> n: s.length()
// SC: O(n)
