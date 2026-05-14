class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num : nums) {
            this.heap.offer(num);
            if (this.heap.size() > k) this.heap.poll();
        }
    }

    public int add(int val) {
        this.heap.add(val);
        if (this.heap.size() > k) this.heap.poll();
        return this.heap.peek();
    }
}
