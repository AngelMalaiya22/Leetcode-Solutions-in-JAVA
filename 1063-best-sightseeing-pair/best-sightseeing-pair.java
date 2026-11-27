class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best = values[0];
        int ms = 0;
        for(int j = 1;j< values.length;j++){
            int s = best+values[j]-j;
            if(s>ms) ms = s;
            if(values[j]+j>best) best = values[j] + j;
        }
        return ms;
    }
}