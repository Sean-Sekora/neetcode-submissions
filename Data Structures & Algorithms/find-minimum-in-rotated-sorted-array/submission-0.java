class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int last = nums[right];
        int minValue = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            minValue = Math.min(minValue, nums[mid]);
            if (val > last) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minValue;
    }
}
