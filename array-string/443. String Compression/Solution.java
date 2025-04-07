class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int n = chars.length;
        while(i < n) {
            char c = chars[i];
            int groupLength = 0;
            while(i < n && chars[i] == c) {
                groupLength++;
                i++;
            }
            chars[j++] = c;
            if(groupLength > 1) {
                for(char digit: Integer.toString(groupLength).toCharArray()) {
                    chars[j++] = digit;
                }
            }
        }
        return j;
    }
}