class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
            if (right - left + 1 == k) {
                result.add(Collections.max(counts.keySet()));
                counts.put(nums[left], counts.get(nums[left]) - 1);
                if (counts.get(nums[left]) == 0) counts.remove(nums[left]);
                left++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
