class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        return bs(nums,low,high,target);
    }

    public int bs(int[] arr,int low,int high,int target){
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]<target) return bs(arr,mid+1,high,target);
        else return bs(arr,low,mid-1,target);
    }
}