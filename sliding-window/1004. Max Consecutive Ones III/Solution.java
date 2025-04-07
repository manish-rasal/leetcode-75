class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int i = 0;
        int zeros = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}