class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        int fleets = 0;
        Double maxArrivalTime = 0.0;

        // create cars list and sort
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // calculate the number of fleets
        for (int[] car : cars) {
            double arrivalTime = (target - car[0]) / (double) car[1];
            if (fleets == 0) {
                fleets++;
                maxArrivalTime = arrivalTime;
            } else {
                if (arrivalTime > maxArrivalTime) {
                    fleets++;
                    maxArrivalTime = arrivalTime;
                }
            }
        }

        // return the number of fleets
        return fleets;
    }
}
