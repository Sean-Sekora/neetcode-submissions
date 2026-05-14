class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int[] point : points) {
            int distance = (point[0] * point[0]) + point[1] * point[1];
            heap.offer(new int[]{distance, point[0], point[1]});
            if (heap.size() >k) heap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] tmp = heap.poll();
            result[i] = new int[]{tmp[1], tmp[2]};
        }
        return result;
    }
}
