class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int i: candies) {
            maxCandies = Math.max(maxCandies, i);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i: candies) {
            result.add(i + extraCandies >= maxCandies);
        }
        return result;
    }
}