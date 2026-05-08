class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // an int[] or list to sort cars by position desc
        // a list to track the fleets
        int[][] cars = new int[position.length][2];
        List<Double> arrivalTimes = new ArrayList<>();
        Double maxArrivalTime = 0.0;

        // create cars list and sort
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // calculate the number of fleets
        for (int[] car : cars) {
            double arrivalTime = (target - car[0]) / (double) car[1];
            if (arrivalTimes.isEmpty()) {
                arrivalTimes.add(arrivalTime);
                maxArrivalTime = arrivalTime;
            } else {
                if (arrivalTime > maxArrivalTime) {
                    arrivalTimes.add(arrivalTime);
                    maxArrivalTime = arrivalTime;
                }
            }
        }

        // return the number of fleets
        return arrivalTimes.size();
    }
}
