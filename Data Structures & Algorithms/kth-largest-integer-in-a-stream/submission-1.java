class KthLargest {

    private int k;
    private List<Integer> nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>(Arrays.stream(nums).boxed().toList());
    }

    public int add(int val) {
        nums.add(val);
        Collections.sort(nums);
        return nums.get(nums.size() - k);
    }
}
