class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int remain = 0;
        
        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            remain += n1 + n2;
            res.append(remain % 10);
            remain = remain / 10;
            p1--;
            p2--;
        }
        if (remain != 0) {
            res.append(remain);
        }
        return res.reverse().toString();
    }
}
// TC: O(max(m,n))
// SC: O(1)
