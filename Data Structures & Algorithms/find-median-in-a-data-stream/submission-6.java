class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;
    public MedianFinder() {
        // Max-Heap so largest value is at this top
        this.smallHeap = new PriorityQueue<>((a,b) -> b - a);
        // Min-heap so the smallest value is at the top
        this.largeHeap = new PriorityQueue<>((a,b) -> a - b);
    }

    public void addNum(int num) {
        smallHeap.add(num);

        if (smallHeap.size() - largeHeap.size() > 1 || (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())) {
            largeHeap.add(smallHeap.poll());
        }

        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        } else if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else {
            return largeHeap.peek();
        }
    }
}
