/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        DFS(n, res, sb, left, right);
        return res;
    }
    
    private void DFS(int n, List<String> res, StringBuilder sb, int left, int right) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            DFS(n, res, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            DFS(n, res, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// TC: O(2 ^ 2n * 2n) 
// SC: O(2n)
