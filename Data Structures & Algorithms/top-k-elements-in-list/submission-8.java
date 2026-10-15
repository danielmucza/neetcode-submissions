class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequency = new HashMap<>();
        for (int num : nums) {
            numberToFrequency.put(num, numberToFrequency.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> numberToFrequencyPairs = new ArrayList<>(numberToFrequency.entrySet());
        Collections.sort(numberToFrequencyPairs, Map.Entry.<Integer, Integer>comparingByValue().reversed());

        int[] topKFrequentNumbers = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentNumbers[i] = numberToFrequencyPairs.get(i).getKey();
        }
        return topKFrequentNumbers;
    }
}
