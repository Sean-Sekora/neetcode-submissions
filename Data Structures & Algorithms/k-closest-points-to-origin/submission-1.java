class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> heap = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int[] point : points) {
            double distance = Math.sqrt((point[0] * point[0]) + point[1] * point[1]);
            heap.offer(new double[]{distance, point[0], point[1]});
            if (heap.size() >k) heap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            double[] tmp = heap.poll();
            result[i] = new int[]{(int)tmp[1], (int)tmp[2]};
        }
        return result;
    }
}
