class Solution {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        this.result = new ArrayList<>();
        this.nums = nums;
        for (int num : nums) {
            dfs(new ArrayList<>(List.of(num)));
        }
        return result;
    }

    private void dfs(List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            dfs(current);
            current.removeLast();
        }
    }
}
