class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberToIndex.containsKey(complement)) {
                return new int[]{ numberToIndex.get(complement), i };
            }
            numberToIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
