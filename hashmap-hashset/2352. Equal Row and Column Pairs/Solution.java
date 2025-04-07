class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        if(n == 1) return 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++) {
                str.append(grid[i][j]);
                str.append(',');
            }
            String s = str.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int result = 0;

        for(int j = 0; j < n; j++) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < n; i++) {
                str.append(grid[i][j]);
                str.append(',');
            }
            String s = str.toString();
            result += map.getOrDefault(s, 0);
        }
        return result;
    }
}