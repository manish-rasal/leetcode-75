class Solution {
    private Integer[][] memo = new Integer[50001][2];

    private int recursion(int[] prices, int fee, int i, int canBuy) {
        if(i == prices.length) return 0;

        if(memo[i][canBuy] != null) return memo[i][canBuy];

        int hold = recursion(prices, fee, i + 1, canBuy);
        int transaction = recursion(prices, fee, i + 1, canBuy ^ 1);
        if(canBuy == 1) {
            transaction -= prices[i];
        } else {
            transaction += prices[i] - fee;
        }
        return memo[i][canBuy] = Math.max(transaction, hold);
    }
    public int maxProfit(int[] prices, int fee) {
        return recursion(prices, fee, 0, 1);
    }
}