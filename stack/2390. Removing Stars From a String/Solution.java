class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int starCount = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {
            char c = s.charAt(i);
            if(c == '*') {
                if(st.size() == 0) {
                    starCount++;
                } else {
                    st.pop();
                }
            } else {
                if(starCount > 0) {
                    starCount--;
                } else {
                    st.add(c);
                }
            }
            i++;
        }
        StringBuilder str = new StringBuilder();
        for(char c: st) {
            str.append(c);
        }
        return str.toString();
    }
}