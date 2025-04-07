class Solution {
    private Integer memo[][] = new Integer[101][101];

    private int recursion(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) return 1;

        if (memo[i][j] != null) return memo[i][j];

        int right = 0, down = 0;
        if (i < m - 1) {
            down = recursion(m, n, i + 1, j);
        }
        if (j < n - 1) {
            right = recursion(m, n, i, j + 1);
        }

        return memo[i][j] = down + right;
    }

    public int uniquePaths(int m, int n) {
        return recursion(m, n, 0, 0);
    }
}