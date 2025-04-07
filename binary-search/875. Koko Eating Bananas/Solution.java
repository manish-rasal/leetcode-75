class Solution {
    private int kokosEatingTime(int[] piles, int speed) {
        int time = 0;
        for(int pile: piles) {
            time += Math.ceil((double)pile / speed);
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 1000000000;
        int minSpeed = 1;
        while(maxSpeed >= minSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            int time = kokosEatingTime(piles, mid);
            if(time > h) {
                minSpeed = mid + 1;
            } else {
                maxSpeed = mid - 1;
            }
        }
        return minSpeed;
    }
}