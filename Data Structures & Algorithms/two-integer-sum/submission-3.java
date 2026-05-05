class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];


        int length = nums.length;
        int pointer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                if (i < map.get(remainder)) {
                    return new int[]{i, map.get(remainder)};
                } else {
                    return new int[]{map.get(remainder), i};
                }
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
