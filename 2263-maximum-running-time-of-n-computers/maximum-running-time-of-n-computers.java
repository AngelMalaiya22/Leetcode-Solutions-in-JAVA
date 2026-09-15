class Solution {
    
    public boolean isPossible(int n, int[] batteries, long time) {
        long needPower = time * n;
        long availablePower = 0;

        for (int battery : batteries) {
            availablePower += Math.min((long) battery, time);
        }

        return availablePower >= needPower;
    }

    public long maxRunTime(int n, int[] batteries) {
        long totalPower = 0;
        for (int battery : batteries) {
            totalPower += battery;
        }

        long min = 0;
        long max = totalPower / n;
        long result = 0;

        while (min <= max) {
            long mid = min + (max - min) / 2;

            if (isPossible(n, batteries, mid)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }
}