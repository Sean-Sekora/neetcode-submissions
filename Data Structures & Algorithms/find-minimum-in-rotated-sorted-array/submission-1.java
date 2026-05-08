class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            minValue = Math.min(minValue, nums[mid]);
            if (val > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minValue;
    }
}
