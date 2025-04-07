class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(prefixSum[i] - nums[i] == prefixSum[n - 1] - prefixSum[i]) return i;
        }
        return -1;
    }
}