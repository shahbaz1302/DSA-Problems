class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]<=target && target<=matrix[i][n-1]) return binarySearch(matrix[i],target);
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return false;
    }
}