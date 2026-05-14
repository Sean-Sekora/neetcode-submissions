class MedianFinder {

    private final List<Integer> data;
    public MedianFinder() {
        this.data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add(num);
        Collections.sort(data);
    }

    public double findMedian() {
        int n = data.size();
        if (n == 1) {
            return data.get(0);
        } else if (n % 2 == 0) {
            return (data.get(n/2) + data.get(n/2 - 1)) / 2.0;
        } else {
            return data.get(n/2);
        }
    }
}
