class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);
        int index = 1;
        int maxStreak = 1;
        int streak = 1;

        while (index < nums.length) {
            if (nums[index - 1] == nums[index] - 1) {
                streak++;
                maxStreak = Math.max(maxStreak, streak);
            } else if (nums[index - 1] != nums[index]) {
                streak = 1;
            }
            index++;
        }

        return maxStreak;
    }
}
