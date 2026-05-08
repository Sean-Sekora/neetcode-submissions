class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int minRate = right;

        while (left <= right) {
            int rate = left + (right - left) / 2;
            long time = 0;
            for(int pile : piles) {
                time += Math.ceil((double) pile / rate);
            }
            if (time <= h) {
                minRate = Math.min(minRate, rate);
                right = rate - 1;
            } else if (time > h) {
                left = rate + 1;
            }
        }

        return minRate;
    }
}
