class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int empty = 0;
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] == 1) continue;
            if(n == 0) return true;
            if((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}