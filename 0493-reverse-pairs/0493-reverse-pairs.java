class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortInPlace(nums,0,nums.length-1);
    }

    static int countPairs(int[] arr,int low,int mid,int high){
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i]>2L*arr[right]) right++;
            count+=right-(mid+1);
        }
        return count;
    }

    static int mergeSortInPlace(int[] arr,int low,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSortInPlace(arr,low,mid);
        count+=mergeSortInPlace(arr,mid+1,high);
        count+=countPairs(arr,low,mid,high);
        mergeInPlace(arr,low,mid,high);
        return count;
    }

    static void mergeInPlace(int[] arr,int low,int mid,int high) {
        int i=low,j=mid+1;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]) list.add(arr[i++]);
            else{
                list.add(arr[j++]);
            }
        }
        while(i<=mid) list.add(arr[i++]);
        while(j<=high) list.add(arr[j++]);
        for(int l = low; l <= high; l++) {
            arr[l] = list.get(l-low);
        }
    }
}