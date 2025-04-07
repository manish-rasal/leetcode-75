class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, 1});
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(new int[]{from, 0});
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int current, int parent, Map<Integer, List<int[]>> graph) {
        int changes = 0;
        for (int[] neighbor : graph.get(current)) {
            int next = neighbor[0], needsReversal = neighbor[1];
            if (next != parent) {
                changes += needsReversal + dfs(next, current, graph);
            }
        }
        return changes;
    }
}