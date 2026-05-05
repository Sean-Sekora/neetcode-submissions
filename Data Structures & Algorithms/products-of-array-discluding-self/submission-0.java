class Solution {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return new int[0];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
                postfix[length - 1] = nums[length - 1];
            } else {
                prefix[i] = nums[i] * prefix[i-1];
                postfix[length - 1 - i] = nums[length - 1 - i] * postfix[length - i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfix[i+1];
            } else if (i == length - 1) {
                result[i] = prefix[i-1];
            } else {
                result[i] = postfix[i+1] * prefix[i-1];
            }
        }

        return result;
    }
}  
