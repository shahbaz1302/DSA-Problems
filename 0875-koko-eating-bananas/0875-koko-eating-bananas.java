class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0;
        int high=findMax(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalHours=findHours(piles,mid);
            if(totalHours<=h) high=mid-1;
            else low=mid+1;
        }
        return low;
    }

    public static int findHours(int[] arr,int hourly){
        int totalHours=0;
        for(int i=0;i<arr.length;i++){
            totalHours+=Math.ceil((double)arr[i]/(double)hourly);
        }
        return totalHours;
    }

    public static int findMax(int[] piles) {
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>max) max=piles[i];
        }
        return max;
    }
}