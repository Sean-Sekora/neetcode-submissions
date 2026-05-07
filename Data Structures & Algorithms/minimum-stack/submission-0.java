class MinStack {
    private List<Integer> stack = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int val : stack) {
            min = Math.min(min, val);
        }
        return min;
    }
}
