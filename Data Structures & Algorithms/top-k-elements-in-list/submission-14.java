class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyByNumber = new HashMap<>();
        for (int num : nums) {
            frequencyByNumber.put(num, frequencyByNumber.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucketsByFrequency = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            bucketsByFrequency.add(new ArrayList<>());
        }

        for (var entry : frequencyByNumber.entrySet()) {
            Integer number = entry.getKey();
            Integer frequency = entry.getValue();
            bucketsByFrequency.get(frequency).add(number);
        }

        int[] topKMostFrequentNumbers = new int[k];
        int topKMostFrequentNumbersIndex = 0;
        for (int frequency = bucketsByFrequency.size() - 1; frequency > 0; frequency--) {
            for (int number : bucketsByFrequency.get(frequency)) {
                topKMostFrequentNumbers[topKMostFrequentNumbersIndex] = number;
                topKMostFrequentNumbersIndex++;
                if (topKMostFrequentNumbersIndex == k) {
                    return topKMostFrequentNumbers;
                }
            }
        }
        return topKMostFrequentNumbers;
    }
}
