class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int count : counts) {
            if (count > 0) heap.offer(count);
        }

        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                Integer task = heap.poll();
                task--;
                if (task > 0) queue.offer(new int[]{task, time + n});
            }
            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                heap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}
