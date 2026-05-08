class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        int length = heights.length;

        for (int i = 0; i < length; i++) {
            int height = heights[i];
            if (!stack.isEmpty() && height < stack.peek()[1]) {
                int startIndex = i;
                while(!stack.isEmpty() && height < stack.peek()[1]) {
                    int[] pop = stack.pop();
                    int area = (i - pop[0]) * pop[1];
                    maxArea = Math.max(maxArea, area);
                    startIndex = pop[0];
                }
                stack.push(new int[]{startIndex, height});
            } else {
                stack.push(new int[]{i, height});
            }
        }

        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            maxArea = Math.max(maxArea, (length - pop[0]) * pop[1]);
        }

        return maxArea;
    }
}
