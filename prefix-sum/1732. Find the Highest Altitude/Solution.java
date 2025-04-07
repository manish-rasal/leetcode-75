class Solution {
    public int largestAltitude(int[] gains) {
        int highest = 0;
        int prev = 0;
        for(int gain: gains) {
            int curr = gain + prev;
            highest = Math.max(curr, highest);
            prev = curr;
        }
        return highest;
    }
}