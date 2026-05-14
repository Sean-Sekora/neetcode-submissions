class MedianFinder {

    private final List<Integer> value;
    public MedianFinder() {
        this.value = new ArrayList<>();
    }

    public void addNum(int num) {
        value.add(num);
        Collections.sort(value);
    }

    public double findMedian() {
        int mid = (value.size() - 1) / 2;
        if (value.size() % 2 == 0) {
            double a = value.get(mid);
            double b = value.get(mid + 1);
            return (a + b) / 2;
        } else if (mid == 0) {
            return value.get(0);
        } else {
            return value.get(mid);
        }
    }
}
