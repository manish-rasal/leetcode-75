class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        String prefix = "";

        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            result.add(getSuggestions(products, prefix));
        }

        return result;
    }

    private List<String> getSuggestions(String[] products, String prefix) {
        List<String> suggestions = new ArrayList<>();
        int start = binarySearch(products, prefix);
        int count = 0;

        for (int i = start; i < products.length && count < 3; i++) {
            if (products[i].startsWith(prefix)) {
                suggestions.add(products[i]);
                count++;
            } else {
                break;
            }
        }
        return suggestions;
    }

    private int binarySearch(String[] products, String prefix) {
        int low = 0, high = products.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}