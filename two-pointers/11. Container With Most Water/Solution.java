class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0;
        while(i < j) {
            int volume = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, volume);
            if(height[i] > height[j]) j--;
            else i++;
        }
        return result;
    }
}