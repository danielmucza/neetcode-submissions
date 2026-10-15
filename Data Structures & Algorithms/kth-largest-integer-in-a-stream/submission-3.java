class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }
    
    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
