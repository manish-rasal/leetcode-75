class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int i) {
        if(combination.size() == k) {
            if(n == 0) result.add(new ArrayList<>(combination));
            return;
        }
        for(int num = i; num <= 9; num++) {
            combination.add(num);
            n -= num;
            backtrack(result, combination, k, n, num + 1);
            n += num;
            combination.remove(combination.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
}