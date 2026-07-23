class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb=findLowerBound(nums,target);
        if(lb==nums.length || nums[lb]!=target) return new int[]{-1,-1};
        return new int[]{lb,findUpperBound(nums,target)-1};
    }

    public int findLowerBound(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }

    public int findUpperBound(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}