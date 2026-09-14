class Solution {

    private boolean isPossible(int[] weights, int days, int totalWeight) {

        int day = 1;
        int weight = 0;

        for (int w : weights) {
            if (w > totalWeight) {
                return false;
            }

            weight += w;

            if (weight > totalWeight) {
                day++;
                weight = w;
            }
        }

        return day <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int minimumWeight = 1;
        int maximumWeight = 0;

        for (int weight : weights) {
            maximumWeight += weight;
        } // O(N)

        while (minimumWeight <= maximumWeight) { // O(log N)
            int weight = minimumWeight + (maximumWeight - minimumWeight) / 2;

            boolean isWeightPossible = isPossible(weights, days, weight); // // O(N)

            if (isWeightPossible) {
                maximumWeight = weight - 1;
            }
            else {
                minimumWeight = weight + 1;
            }
        }  // // O(N * log N)

        return minimumWeight;
    }
}
