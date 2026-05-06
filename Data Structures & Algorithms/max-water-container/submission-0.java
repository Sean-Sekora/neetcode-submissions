class Solution {
    public int maxArea(int[] heights) {
        if (heights.length <= 0) return 0;
        int left = 0;
        int right = heights.length - 1;
        int maxVolume = 0;

        while (left < right) {
            maxVolume = Math.max(maxVolume, Math.min(heights[left], heights[right]) * (right - left));

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxVolume;
    }
}
