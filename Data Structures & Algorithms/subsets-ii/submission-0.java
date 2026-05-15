class Solution {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        this.result = new ArrayList<>();
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<Integer> subset, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(subset, i+ 1);

        subset.removeLast();
        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        backtrack(subset, i + 1);
    }
}
