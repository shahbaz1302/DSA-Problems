class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length) return -1;
        int low=maxElement(nums);
        int high=sum(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sumElements(nums,mid)>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }

    public int sumElements(int[] nums,int mid){
        int elements=1,totalSum=0;
        for(int i=0;i<nums.length;i++){
            if(totalSum+nums[i]<=mid) totalSum+=nums[i];
            else{
                elements++;
                totalSum=nums[i];
            }
        }
        return elements;
    }

    public int sum(int[] arr){
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        return totalSum;
    }

    public int maxElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) max = Math.max(max, nums[i]);
        return max;
    }
}