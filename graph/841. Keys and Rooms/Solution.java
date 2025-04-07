class Solution {
    private void helper(List<List<Integer>> rooms, int currentRoom, boolean[] isVisited) {
        isVisited[currentRoom] = true;
        List<Integer> keys = rooms.get(currentRoom);

        for(int room: keys) {
            if(!isVisited[room]) {
                helper(rooms, room, isVisited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        helper(rooms, 0, isVisited);

        for(boolean i: isVisited) {
            if(!i) return false;
        }
        return true;
    }
}