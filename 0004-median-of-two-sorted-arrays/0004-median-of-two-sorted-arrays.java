class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,count=0;
        int n1=nums1.length,n2=nums2.length;
        int n=n1+n2;
        int element1=-1;
        int element2=-1;
        int index2=n/2;
        int index1=index2-1;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                if(count==index1) element1=nums1[i];
                if(count==index2) element2=nums1[i];
                count++;
                i++;
            }
            else{
                if(count==index1) element1=nums2[j];
                if(count==index2) element2=nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1){
            if(count==index1) element1=nums1[i];
            if(count==index2) element2=nums1[i];
            count++;
            i++;
        }
        while(j<n2){
            if(count==index1) element1=nums2[j];
            if(count==index2) element2=nums2[j];
            count++;
            j++;
        }
        if(n%2==1) return element2;
        return (double)(element1+element2) /2.0;
    }
}