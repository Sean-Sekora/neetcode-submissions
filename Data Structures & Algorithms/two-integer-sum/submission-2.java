class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];


        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int[][] sorted = new int[nums.length][2];

        for (int i = 0; i < length; i++) {
            sorted[i] = new int[]{nums[i], i};
        }

        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));

        while (left < right) {
            int sum = sorted[left][0] + sorted[right][0];
            if (sum == target) {
                if (sorted[left][1] < sorted[right][1]) {
                    return new int[]{sorted[left][1], sorted[right][1]};
                } else {
                    return new int[]{sorted[right][1], sorted[left][1]};
                }
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[0];
    }
}
