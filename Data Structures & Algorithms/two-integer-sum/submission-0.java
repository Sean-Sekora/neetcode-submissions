class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        int left = 0;
        int right = 1;
        int length = nums.length;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            }

            if (right == length - 1) {
                left++;
                right = left + 1;
            } else {
                right++;
            }
        }

        return new int[0];
    }
}
