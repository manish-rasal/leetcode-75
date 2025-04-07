class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        int n = ast.length;
        int i = 0;

        while(i < n) {
            if (!st.isEmpty() && st.peek() > 0 && ast[i] < 0) {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast[i])) {
                    st.pop();
                }

                if (!st.isEmpty() && st.peek() == Math.abs(ast[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(ast[i]);
                }
            } else {
                st.push(ast[i]);
            }
            i++;
        }
        int[] result = new int[st.size()];
        int j = 0;
        while (!st.isEmpty()) {
            result[j++] = st.pop();
        }

        for (int left = 0, right = result.length - 1; left < right; left++, right--) {
            int temp = result[left];
            result[left] = result[right];
            result[right] = temp;
        }

        return result;
    }
}
