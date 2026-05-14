class KthLargest {

    private int k;
    private PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        Arrays.sort(nums);
        for (int i =(nums.length >= k) ? nums.length - k : 0; i < nums.length; i++) {
            this.heap.add(nums[i]);
        }
    }

    public int add(int val) {
        this.heap.add(val);
        while (this.heap.size() > k) this.heap.poll();
        return this.heap.peek();
    }
}
