class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return optimized(strs);
    }

    public List<List<String>> naive(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            anagrams.computeIfAbsent(sortedStr, a -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }

    public List<List<String>> optimized(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            anagrams.computeIfAbsent(key, a -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
