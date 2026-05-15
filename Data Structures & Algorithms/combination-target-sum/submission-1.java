class Solution {
    int[] nums;
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums.length == 0) return new ArrayList<>();

        this.target = target;
        this.nums = nums;
        this.result = new ArrayList<>();
        dfs(new ArrayList<>(), 0, 0);
        return result;
    }

    private void dfs(List<Integer> combination, int total, int i) {
        if (total == target) {
            result.add(new ArrayList<>(combination));
            return;
        } else if (total > target || i == nums.length) {
            return;
        }

        combination.add(nums[i]);
        dfs(combination, total + nums[i], i);
        combination.remove(combination.size() - 1);
        dfs(combination, total, i + 1);
    }
}
