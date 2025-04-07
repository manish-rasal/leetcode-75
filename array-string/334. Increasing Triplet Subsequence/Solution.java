class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
        int num3;
        for(int i: nums) {
            num3 = i;
            if(num3 <= num1) num1 = num3;
            else if(num3 <= num2) num2 = num3;
            else return true;
        }
        return false;
    }
}