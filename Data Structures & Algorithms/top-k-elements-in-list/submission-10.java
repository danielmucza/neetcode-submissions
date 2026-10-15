class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequency = new HashMap<>();
        for (int num : nums) {
            numberToFrequency.put(num, numberToFrequency.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> numberToFrequencyOrdered = new PriorityQueue(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        numberToFrequencyOrdered.addAll(numberToFrequency.entrySet());

        int[] topKFrequentNumbers = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentNumbers[i] = numberToFrequencyOrdered.poll().getKey();
        }
        return topKFrequentNumbers;
    }
}
