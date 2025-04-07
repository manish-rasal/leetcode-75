class Solution {

    private Integer[][] memo = new Integer[501][501];

    private int recursion(String word1, String word2, int i, int j) {
        if(i == word1.length() && j == word2.length()) {
            return 0;
        } else if(i == word1.length()) {
            return word2.length() - j;
        } else if(j == word2.length()) {
            return word1.length() - i;
        } else {
            if(memo[i][j] != null) return memo[i][j];

            if(word1.charAt(i) == word2.charAt(j)) {
                return memo[i][j] = recursion(word1, word2, i + 1, j + 1);
            } else {
                return memo[i][j] = 1 + Math.min(recursion(word1, word2, i + 1, j + 1),Math.min(recursion(word1, word2, i, j + 1),recursion(word1, word2, i + 1, j)));

            }
        }
    }
    public int minDistance(String word1, String word2) {
        return recursion(word1, word2, 0, 0);
    }
}