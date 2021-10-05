public int minimizeCuttingInteger(int num) {
        String strNum = Integer.toString(num);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strNum.length() - 1; i++) {
            String preStr = strNum.substring(0, i + 1);
            String suffixStr = strNum.substring(i + 1);
            int preInt = Integer.parseInt(preStr);
            int suffixInt = Integer.parseInt(suffixStr);
            min = Math.min(min, Math.abs(preInt - suffixInt));
        }
        return min;
}
// TC: O(n^2)
// SC: O(1)
