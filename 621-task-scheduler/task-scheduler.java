class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for(char task:tasks ){
            ++frequency [task - 65];
        }
        Arrays.sort(frequency);
        int gap = frequency[25] -1;
        int idles = gap *n;
        for ( int i=24;i>=0;i--){
            if(frequency [i]==0 || idles==0){
                break;
            }
            idles -= Math.min(gap,frequency[i]);
        } 
        return tasks.length+ Math.max(idles,0);
    }
}