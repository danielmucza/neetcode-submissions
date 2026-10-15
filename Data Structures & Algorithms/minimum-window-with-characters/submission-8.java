class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> frequencyByCharacterOfT = new HashMap<>();
        for (char c : t.toCharArray()) {
            frequencyByCharacterOfT.put(c, frequencyByCharacterOfT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = frequencyByCharacterOfT.size();
        int bestLeft = -1, bestRight = -1;
        int bestLength = Integer.MAX_VALUE;
        Map<Character, Integer> frequencyByCharacterOfS = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            frequencyByCharacterOfS.put(rightChar, frequencyByCharacterOfS.getOrDefault(rightChar, 0) + 1);

            boolean rightCharSatisfied = frequencyByCharacterOfT.containsKey(rightChar)
                && frequencyByCharacterOfT.get(rightChar).equals(frequencyByCharacterOfS.get(rightChar));
            if (rightCharSatisfied) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < bestLength) {
                    bestLength = right - left + 1;
                    bestLeft = left;
                    bestRight = right;
                }

                char leftChar = s.charAt(left);
                frequencyByCharacterOfS.put(leftChar, frequencyByCharacterOfS.getOrDefault(leftChar, 0) - 1);
                boolean leftCharDissatisfied = frequencyByCharacterOfT.containsKey(leftChar)
                    && frequencyByCharacterOfS.get(leftChar) < frequencyByCharacterOfT.get(leftChar);
                if (leftCharDissatisfied) {
                    have--;
                }
                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestRight + 1);
    }
}
