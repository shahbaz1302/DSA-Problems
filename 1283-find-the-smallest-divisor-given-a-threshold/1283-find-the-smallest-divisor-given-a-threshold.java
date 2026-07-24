class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=maxElement(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sum(nums,mid)>threshold) low=mid+1;
            else high=mid-1;
        }
        return low;
    }

    public static int sum(int[] arr,int val){
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=Math.ceil((double)arr[i]/(double)val);
        }
        return totalSum;
    }

    public static int maxElement(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) max = Math.max(max, bloomDay[i]);
        return max;
    }
}