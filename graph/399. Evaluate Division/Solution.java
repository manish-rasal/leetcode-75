class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfs(graph, start, end, visited);
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited) {
        if (!graph.containsKey(current) || !graph.containsKey(target)) return -1.0;
        if (current.equals(target)) return 1.0;

        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            String next = neighbor.getKey();
            double weight = neighbor.getValue();
            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, visited);
                if (result != -1.0) return weight * result;
            }
        }

        return -1.0;
    }
}