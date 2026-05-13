class Solution {
    public int findDuplicate(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        for (int num : nums) {
            if (seen.contains(num)) return num;
            seen.add(num);
        }
        return -1;
    }
}
