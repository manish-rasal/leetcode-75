class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int i = 0;
        for(char c: t.toCharArray()) {
            if(i == n) return true;
            if(c == s.charAt(i)) i++;
        }
        return i == n;
    }
}