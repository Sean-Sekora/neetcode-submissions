class Solution {
    List<List<Integer>> result;
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return new ArrayList<>();

        this.target = target;
        this.nums = candidates;
        Arrays.sort(nums);
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
        dfs(combination, total + nums[i], i + 1);

        combination.remove(combination.size() - 1);
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(combination, total, i + 1);
    }
}
