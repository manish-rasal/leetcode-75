class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int result = 0;
        for(int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i) + "")) result++;
        }

        int vowelCount = result;
        int n = s.length();
        for(int i = k; i < n; i++) {
            if(vowels.contains(s.charAt(i) + "")) vowelCount++;
            if(vowels.contains(s.charAt(i - k) + "")) vowelCount--;

            result = Math.max(result, vowelCount);
        }
        return result;
    }
}