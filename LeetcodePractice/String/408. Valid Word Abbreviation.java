class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wLen = word.length();
        int aLen = abbr.length();
        // corner case
        if (wLen < aLen) {
            return false;
        }
        
        // use two pointers to check whether matched
        int i = 0, j = 0;
        while (i < wLen && j < aLen) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (abbr.charAt(j) == '0' || !Character.isDigit(abbr.charAt(j))) {
                return false;
            }
            int num = 0;
            while (j < aLen && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + (abbr.charAt(j) - '0');
                j++;
            }
            i += num;
        }
        return i == wLen && j == aLen;
    }
}
// TC: O(aLen)
// SC: O(1)
