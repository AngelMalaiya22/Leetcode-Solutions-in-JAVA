class Solution {
    // Days in each month for a non-leap year
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceStart = calculateDayOfYear(arriveAlice);
        int aliceEnd = calculateDayOfYear(leaveAlice);
        int bobStart = calculateDayOfYear(arriveBob);
        int bobEnd = calculateDayOfYear(leaveBob);

        int latestArrival = Math.max(aliceStart, bobStart);
        int earliestLeave = Math.min(aliceEnd, bobEnd);

        if (latestArrival <= earliestLeave) {
            return earliestLeave - latestArrival + 1;
        }

        return 0;
    }

    private int calculateDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += DAYS_IN_MONTHS[i];
        }

        return totalDays;
    }
}