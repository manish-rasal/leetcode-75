class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int i = 0, j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        while (pq1.size() < candidates && i <= j) {
            pq1.add(costs[i++]);
        }
        while (pq2.size() < candidates && i <= j) {
            pq2.add(costs[j--]);
        }

        while (k-- > 0) {
            if (pq1.isEmpty()) {
                cost += pq2.poll();
            } else if (pq2.isEmpty()) {
                cost += pq1.poll();
            } else {
                if (pq1.peek() <= pq2.peek()) {
                    cost += pq1.poll();
                    if (i <= j) pq1.add(costs[i++]);
                } else {
                    cost += pq2.poll();
                    if (i <= j) pq2.add(costs[j--]);
                }
            }
        }
        return cost;
    }
}