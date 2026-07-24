class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int low=maxElement(weights);
        int high=sum(weights);
        while(low<=high){
            int mid=low+(high-low)/2;
            int daysRequired=findDays(weights,mid);
            if(daysRequired<=days) high=mid-1;
            else low=mid+1;
        }
        return low;
    }

    public static int findDays(int[] weights, int capacity) {
        int days=1,load=0;
        for (int i = 0; i < weights.length; i++) {
            if(load+weights[i]>capacity){
                days++;
                load=weights[i];
            }
            else load+=weights[i];
        }
        return days;
    }

    public static int maxElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) max = Math.max(max, nums[i]);
        return max;
    }

    public static int sum(int[] weights) {
        int sum=0;
        for (int i = 0; i < weights.length; i++) sum+=weights[i];
        return sum;
    }
}