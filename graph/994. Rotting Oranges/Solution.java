class Solution {
    private int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int time = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cell = queue.poll();
                for(int[] move: moves) {
                    int new_i = cell[0] + move[0];
                    int new_j = cell[1] + move[1];
                    if(new_i >= 0 && new_i < m && new_j >=0 && new_j < n && grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        fresh--;
                        queue.add(new int[]{new_i, new_j});
                    }
                }
            }
            time++;
        }

        return (fresh == 0)? time: -1;
    }
}