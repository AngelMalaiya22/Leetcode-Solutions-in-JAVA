class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min =1;
        int max = 0;
        for(int n : nums){
            max = Math.max(max,n);
        }
        while(min<=max){
            int mid = min+(max-min)/2;
            long count =0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]%mid==0){
                    count += (nums[i]/mid)-1;
                }else{
                    count += nums[i]/mid;
                }
            }
            if(count>maxOperations){
                min = mid +1;
            }else{
                max = mid -1;
            }

        }
        return min;
    }
}