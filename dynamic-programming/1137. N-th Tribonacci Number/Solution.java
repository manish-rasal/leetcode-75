class Solution {
    private Integer[] memo = new Integer[38];
    public int tribonacci(int n) {
        if(memo[n] != null) return memo[n];

        if(n < 2) return n;
        else if(n == 2) return n - 1;
        else {
            int t_n1 = tribonacci(n - 1);
            int t_n2 = tribonacci(n - 2);
            int t_n3 = tribonacci(n - 3);
            memo[n] = t_n1 + t_n2 + t_n3;
            return memo[n];
        }
    }
}