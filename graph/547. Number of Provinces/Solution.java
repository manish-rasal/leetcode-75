class Solution {
    private void dfs(int[][] isConnected, int i, boolean[] isVisited, int n) {
        isVisited[i] = true;
        for(int j = 0; j < n; j++) {
            if(isConnected[i][j] == 1 && !isVisited[j]) {
                dfs(isConnected, j, isVisited, n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(isConnected, i, isVisited, n);
                provinces++;
            }
        }
        return provinces;
    }
}