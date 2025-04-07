class Solution {
    private Integer[][] memo = new Integer[1001][1001];

    private int recursion(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) return 0;

        if(memo[i][j] != null) return memo[i][j];

        int match = 0, nonMatch = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            match = 1 + recursion(text1, text2, i + 1, j + 1);
        } else {
            nonMatch = Math.max(recursion(text1, text2, i + 1, j), recursion(text1, text2, i, j + 1));
        }
        return memo[i][j] = Math.max(match, nonMatch);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return recursion(text1, text2, 0, 0);
    }
}