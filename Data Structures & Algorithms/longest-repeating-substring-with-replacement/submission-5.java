class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        Map<Character, Integer> frequencyByCharacter = new HashMap<>();
        int mostFrequentCharacterFrequency = 0;
        int longestSubstring = 0;
        for (int right = 0; right < s.length(); right++) {
            Character rightCharacter = s.charAt(right);
            frequencyByCharacter.put(rightCharacter, frequencyByCharacter.getOrDefault(rightCharacter, 0) + 1);
            mostFrequentCharacterFrequency = Math.max(mostFrequentCharacterFrequency, frequencyByCharacter.get(rightCharacter));
            while ((right - left + 1) - mostFrequentCharacterFrequency > k) {
                frequencyByCharacter.put(s.charAt(left), frequencyByCharacter.get(s.charAt(left)) - 1);
                left++;
            }
            longestSubstring = Math.max(longestSubstring, right - left + 1);
        }
        return longestSubstring;
    }
}
