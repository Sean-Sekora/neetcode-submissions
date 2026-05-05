class Solution {
    /*
        Use a heap for frequency count
        - loop to get the element count
        - add counts to heap
        - get k top counts
    */
    public int[] topKFrequent(int[] nums, int k) {
        // loop to get the element count
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // add counts to heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int key : counts.keySet()) {
            heap.offer(new int[]{key, counts.get(key)});
        }

        // get k top counts
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }

        return result;
    }
}
