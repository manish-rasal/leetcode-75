class Solution {

    private int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] isVisited = new boolean[m][n];
        isVisited[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int[] move: moves) {
                int new_i = cell[0] + move[0];
                int new_j = cell[1] + move[1];
                int dist = cell[2] + 1;
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && !isVisited[new_i][new_j] && maze[new_i][new_j] == '.') {
                    if(new_i == 0 || new_i == m - 1 || new_j == 0 || new_j == n - 1) {
                        return dist;
                    }
                    isVisited[new_i][new_j] = true;
                    queue.add(new int[]{new_i, new_j, dist});
                }
            }
        }
        return -1;
    }
}