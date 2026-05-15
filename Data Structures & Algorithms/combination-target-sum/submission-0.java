class Solution {
    int[] nums;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums.length == 0) return new ArrayList<>();

        this.nums = nums;
        this.result = new ArrayList<>();
        dfs(new ArrayList<>(), target, 0);
        return result;
    }

    private void dfs(List<Integer> combination, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] <= target) {
                    List<Integer> tmp = new ArrayList<>(combination);
                    tmp.add(nums[i]);
                    dfs(tmp, target - nums[i], i);
                }
            }
        }
    }
}
