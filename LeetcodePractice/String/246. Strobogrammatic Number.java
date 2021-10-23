class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        
        while (left <= right) {
            if ((num.charAt(left) == '6' && num.charAt(right) == '9') || (num.charAt(left) == '9' && num.charAt(right) == '6') || (num.charAt(left) == '8' && num.charAt(right) == '8') || (num.charAt(left) == '0' && num.charAt(right) == '0') || (num.charAt(left) == '1' && num.charAt(right) == '1')) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// TC: O(n)
// SC: O(1)
