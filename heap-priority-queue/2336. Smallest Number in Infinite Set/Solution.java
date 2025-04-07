class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;
    private int nextSmallest;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        nextSmallest = 1;
    }

    public int popSmallest() {
        if(!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if(num < nextSmallest && !set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */