class Solution {

    private void backtrack(String digits, int i, List<String> result, HashMap<Character, char[]> telephoneButtons, String letter) {
        if(letter.length() == digits.length()) {
            result.add(letter);
            return;
        }
        StringBuilder str = new StringBuilder(letter);
        char digit = digits.charAt(i);
        for(char c: telephoneButtons.get(digit)) {
            str.append(c);
            backtrack(digits, i + 1, result, telephoneButtons, str.toString());
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> telephoneButtons = new HashMap<>();
        telephoneButtons.put('2', new char[]{'a', 'b', 'c'});
        telephoneButtons.put('3', new char[]{'d', 'e', 'f'});
        telephoneButtons.put('4', new char[]{'g', 'h', 'i'});
        telephoneButtons.put('5', new char[]{'j', 'k', 'l'});
        telephoneButtons.put('6', new char[]{'m', 'n', 'o'});
        telephoneButtons.put('7', new char[]{'p', 'q', 'r', 's'});
        telephoneButtons.put('8', new char[]{'t', 'u', 'v'});
        telephoneButtons.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> result = new ArrayList<>();
        if(digits.equals("")) return result;
        backtrack(digits, 0, result, telephoneButtons, "");
        return result;
    }
}