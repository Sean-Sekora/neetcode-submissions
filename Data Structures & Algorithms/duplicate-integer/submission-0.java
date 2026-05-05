class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null) return false;

        Map<Integer, Boolean> seen = new HashMap<>();
        
        for (int num : nums) {
            if (seen.getOrDefault(num, false)) return true;
            seen.put(num, true);
        }

        return false;
    }
}