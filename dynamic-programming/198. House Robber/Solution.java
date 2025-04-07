class Solution {
    private Integer[] memo = new Integer[101];

    private int recursion(int[] nums, int i) {
        if(i >= nums.length) return 0;

        if(memo[i] != null) return memo[i];

        int twoSteps = recursion(nums, i + 2);
        int threeSteps = recursion(nums, i + 3);

        return memo[i] = nums[i] + Math.max(twoSteps, threeSteps);
    }
    public int rob(int[] nums) {
        return Math.max(recursion(nums, 0), recursion(nums, 1));
    }
}