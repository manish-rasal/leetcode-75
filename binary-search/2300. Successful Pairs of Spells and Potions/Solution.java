class Solution {
    private int binarySearch(int spell, int[] potions, long success) {
        int m = potions.length;
        int i = 0, j = m - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            long currentSuccess = (long) spell * potions[mid];
            if(currentSuccess < success) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return m - i;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = binarySearch(spells[i], potions, success);
        }
        return result;
    }
}