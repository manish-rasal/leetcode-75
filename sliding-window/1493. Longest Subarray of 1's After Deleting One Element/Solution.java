class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int result = 0, n = nums.length;
        int zeros = 0;
        for(int j = 0; j < n; j++) {
            if(nums[j] == 0) zeros++;

            while(zeros > 1) {
                if(nums[i] == 0) zeros--;
                i++;
            }

            result = Math.max(result, j - i);
        }

        return result;
    }
}