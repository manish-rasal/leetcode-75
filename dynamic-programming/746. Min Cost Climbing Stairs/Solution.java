class Solution {
    private Integer[] memo;

    private int recursion(int[] cost, int i) {
        if (i >= cost.length) return 0;

        if (memo[i] != null) return memo[i];

        int oneStep = recursion(cost, i + 1);
        int twoSteps = recursion(cost, i + 2);

        memo[i] = cost[i] + Math.min(oneStep, twoSteps);
        return memo[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        memo = new Integer[cost.length];
        return Math.min(recursion(cost, 0), recursion(cost, 1));
    }
}