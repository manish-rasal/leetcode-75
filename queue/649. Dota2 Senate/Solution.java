class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> queue_r = new LinkedList<>();
        Queue<Integer> queue_d = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') queue_r.add(i);
            else queue_d.add(i);
        }

        while(true) {
            if(queue_r.isEmpty()) return "Dire";
            if(queue_d.isEmpty()) return "Radiant";

            int r = queue_r.poll();
            int d = queue_d.poll();

            if(r < d) {
                queue_r.add(r + n);
            } else {
                queue_d.add(d + n);
            }
        }
    }
}