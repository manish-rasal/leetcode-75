class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        int n = words.length;
        int i = n - 1;
        while(i >= 0) {
            if(words[i] != "")
                result.append(words[i] + " ");
            i--;
        }
        return result.toString().trim();
    }
}