class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int max=findMax(mat,mid);
            int left=(mid-1>=0)?mat[max][mid-1]:-1;
            int right=(mid+1)<n?mat[max][mid+1]:-1;
            if(mat[max][mid]>left && mat[max][mid]>right) return new int[]{max,mid};
            else if(mat[max][mid]>left) low=mid+1;
            else high=mid-1;
        }
        return new int[]{-1, -1};
    }

    public int findMax(int[][] mat,int col){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
                max=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}