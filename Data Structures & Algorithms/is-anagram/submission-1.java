class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterFrequencyOfS = new HashMap<>();
        Map<Character, Integer> characterFrequencyOfT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterFrequencyOfS.put(s.charAt(i), characterFrequencyOfS.getOrDefault(s.charAt(i), 0) + 1);
            characterFrequencyOfT.put(t.charAt(i), characterFrequencyOfT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return characterFrequencyOfS.equals(characterFrequencyOfT);

    }
}
